package de.dhbwka.java.exercise.collections.gas;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class GasStations {
    private final JTextField stationNameInput, dieselInput, superE5Input, superE10Input;
    private final Map<String, GasPrices> gasStationsMap = new TreeMap<>();
    public GasStations() {
        //ui
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout(5, 5));

        JPanel topPanel = new JPanel(new GridLayout(4, 2));
        topPanel.add(new JLabel("Station Name"));
        stationNameInput = new JTextField("");
        topPanel.add(stationNameInput);
        topPanel.add(new JLabel("Diesel"));
        dieselInput = new JTextField("");
        topPanel.add(dieselInput);
        topPanel.add(new JLabel("Super E5"));
        superE5Input = new JTextField("");
        topPanel.add(superE5Input);
        topPanel.add(new JLabel("Super E10"));
        superE10Input = new JTextField("");
        topPanel.add(superE10Input);
        frame.add(topPanel, BorderLayout.NORTH);


        JPanel bottomPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            if (Objects.equals(stationNameInput.getText(), "")) {
                JOptionPane.showMessageDialog(null, "Please provide a station name");
            } else {
                System.out.println(stationNameInput.getText());

                double diesel;
                try {
                    diesel = Double.parseDouble(dieselInput.getText());
                } catch (Exception f) {
                    diesel = -1.0d;
                }
                double superE5;
                try {
                    superE5 = Double.parseDouble(superE5Input.getText());
                } catch (Exception f) {
                    superE5 = -1.0d;
                }
                double superE10;
                try {
                    superE10 = Double.parseDouble(superE10Input.getText());
                } catch (Exception f) {
                    superE10 = -1.0d;
                }
                gasStationsMap.put(stationNameInput.getText(), new GasPrices(diesel,superE5,superE10));
                JOptionPane.showMessageDialog(null, "Saved: " + stationNameInput.getText() + " - " + gasStationsMap.get(stationNameInput.getText()).toString());
                stationNameInput.setText("");
                dieselInput.setText("");
                superE5Input.setText("");
                superE10Input.setText("");
            }
        });


        bottomPanel.add(saveButton);
        JButton showAllButton = new JButton("Show all");
        showAllButton.addActionListener(e -> {
            StringBuilder concatter = new StringBuilder();
            for(String name : gasStationsMap.keySet()) {
                concatter.append(name).append(": ").append(gasStationsMap.get(name).toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, concatter.toString());
        });
        bottomPanel.add(showAllButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setTitle("Currency converter");
        frame.setMinimumSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GasStations();
    }
}
