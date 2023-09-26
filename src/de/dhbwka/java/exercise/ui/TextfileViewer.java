package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextfileViewer {
    final String dateiname;
    final int breite;
    final int hoehe;

    final JFrame frame;

    public TextfileViewer(String dateiname, int breite, int hoehe) {
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
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION) {
            System.out.println(fc.getSelectedFile().getAbsolutePath());
            new TextfileViewer(fc.getSelectedFile().getAbsolutePath(), 1000, 500);
        } else {
            System.out.println("No selection");
        }
    }
}
