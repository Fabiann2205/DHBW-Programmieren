package de.dhbwka.java.exams.darts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import de.ownclasses.TextFile;

// Teilaufgabe e
public class Game {
    // one Leg
    Player[] players;
    Board board;

    public Game(Board board, Player[] players) {
        this.players = players;
        this.board = board;
    }

    public void start() {
        Boolean run = true;
        Scanner input = new Scanner(System.in);
        String eingabe;
        // Field[] getroffene;
        List<Field> getroffene;
        String[] vorher;
        int player = 0;
        int points;
        while (run) {
            System.out.println(player);
            // input auslesen
            System.out.println("Player: " + players[player].getName() + ", " + players[player].getRemainingPoints()
                    + " points remaining.");
            System.out.print("Enter visit: ");
            eingabe = input.nextLine();
            vorher = new String[3];
            vorher = eingabe.split(" ");
            points = 0;
            getroffene = new ArrayList<>();
            // NULL Werte: aufpassen!!!
            for (int i = 0; i < vorher.length; i++) {
                getroffene.add(this.board.parseField(String.valueOf(vorher[i])));
                points += getroffene.get(i).getValue();
            }
            if (getroffene.size() == 2) {
                getroffene.add(this.board.parseField(String.valueOf("x")));
            } else if (getroffene.size() == 1) {
                getroffene.add(this.board.parseField(String.valueOf("x")));
                getroffene.add(this.board.parseField(String.valueOf("x")));
            } else if (getroffene.size() == 0) {
                getroffene.add(this.board.parseField(String.valueOf("x")));
                getroffene.add(this.board.parseField(String.valueOf("x")));
                getroffene.add(this.board.parseField(String.valueOf("x")));
            }

            // neuen Visit erstellen
            // arraylist konvertiert nicht richtig
            if (players[player].addVisit(new Visit(getroffene.toArray(new Field[getroffene.size()])))) {
                System.out.println("Erfolgreich hinzugefügt!");
            } else {
                System.out.println("Überworfen!");
            }
            System.out.println("Scored: " + points + "\n-----------------------------------");
            // spiel beenden
            for (int i = 0; i < players.length; i++) {
                if (players[i].getRemainingPoints() == 0) {
                    run = false;
                    System.out.println("Game shot and the leg, " + players[player].getName() + "!");
                }
                if (players[i].getVisits().length >= 10) {
                    run = false;
                    System.out.println("You are too bad for this game!");
                }
            }

            if (player < (players.length - 1)) {
                player++;
            } else {
                player = 0;
            }
        }
        input.close();
        String pathname = "resources/highscore.txt";
        TextFile text = new TextFile(pathname);
        if (player == 0) {
            player = players.length;
        } else {
            player--;
        }
        text.addLine(players[player].getName() + " won with " + players[player].getCountDartsThrown() + " darts.");
        text.write();
        text.close();
    }

    public static void main(String[] args) {
        final Board b = new Board();

        final Player[] players = new Player[] { new Player("Michael van Gerwen"), new Player("Rob Cross")
        };

        final Game g = new Game(b, players);
        g.start();
    }
}
// allen spielern werden immer alle visits hinzugefügt ab der 2. runde; bei
// remaining immer das letzte nur vom anderen spieler??
