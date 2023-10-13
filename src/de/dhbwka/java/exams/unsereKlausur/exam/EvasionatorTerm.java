package de.dhbwka.java.exams.unsereKlausur.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class EvasionatorTerm {
    private QuestionCatalogue catalogue;
    private AnswerGenerator generator;
    private QuestionnaireTerm term;

    private JLabel topic, count;
    private JTextField topicField, countField;
    private JButton generateButton, randomButton;
    private JFormattedTextField countValidField;


    public EvasionatorTerm(QuestionCatalogue catalogue, AnswerGenerator generator, QuestionnaireTerm term) {
        this.catalogue = catalogue;
        this.generator = generator;
        this.term = term;

        // put these objects in a class scope if there are problems
        JFrame frame = new JFrame();
        JPanel centerPane = new JPanel();
        JPanel bottomPane = new JPanel();

        // alle sachen auf dem UI
        topic = new JLabel("Topic:");
        count = new JLabel("Question count:");
        topicField = new JTextField();
        countField = new JTextField();
        countValidField = new JFormattedTextField(NumberFormat.getIntegerInstance());

        generateButton = new JButton("Generate");
        ActionListener actionListener = e -> {
            System.out.println("Generate Button was pressed!");
            JButton buttons = (JButton) e.getSource();
            buttons.setEnabled(true);
            if (Evasionator.containsUnreasonableKeyword(topicField.getText())) {
                JOptionPane.showMessageDialog(null, "Sorry, the topic " + topicField.getText() + " is forbidden.");
            } else {
                System.out.println("Nicht unreasonable");
                List<Question> fragen = new ArrayList<>();

                try {
                    fragen = catalogue.getQuestions(Integer.parseInt(countValidField.getText()));
                } catch (EvasionException ex) {
                    JOptionPane.showMessageDialog(null, "Sorry there are to less questions or answers in the catalogue!");
                }
                StringBuilder uebergabe = new StringBuilder();
                int i = 1;
                for (Question q : fragen) {
                    uebergabe.append("Frage ").append(i).append(":\n");
                    uebergabe.append(Evasionator.replaceTopic(q.getText(), topicField.getText())).append("\n");
                    uebergabe.append(generator.generateAnswer(q, topicField.getText())).append("\n\n");
                    i++;
                }
                term.setQuestionnaire(uebergabe.toString());
                System.out.println("Ende");

            }
        };
        generateButton.addActionListener(actionListener);

        randomButton = new JButton("Random Answer");
        ActionListener actionListenerRandom = e -> {
            System.out.println("Random Answer Button was pressed!");
            JButton buttons = (JButton) e.getSource();
            buttons.setEnabled(true);
            Evasion current = generator.getRandomEvasion();
            String answer = "";
            for (QuestionType q : current.getTypes()) {
                answer = answer.concat(q.getLabel() + ", ");
            }
            JOptionPane.showMessageDialog(null, current.getText() + " (" + answer.substring(0, answer.length() - 2) + ")");
        };
        randomButton.addActionListener(actionListenerRandom);

        // Layouts
        centerPane.setLayout(new GridLayout(2, 2));
        bottomPane.setLayout(new GridLayout(1, 2));
        frame.setLayout(new BorderLayout());

        // add to panels
        centerPane.add(topic);
        centerPane.add(topicField);
        centerPane.add(count);
        centerPane.add(countValidField);
        bottomPane.add(generateButton);
        bottomPane.add(randomButton);

        // add to frame
        frame.add(centerPane, BorderLayout.NORTH);
        frame.add(bottomPane, BorderLayout.SOUTH);

        // sonstiger stuff
        frame.setTitle("Evasionator™");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Generate: generiert Fragebogen
        // Random Answer: zeigt eine zufällige Frage als PopUp an DONE!
    }
}
