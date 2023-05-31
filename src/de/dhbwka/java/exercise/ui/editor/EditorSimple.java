package de.dhbwka.java.exercise.ui.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import de.dhbwka.java.exercise.io.IOErrorInFile;
import de.dhbwka.java.exercise.io.LineNumberOutOfBoundsException;
import de.dhbwka.java.exercise.io.TextFile;

public class EditorSimple {
    JFrame frame;
    JTextPane editPane;
    int i;
    TextFile datei1;
    String[] text;
    public EditorSimple() {
        frame = new JFrame();

        JMenuBar bar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        JMenu bearbeiten = new JMenu("Bearbeiten");
        JMenu sendenan = new JMenu("Senden an");
        JMenuItem item1 = new JMenuItem("Neu");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPane.setText("");
            }
            
        });
        JMenuItem item2 = new JMenuItem("Mail");
        JMenuItem item3 = new JMenuItem("WhatsApp");
        JMenuItem item4 = new JMenuItem("Öffnen");
        item4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
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
                    try {
                        datei1 = new TextFile(fc.getSelectedFile().getAbsolutePath());
                    } catch (IOErrorInFile e1) {
                        e1.printStackTrace();
                    }
                    try {
                        datei1.read();
                    } catch (IOErrorInFile e1) {
                        e1.printStackTrace();
                    }
                    String test = "";
                    ArrayList<String> array = datei1.getLines();
                    for ( String s : array) {
                        test += (s + "\n");
                    }
                    editPane.setText(test);
                } else {
                    System.out.println("No selection");
                }
            }
            
        });
        JMenuItem item5 = new JMenuItem("Schließen");
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPane.setText("");
                datei1.close();
            }
            
        });
        JMenuItem item6 = new JMenuItem("Speichern");
        item6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for(int h = 1; h <= datei1.availableLines(); h++) {
                    try {
                        datei1.setLine(h, "");
                    } catch (LineNumberOutOfBoundsException e1) {
                        e1.printStackTrace();
                    }
                }
                try {
                    datei1.setLine(1, editPane.getText());
                } catch (LineNumberOutOfBoundsException e1) {
                    e1.printStackTrace();
                }
                datei1.write();
            }
            
        });
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

    public static void main(String[] args) {
        new EditorSimple();
    }
}
