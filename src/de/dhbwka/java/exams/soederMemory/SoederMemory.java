package de.dhbwka.java.exams.soederMemory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Memory with images of Markus S&ouml;der
 */
public class SoederMemory {

    /**
     * Application main entry point
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Only necessary on MacOS to prevent color issues with standard look and feel.
            // Redundant on other operation systems - they use this look and feel by default.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        try {
            final List<Player> players = new ArrayList<>();
            players.add(new Player("Angela"));
            players.add(new Player("Andrea"));
            players.add(new Player("Horst"));

            final Random r = new Random();
            final int cols = r.nextInt(3) + 2; // min 2, max 4
            final int rows = r.nextInt(3) + 2; // min 2, max 4
            final MemoryGame game = new MemoryGame(players, MemoryImages.getImages(), rows, cols);

            new MemoryGameTerm(game);
        } catch (final Exception e) {
            System.err.println("Error" + e);
        }
    }

}
