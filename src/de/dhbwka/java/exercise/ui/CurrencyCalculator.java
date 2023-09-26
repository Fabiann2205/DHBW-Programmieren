package de.dhbwka.java.exercise.ui;

import java.awt.*;

import javax.swing.*;

public class CurrencyCalculator {
    final JFrame frame;

    public CurrencyCalculator() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(5, 5));

        frame.add(new JTextField("Please enter amount to convert!"), BorderLayout.NORTH);

        JPanel unteresPanel = new JPanel();
        unteresPanel.add(new JButton("EUR > USD"));
        unteresPanel.add(new JButton("USD > EUR"));
        unteresPanel.add(new JButton("Cancel"));
        frame.add(unteresPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setTitle("Currency converter");
        frame.setMinimumSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
