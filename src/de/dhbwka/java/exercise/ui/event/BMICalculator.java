package de.dhbwka.java.exercise.ui.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BMICalculator {
    JFrame frame;
    public BMICalculator() {
        frame = new JFrame();
        JPanel panel = new JPanel();
        // frame.setLayout(new BorderLayout(5, 5));

        JTextField gewicht = new JTextField("Weight");
        panel.add(gewicht);
        JTextField groesse = new JTextField("Height");
        panel.add(groesse);


        JRadioButton male = new JRadioButton("male", true);
        JRadioButton female = new JRadioButton("female");
        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(male);
        gruppe.add(female);
        panel.add(male);
        panel.add(female);


        JButton calculate = new JButton("Calculate");
        panel.add(calculate);


        JTextField bmi = new JTextField("BMI");
        panel.add(bmi);
        JTextField normalweight = new JTextField("Normal Weight");
        panel.add(normalweight);
        
        frame.add(panel);

        frame.pack();
        frame.setTitle("Currency converter");
        frame.setMinimumSize(new Dimension(100, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}
