package de.dhbwka.java.exercise.ui;

import javax.swing.*;

public class ComponentFrame {
    final JFrame frame;

    public ComponentFrame() {
        frame = new JFrame();
        JPanel jp = new JPanel();

        // Elemente in Hauptfenster
        jp.add(new JLabel("JLabel"));
        jp.add(new JTextField("Textfeld", 0));
        JButton Button = new JButton("JButton");
        Button.setToolTipText("Butttonnnnnnn!!!!");
        jp.add(Button);


        jp.add(new JToggleButton("JToggleButton", false));
        jp.add(new JCheckBox("JCheckBox", false));

        String[] comboBoxListe = {"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thüringen"};
        jp.add(new JComboBox<>(comboBoxListe));

        JRadioButton Button1 = new JRadioButton("Button 1", true);
        JRadioButton Button2 = new JRadioButton("Button 2");
        JRadioButton Button3 = new JRadioButton("Button 3");
        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(Button1);
        gruppe.add(Button2);
        gruppe.add(Button3);
        jp.add(Button1);
        jp.add(Button2);
        jp.add(Button3);

        frame.add(jp);

        frame.setTitle("Frame with multiple buttons");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new ComponentFrame();
        System.out.println("hallo");
    }
}
