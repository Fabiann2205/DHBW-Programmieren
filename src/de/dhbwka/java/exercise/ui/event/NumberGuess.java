package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Random;

public class NumberGuess implements ActionListener {
    final JFrame frame;
    int zumraten;
    final JButton newgame;
    final JButton ok;
    final JButton bestplayer;
    final JButton exit;
    final Random random = new Random();
    final JLabel ergebnis;
    int versuche = 0;
    final JTextField playernamefield;
    final JTextField numberfield;
    Boolean fertig = false;

    public NumberGuess() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(5, 5));


        //TOP
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(2, 2, 2, 2));
        JLabel playername = new JLabel("Player name: ");
        playernamefield = new JTextField("Player name");
        JLabel number = new JLabel("Enter number between 1 and 1000: ");
        numberfield = new JTextField("Number");
        top.add(playername);
        top.add(playernamefield);
        top.add(number);
        top.add(numberfield);
        frame.add(top, BorderLayout.NORTH);

        //CENTER
        JPanel center = new JPanel();
        newgame = new JButton("New Game");
        ok = new JButton("Ok");
        bestplayer = new JButton("Best player");
        exit = new JButton("Exit");
        newgame.addActionListener(this);
        ok.addActionListener(this);
        bestplayer.addActionListener(this);
        exit.addActionListener(this);
        center.add(newgame);
        center.add(ok);
        center.add(bestplayer);
        center.add(exit);
        frame.add(center, BorderLayout.CENTER);

        //BOTTOM
        ergebnis = new JLabel("PRESS NEW GAME TO BEGIN!");
        frame.add(ergebnis, BorderLayout.SOUTH);


        frame.pack();
        frame.setTitle("NumberGuess");
        frame.setMinimumSize(new Dimension(300, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new NumberGuess();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newgame) {
            fertig = false;
            versuche = 0;
            zumraten = (random.nextInt(1000) + 1);
            ergebnis.setText("Attempt 1: bitte eingeben und ok klicken");
            playernamefield.setEditable(false);
        } else if (e.getSource() == ok) {
            versuche++;
            if (Integer.parseInt(numberfield.getText()) == zumraten && !fertig) {
                ergebnis.setText("Attempt " + versuche + ": Richtig Spieler " + playernamefield.getText());
                fertig = true;
                playernamefield.setEditable(true);
            } else if (Integer.parseInt(numberfield.getText()) <= zumraten && !fertig) {
                ergebnis.setText("Attempt " + versuche + ": zu niedrig Spieler " + playernamefield.getText());
            } else if (Integer.parseInt(numberfield.getText()) >= zumraten && !fertig) {
                ergebnis.setText("Attempt " + versuche + ": zu groß Spieler " + playernamefield.getText());
            } else {
                ergebnis.setText("Starte ein neues game!!!");
            }
        } else if (e.getSource() == bestplayer) {

        } else if (e.getSource() == exit) {
            System.exit(0);
        } else {
            throw new UnsupportedAddressTypeException();
        }
    }
}
