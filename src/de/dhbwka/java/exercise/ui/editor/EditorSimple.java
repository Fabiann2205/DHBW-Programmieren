package de.dhbwka.java.exercise.ui.editor;

import javax.swing.*;

public class EditorSimple {
    JFrame frame;
    public EditorSimple() {
        frame = new JFrame();

        JMenuBar bar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        JMenu bearbeiten = new JMenu("Bearbeiten");
        JMenu sendenan = new JMenu("Senden an");
        JMenuItem item1 = new JMenuItem("Neu");
        JMenuItem item2 = new JMenuItem("Mail");
        JMenuItem item3 = new JMenuItem("WhatsApp");
        JMenuItem item4 = new JMenuItem("Öffnen");
        JMenuItem item5 = new JMenuItem("Schließen");
        JMenuItem item6 = new JMenuItem("Speichern");
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

        frame.setTitle("Editor");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EditorSimple();
    }
}
