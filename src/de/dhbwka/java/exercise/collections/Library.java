package de.dhbwka.java.exercise.collections;

import de.dhbwka.java.exercise.collections.comparators.authorComparator;
import de.dhbwka.java.exercise.collections.comparators.publisherComparator;
import de.dhbwka.java.exercise.collections.comparators.titleComparator;
import de.dhbwka.java.exercise.collections.comparators.yearComparator;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Library {
    JFrame frame;
    JTextField titlefield;
    JTextField authorfield;
    JTextField yearfield;
    JTextField publisherfield;
    List<String> textBibliothek = new ArrayList<>();
    public void ui () {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(5, 5));

        JPanel topPanel = new JPanel(new GridLayout(4, 2));
        topPanel.add(new JLabel("Title"));
        titlefield = new JTextField("Title");
        topPanel.add(titlefield);
        topPanel.add(new JLabel("Author"));
        authorfield = new JTextField("Author");
        topPanel.add(authorfield);
        topPanel.add(new JLabel("Year"));
        yearfield = new JTextField("Year");
        topPanel.add(yearfield);
        topPanel.add(new JLabel("Publisher"));
        publisherfield = new JTextField("Publisher");
        topPanel.add(publisherfield);
        frame.add(topPanel, BorderLayout.NORTH);

        JButton saveEntry = new JButton("Save entry");
        frame.add(saveEntry, BorderLayout.CENTER);
        saveEntry.addActionListener(e -> {
            textBibliothek.add(this.titlefield.getText()+ ";"+this.authorfield.getText()+ ";"+this.yearfield.getText()+ ";"+this.publisherfield.getText());
            this.saveFile("bibliothek.txt", textBibliothek);
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Ordered output:"));

        JButton title = new JButton("Title");
        title.addActionListener(e -> this.showPopup(2, textBibliothek));
        bottomPanel.add(title);

        JButton author = new JButton("Author");
        author.addActionListener(e -> this.showPopup(3, textBibliothek));
        bottomPanel.add(author);

        JButton year = new JButton("Year");
        year.addActionListener(e -> this.showPopup(1, textBibliothek));
        bottomPanel.add(year);

        JButton publisher = new JButton("Publisher");
        publisher.addActionListener(e -> this.showPopup(4, textBibliothek));
        bottomPanel.add(publisher);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setTitle("Currency converter");
        frame.setMinimumSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        textBibliothek = this.readFile("bibliothek.txt");

    }
    public List<String> readFile(String file) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            return lines;
        } catch (Exception e) {
            System.err.println("Fehler beim lesen!");
            return null;
        }
    }

    public void saveFile(String file, List<String> values) {
        StringBuilder toWrite = new StringBuilder();
        for (String wert : values) {
            toWrite.append(wert).append("\n");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(toWrite.toString());
        } catch (Exception e) {
            System.err.println("Fehler beim schreiben!");
        }
    }


    public void showPopup(int outputType, List<String> werte) {
        switch (outputType) {
            case 1 -> werte.sort(new yearComparator());
            case 2 -> werte.sort(new titleComparator());
            case 3 -> werte.sort(new authorComparator());
            case 4 -> werte.sort(new publisherComparator());
            default -> {
            }
        }
        JOptionPane.showMessageDialog(null, werte.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(";", " ").replaceAll(",", "\n"));
    }

    public static void main(String[] args) {
        Library buecher = new Library();
        buecher.ui();
    }
}
