package de.dhbwka.java.exercise.ui.editor;

import de.dhbwka.java.exercise.io.IOErrorInFile;
import de.dhbwka.java.exercise.io.LineNumberOutOfBoundsException;
import de.dhbwka.java.exercise.io.TextFile;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.ArrayList;

public class EditorSimple {
    final JFrame frame;
    JTextPane editPane;
    TextFile datei1;

    public EditorSimple() {
        frame = new JFrame();

        JMenuBar bar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        JMenu bearbeiten = new JMenu("Bearbeiten");
        JMenu sendenan = new JMenu("Senden an");
        JMenuItem item1 = new JMenuItem("Neu");
        item1.addActionListener(e -> editPane.setText(""));
        JMenuItem item2 = new JMenuItem("Mail");
        JMenuItem item3 = new JMenuItem("WhatsApp");
        JMenuItem item4 = getjMenuItem();
        JMenuItem item5 = new JMenuItem("Schließen");
        item5.addActionListener(e -> {
            editPane.setText("");
            datei1.close();
        });
        JMenuItem item6 = getItem6();
        JMenuItem item7 = new JMenuItem("Rückgängig");
        JMenuItem item8 = new JMenuItem("Wiederholen");

        sendenan.add(item2);
        sendenan.add(item3);

        datei.add(item1);
        datei.add(item4);
        datei.add(item5);
        datei.add(sendenan);
        datei.add(item6);

        bearbeiten.add(item7);
        bearbeiten.add(item8);

        bar.add(datei);
        bar.add(bearbeiten);

        frame.setJMenuBar(bar);

        editPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(editPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        frame.setTitle("Editor");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JMenuItem getItem6() {
        JMenuItem item6 = new JMenuItem("Speichern");
        item6.addActionListener(e -> {
            for (int h = 1; h <= datei1.availableLines(); h++) {
                try {
                    datei1.setLine(h, "");
                } catch (LineNumberOutOfBoundsException e1) {
                    System.err.println("Error" + e1);
                }
            }
            try {
                datei1.setLine(1, editPane.getText());
            } catch (LineNumberOutOfBoundsException e1) {
                System.err.println("Error" + e1);
            }
            datei1.write();
        });
        return item6;
    }

    private JMenuItem getjMenuItem() {
        JMenuItem item4 = new JMenuItem("Öffnen");
        item4.addActionListener(e -> {
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
                try {
                    datei1 = new TextFile(fc.getSelectedFile().getAbsolutePath());
                } catch (IOErrorInFile e1) {
                    System.err.println("Error" + e1);
                }
                try {
                    datei1.read();
                } catch (IOErrorInFile e1) {
                    System.err.println("Error" + e1);
                }
                StringBuilder test = new StringBuilder();
                ArrayList<String> array = datei1.getLines();
                for (String s : array) {
                    test.append(s).append("\n");
                }
                editPane.setText(test.toString());
            } else {
                System.out.println("No selection");
            }
        });
        return item4;
    }

    public static void main(String[] args) {
        new EditorSimple();
    }
}



