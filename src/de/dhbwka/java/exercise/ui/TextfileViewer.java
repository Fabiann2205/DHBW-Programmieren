package de.dhbwka.java.exercise.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class TextfileViewer {
    String dateiname;
    int breite, hoehe;

    JFrame frame; 
    public TextfileViewer(String dateiname, int breite, int hoehe) {
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

        if (state == JFileChooser.APPROVE_OPTION){ 
            System.out.println(fc.getSelectedFile().getAbsolutePath());
            new TextfileViewer(fc.getSelectedFile().getAbsolutePath(), 1000, 500);
        } else {
            System.out.println("No selection");
        }
    }
}
