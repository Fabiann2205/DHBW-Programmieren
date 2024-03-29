package de.dhbwka.java.exams.unsereKlausur.exam;

import exam.ownclasses.TextFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuestionnaireTerm {
    private final JTextArea textArea;
    private final JFrame frame;

    public QuestionnaireTerm() {
        // put these objects in a class scope if there are problems
        frame = new JFrame();

        textArea = new JTextArea(30, 5);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton saveButton = new JButton("Save");
        ActionListener actionListener = e -> {
            System.out.println("Save Button was pressed!");
            JButton buttons = (JButton) e.getSource();
            buttons.setEnabled(true);
            String text = textArea.getText();
            // Fehlermeldung
            if (text.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Das Textfeld ist leer, kann nicht speichern!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Speichern
                TextFile file = new TextFile("questionnaires.txt");
                file.addLine("---------------------------------------------------");
                file.addLine(text); // prüfen ob klappt!!!
            }
        };
        saveButton.addActionListener(actionListener);


        frame.setLayout(new BorderLayout());

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);

        frame.setTitle("Questionnaire");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setQuestionnaire(String text) {
        textArea.setText(text);
        Runnable countdown = () -> {
            int start = 10;
            for (int i = start; i > 0; i--) {
                frame.setTitle("Questionnaire" + " [" + i + "]");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            frame.setTitle("Questionnaire");
            textArea.setText("");
        };
        Thread thread = new Thread(countdown);
        thread.start();
    }
}
