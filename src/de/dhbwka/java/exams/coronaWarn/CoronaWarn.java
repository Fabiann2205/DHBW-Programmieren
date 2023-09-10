package de.dhbwka.java.exams.coronaWarn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import de.dhbwka.java.exams.coronaWarn.CoronaWarnAPI;

public class CoronaWarn {

    /**
     * Application entry point for CoronaWarn GIVEN!!!
     *
     * @param args
     *           command line arguments, not used here
     */
    public static void main( String[] args ) {
        try {
            // Only necessary on MacOS to prevent color issues with standard look
            // and feel.
            // Redundant on other operation systems - they use this look and feel
            // by default.
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch ( final Exception e ) {
        }

        JPhone phone1 = new JPhone( "0123-4567", "Markus" );
        JPhone phone2 = new JPhone( "9876-5432", "Angela" );
        JPhone phone3 = new JPhone( "4711-0815", "Olaf" );

        CoronaWarnTerm client1 = new CoronaWarnTerm( phone1 );
        CoronaWarnTerm client2 = new CoronaWarnTerm( phone2 );
        CoronaWarnTerm client3 = new CoronaWarnTerm( phone3 );

        CoronaWarnAPI.registerClients( client1, client2, client3 );
    }

    /**
     * Clear token store for phone
     *
     * @param phone
     *           phone to clear store for
     */
    public static void clearTokenStore( JPhone phone ) {
        File file = new File( phone.getId() + "-tokens.txt" );
        if ( file.exists() ) {
            file.delete();
        }
    }

    /**
     * Load tokens for phone
     *
     * @param phone
     *           phone to load tokens for
     *
     * @return loaded tokens
     */
    public static List<Token> loadTokens( JPhone phone ) {
        String filename = phone.getId() + "-tokens.txt";
        List<Token> tokens = new LinkedList<>();
        File f = new File( filename );
        if ( f.exists() ) {
            try ( BufferedReader br =
                          new BufferedReader( new FileReader( filename ) ) ) {
                String line;
                while ( (line = br.readLine()) != null ) {
                    tokens.add( CoronaWarn.parseToken( line ) );
                }
            } catch ( Exception e ) {
            }
        }
        return tokens;
    }

    /**
     * Save token for provided phone
     *
     * @param phone
     *           phone to save token for
     * @param token
     *           token to save
     */
    public static void saveToken( JPhone phone, Token token ) {
        String filename = phone.getId() + "-tokens.txt";
        String line = token.getValue() + ";" + token.getDate().getTime();

        try ( BufferedWriter bw =
                      new BufferedWriter( new FileWriter( filename, true ) ) ) {
            bw.write( line );
            bw.newLine();
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog( null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Parse a token line
     *
     * @param line
     *           token line to parse
     *
     * @return parsed token instance
     */
    private static Token parseToken( String line ) {
        String[] parts = line.split( "[;]" );
        if ( parts.length == 2 ) {
            try {
                return new Token( parts[0],
                        new Date( Long.parseLong( parts[1] ) ) );
            } catch ( Exception e ) {
                System.err.println( "Error parsing token line: " + line );
                e.printStackTrace();
            }
        }
        return null;
    }
}
