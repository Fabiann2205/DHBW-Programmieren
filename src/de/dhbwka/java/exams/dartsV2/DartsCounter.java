package de.dhbwka.java.exams.dartsV2;

import java.util.ArrayList;
import java.util.List;

/**
 * Darts counter application
 */
public class DartsCounter {

    /**
     * Application entry point
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        final Board b = new Board();

        final List<Player> players = new ArrayList<>();
        players.add(new Player("Michael van Gerwen"));
        players.add(new Player("Rob Cross"));


        final Game g = new Game(b, players);
        g.start();

    }

}
