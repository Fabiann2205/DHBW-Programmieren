package de.dhbwka.java.exams.FasidWorldCup;

import exam.ownclasses.TextFile;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FasidWorldCup {


    public static void main(String[] args) {
        List<Match> matches = FasidWorldCup.loadMatches("fasid-matches.csv");

        Player[] players = new Player[]{
                new Player("Franz"),
                new Player("Lothar")
        };
        try {
            new FasidTerm(matches, players);
        } catch (FasidException fe) {
            JOptionPane.showMessageDialog(null, "Fehler: " + fe.getMessage());
        }
    }

    private static List<Match> loadMatches(String filename) {
        List<Match> matches = new LinkedList<>();
        TextFile file = new TextFile("resources/fasid-matches.csv");
        List<String> textDatei = new ArrayList<>();
        try {
            textDatei = file.getAllLines();
        } catch (IOException ignored) {
        }
        // REPLACE THE CODE BELOW!
        for (String s : textDatei) {
            matches.add(FasidWorldCup.parseMatch(s));
        }


        /*for (int i = 1; i <= 25; i++) {
            matches.add(FasidWorldCup.parseMatch(String.format("Home %d;Guest %d;Matchdate %d;13:37 Uhr MEZ;Stadium Name;", i, i, i)));
        }*/
        // REPLACE THE CODE ABOVE!

        return matches;
    }

    private static Match parseMatch(String s) {
        if (s != null) {
            String[] parts = s.trim().split(";");
            if (parts.length == 6) {
                return new Match(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            }
            if (parts.length == 5) {
                return new Match(parts[0], parts[1], parts[2], parts[3], parts[4], null);
            }
        }
        return null;
    }
}
