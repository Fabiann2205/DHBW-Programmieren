package de.dhbwka.java.exams.StadtLandFluss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Sheet {
    private Player player;
    private Game game;

    public Sheet(Player player, Game game) {
        this.player = player;
        this.game = game;

        // put these objects in a class scope if there are problems
        JFrame frame = new JFrame();
        JPanel topPane = new JPanel();
        JPanel centerPane = new JPanel();
        JPanel bottomPane = new JPanel();

        JLabel punkte = new JLabel("Punkte: " + this.player.getPoints());
        JLabel sekunden = new JLabel("Verbleibende Sekunden: ");
        JLabel buchstabe = new JLabel("Anfangsbuchstabe: ");
        topPane.setLayout(new GridLayout(3, 1));
        topPane.add(punkte);
        topPane.add(sekunden);
        topPane.add(buchstabe);

        // bottom
        bottomPane.setLayout(new GridLayout(1, 2));
        JButton startButton = new JButton("Start");
        ActionListener actionListener = e -> {
            System.out.println("Button was pressed!");
        };
        startButton.addActionListener(actionListener);
        startButton.setEnabled(true);
        bottomPane.add(startButton);

        JButton stopButton = new JButton("Button");
        ActionListener actionListener2 = e -> {
            System.out.println("Button was pressed!");
        };
        stopButton.addActionListener(actionListener2);
        stopButton.setEnabled(false);
        bottomPane.add(stopButton);


        JLabel label = new JLabel("Kein Spiel aktiv");
        centerPane.add(label);
        frame.setLayout(new BorderLayout());
                        /* other Layouts:
                            - BorderLayout
                            - BoxLayout
                            - CardLayout
                            - FlowLayout
                            - GridBagLayout
                            - GridLayout
                            - GroupLayout
                         */

        frame.add(topPane, BorderLayout.NORTH);
        frame.add(centerPane, BorderLayout.CENTER);
        frame.add(bottomPane, BorderLayout.SOUTH);

        frame.setTitle(this.player.getName());
        // frame.setSize(1000, 500);
        frame.pack(); // auto sizing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public void inform() {

    }

    public static void main(String[] args) {
        new Sheet(new Player("hans"), new Game(3, 7, 20));
    }
}
