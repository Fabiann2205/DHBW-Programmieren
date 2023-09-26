package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;

public class BMICalculator {
    final JFrame frame;

    public BMICalculator() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout(5, 5));
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4, 2, 2, 2));


        JLabel gewichtLabel = new JLabel("Weight [kg]: ");
        JTextField gewicht = new JTextField("70");
        top.add(gewichtLabel);
        top.add(gewicht);
        JLabel groesseLabel = new JLabel("Body height [m]: ");
        JTextField groesse = new JTextField("1.80");
        top.add(groesseLabel);
        top.add(groesse);


        JRadioButton male = new JRadioButton("male", true);
        JRadioButton female = new JRadioButton("female");
        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(male);
        gruppe.add(female);
        top.add(male);
        top.add(female);

        frame.add(top, BorderLayout.NORTH);


        //Buttons für unten
        JLabel bmiLabel = new JLabel("BMI: ");
        JTextField bmi = new JTextField("21.604938271604937");
        JLabel normalweightLabel = new JLabel(" ");
        JTextField normalweight = new JTextField("Normal weight");

        // Mitte Calculate Button
        JPanel mid = new JPanel();
        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(e -> {
            try {
                bmi.setText(String.valueOf(Double.parseDouble(gewicht.getText()) / (Double.parseDouble(groesse.getText()) * Double.parseDouble(groesse.getText()))));
                if (male.isSelected()) {
                    if (Double.parseDouble(bmi.getText()) < 20.0d) {
                        normalweight.setText("Short weight");
                    } else if (Double.parseDouble(bmi.getText()) <= 25.0d) {
                        normalweight.setText("Normal weight");
                    } else if (Double.parseDouble(bmi.getText()) <= 30.0d) {
                        normalweight.setText("Overweight");
                    } else if (Double.parseDouble(bmi.getText()) <= 40.0d) {
                        normalweight.setText("Adiposity");
                    } else if (Double.parseDouble(bmi.getText()) > 40.0d) {
                        normalweight.setText("Massive Adiposity");
                    }
                } else if (female.isSelected()) {
                    if (Double.parseDouble(bmi.getText()) < 19.0d) {
                        normalweight.setText("Short weight");
                    } else if (Double.parseDouble(bmi.getText()) <= 24.0d) {
                        normalweight.setText("Normal weight");
                    } else if (Double.parseDouble(bmi.getText()) <= 30.0d) {
                        normalweight.setText("Overweight");
                    } else if (Double.parseDouble(bmi.getText()) <= 40.0d) {
                        normalweight.setText("Adiposity");
                    } else if (Double.parseDouble(bmi.getText()) > 40.0d) {
                        normalweight.setText("Massive Adiposity");
                    }
                }
            } catch (Exception f) {
                gewicht.setText("Kein gültiger Wert!!!");
                groesse.setText("Kein gültiger Wert!!!");
                bmi.setText("Kein gültiger Wert!!!");
                normalweight.setText("Kein gültiger Wert!!!");
            }
        });
        mid.add(calculate);
        frame.add(mid, BorderLayout.CENTER);


        // bottom stuff
        JPanel bot = new JPanel();
        bot.setLayout(new GridLayout(2, 2, 2, 2));
        bot.add(bmiLabel);
        bot.add(bmi);
        bot.add(normalweightLabel);
        bot.add(normalweight);
        frame.add(bot, BorderLayout.SOUTH);


        frame.pack();
        frame.setTitle("Currency converter");
        frame.setMinimumSize(new Dimension(300, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}
