package de.dhbwka.java.exams.dartsV2;

import exam.ownclasses.TextFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Player> players;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }


    public void start() {
        String currentValue;
        String[] splitted;
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = this.players.get(0);
        int indexPlayer = 0;
        boolean running = true;
        boolean reason = false;
        Player playerWin = null;
        TextFile checkouts = new TextFile("resources/checkouts.txt");

        while (running) {
            System.out.println("Player: " + currentPlayer.getName() + ", " + currentPlayer.getRemainingPoints() + " points remaining.");

            if (currentPlayer.getRemainingPoints() <= 170) {
                try {
                    System.out.println("One way to checkout is: " + checkouts.getLine(currentPlayer.getRemainingPoints() - 1));
                } catch (IOException ignored) {
                }
            }

            System.out.print("Enter visit: ");
            currentValue = scanner.nextLine();

            splitted = currentValue.split(" ");
            List<Field> fields = new ArrayList<>();
            for (String s : splitted) {
                if (this.board.parseField(s) != null) {
                    fields.add(this.board.parseField(s));
                }
            }
            if (currentPlayer.addVisit(new Visit(fields))) {
                System.out.println("Erfolgreich: " + currentPlayer.getVisits().get(currentPlayer.getVisits().size() - 1).getValue());
            } else {
                System.out.println("Überworfen!");
            }
            System.out.println("----------------------------------------------");

            indexPlayer++;
            if (indexPlayer >= this.players.size()) {
                indexPlayer = 0;
            }
            currentPlayer = this.players.get(indexPlayer);

            for (Player p : players) {
                if (p.getRemainingPoints() == 0) {
                    running = false;
                    playerWin = p;
                }
            }
            if (this.players.get(this.players.size() - 1).getVisits().size() == 10) {
                running = false;
                reason = true;
            }
        }
        if (reason) {
            System.out.println("You are too bad for this game!");
        } else {
            System.out.println("Game shot and the leg, " + playerWin.getName());
            TextFile file = new TextFile("resources/highscore.txt");
            file.addLine(playerWin.getName() + " won with " + playerWin.getCountDartsThrown() + " darts.");
        }
    }
}
