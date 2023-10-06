package de;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Main {
    public Main() {
        /* generate a new standard UI
           contains:
           - JFrame: Main window frame in which all components can be placed
           - three JPanels: top, center, bottom JPanels to fill with content
                every one of that has a layout manager
           - other useful stuff
         */

        // in IntelliJ as a live template

        // put these objects in a class scope if there are problems
        JFrame frame = new JFrame();
        JPanel topPane = new JPanel();
        JPanel centerPane = new JPanel();
        JPanel bottomPane = new JPanel();

        topPane.setBorder(BorderFactory.createEmptyBorder(200, 20, 20, 10));
        centerPane.setLayout(new GridLayout(3, 4));
        frame.setLayout(new BorderLayout());
        /* other Layouts:
            - BorderLayout
            - BoxLayout
            - CardLayout
            - FlowLayout
            - GridBagLayout
            - GridLayout
            - GroupLayout
         */

        frame.add(topPane, BorderLayout.PAGE_START);
        frame.add(centerPane, BorderLayout.CENTER);
        frame.add(bottomPane, BorderLayout.PAGE_END);

        frame.setTitle("Title of the windows");
        // frame.setSize(1000, 500);
        frame.pack(); // auto sizing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JPanel pane = new JPanel();


        JButton button = new JButton("Button");
        ActionListener actionListener = e -> {
            System.out.println("Button was pressed!");
        };
        button.addActionListener(actionListener);
        pane.add(button);

        JToggleButton toggleButton = new JToggleButton("ToggleButton");
        toggleButton.addItemListener(ev -> {
            if (ev.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("button is selected");
            } else if (ev.getStateChange() == ItemEvent.DESELECTED) {
                System.out.println("button is not selected");
            }
        });
        pane.add(toggleButton);
    }

    public static void main(String[] args) {
        new Main();
    }
}