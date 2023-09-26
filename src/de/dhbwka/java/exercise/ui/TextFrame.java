package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

public class TextFrame {
    final String dateiname;
    final int breite;
    final int hoehe;

    final JFrame frame;

    public TextFrame(String dateiname, int breite, int hoehe) {
        this.dateiname = dateiname;
        this.breite = breite;
        this.hoehe = hoehe;

        frame = new JFrame();

        JTextArea textArea = new JTextArea();
        try {
            textArea.read(new FileReader(this.dateiname), "hallo");
        } catch (NumberFormatException | IOException e) {
            System.err.println("Error" + e);
        }
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(scrollPane);

        frame.setTitle(this.dateiname);
        frame.setSize(this.breite, this.hoehe);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        if (args.length == 3) {
            new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        } else if (args.length == 2) {
            new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[1]));
        } else if (args.length == 1) {
            new TextFrame(args[0], 1000, 500);
        } else {
            System.out.println("Falsche Parameter!");
        }
    }
}
