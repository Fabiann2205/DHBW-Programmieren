package de.dhbwka.java.exercise.ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextFrame {
    String dateiname;
    int breite, hoehe;

    JFrame frame;    

    public TextFrame(String dateiname, int breite, int hoehe) {
        this.dateiname = dateiname;
        this.breite = breite;
        this.hoehe = hoehe;

        frame = new JFrame();

        JTextArea textArea = new JTextArea();
        try {
            textArea.read(new FileReader(this.dateiname), "hallo");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(scrollPane);

        frame.setTitle(this.dateiname);
        frame.setSize(this.breite, this.hoehe);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }



    public static void main(String[] args) {
        if (args.length ==3) {
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
