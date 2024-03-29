package de.dhbwka.java.exams.coronaWarn;

import exam.ownclasses.TextFile;

import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CoronaWarn {

    /**
     * Application entry point for CoronaWarn GIVEN!!!
     *
     * @param args command line arguments, not used here
     */
    public static void main(String[] args) {
        try {
            // Only necessary on MacOS to prevent color issues with standard look
            // and feel.
            // Redundant on other operation systems - they use this look and feel
            // by default.
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        JPhone phone1 = new JPhone("0123-4567", "Markus");
        JPhone phone2 = new JPhone("9876-5432", "Angela");
        JPhone phone3 = new JPhone("4711-0815", "Olaf");

        CoronaWarnTerm client1 = new CoronaWarnTerm(phone1);
        CoronaWarnTerm client2 = new CoronaWarnTerm(phone2);
        CoronaWarnTerm client3 = new CoronaWarnTerm(phone3);

        CoronaWarnAPI.registerClients(client1, client2, client3);
    }

    /**
     * Clear token store for phone
     *
     * @param phone phone to clear store for
     */
    public static void clearTokenStore(JPhone phone) {
        new TextFile("resources/" + phone.id() + "-tokens.txt").deleteFile();
    }

    /**
     * Load tokens for phone
     *
     * @param phone phone to load tokens for
     * @return loaded tokens
     */
    public static List<Token> loadTokens(JPhone phone) {
        List<Token> tokens = new LinkedList<>();
        List<String> data;
        try {
            data = new TextFile("resources/" + phone.id() + "-tokens.txt").getAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : data) {
            tokens.add(CoronaWarn.parseToken(line));
        }
        return tokens;
    }

    /**
     * Save token for provided phone
     *
     * @param phone phone to save token for
     * @param token token to save
     */
    public static void saveToken(JPhone phone, Token token) {
        String line = token.getValue() + ";" + token.getDate().getTime();
        new TextFile("resources/" + phone.id() + "-tokens.txt").addLine(line);
    }

    /**
     * Parse a token line
     *
     * @param line token line to parse
     * @return parsed token instance
     */
    private static Token parseToken(String line) {
        String[] parts = line.split("[;]");
        if (parts.length == 2) {
            try {
                return new Token(parts[0],
                        new Date(Long.parseLong(parts[1])));
            } catch (Exception e) {
                System.err.println("Error parsing token line: " + line);
            }
        }
        return null;
    }
}
