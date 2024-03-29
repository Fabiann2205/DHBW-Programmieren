package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator {
    final JFrame frame;

    public CurrencyCalculator() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(5, 5));

        JTextField textfeld = new JTextField("Please enter amount to convert!");
        frame.add(textfeld, BorderLayout.NORTH);

        JPanel unteresPanel = new JPanel();

        JButton eurusd = new JButton("EUR > USD");
        eurusd.addActionListener(e -> {
            try {
                double wert = Double.parseDouble(textfeld.getText()) * 1.09;
                textfeld.setText((String.valueOf(wert)));
            } catch (Exception f) {
                textfeld.setText("Kein gültiger Wert!!!");
            }
        });
        unteresPanel.add(eurusd);

        JButton usdeur = new JButton("USD > EUR");
        usdeur.addActionListener(e -> {
            try {
                double wert = Double.parseDouble(textfeld.getText()) / 1.09;
                textfeld.setText((String.valueOf(wert)));
            } catch (Exception f) {
                textfeld.setText("Kein gültiger Wert!!!");
            }
        });
        unteresPanel.add(usdeur);


        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> System.exit(0));
        unteresPanel.add(cancel);


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
