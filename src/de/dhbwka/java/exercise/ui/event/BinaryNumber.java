package de.dhbwka.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryNumber implements ActionListener {
    final JFrame frame;
    final ImageIcon imgOff = new ImageIcon("resources/off.png");
    final ImageIcon imgOn = new ImageIcon("resources/on.png");
    final JToggleButton sieben;
    final JToggleButton sechs;
    final JToggleButton fuenf;
    final JToggleButton vier;
    final JToggleButton drei;
    final JToggleButton zwei;
    final JToggleButton eins;
    final JLabel ergebnis1;
    final JToggleButton nul;

    public BinaryNumber() {
        frame = new JFrame();
        //Top Buttons
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 8, 2, 2));
        sieben = new JToggleButton();
        sieben.setIcon(imgOff);
        sieben.setSelectedIcon(imgOn);
        sieben.addActionListener(this);
        top.add(sieben);
        sechs = new JToggleButton();
        sechs.setIcon(imgOff);
        sechs.setSelectedIcon(imgOn);
        sechs.addActionListener(this);
        top.add(sechs);
        fuenf = new JToggleButton();
        fuenf.setIcon(imgOff);
        fuenf.setSelectedIcon(imgOn);
        fuenf.addActionListener(this);
        top.add(fuenf);
        vier = new JToggleButton();
        vier.setIcon(imgOff);
        vier.setSelectedIcon(imgOn);
        vier.addActionListener(this);
        top.add(vier);
        drei = new JToggleButton();
        drei.setIcon(imgOff);
        drei.setSelectedIcon(imgOn);
        drei.addActionListener(this);
        top.add(drei);
        zwei = new JToggleButton();
        zwei.setIcon(imgOff);
        zwei.setSelectedIcon(imgOn);
        zwei.addActionListener(this);
        top.add(zwei);
        eins = new JToggleButton();
        eins.setIcon(imgOff);
        eins.setSelectedIcon(imgOn);
        eins.addActionListener(this);
        top.add(eins);
        nul = new JToggleButton();
        nul.setIcon(imgOff);
        nul.setSelectedIcon(imgOn);
        nul.addActionListener(this);
        top.add(nul);
        frame.add(top, BorderLayout.NORTH);
        //Middle Labels
        JPanel middle = getjPanel();
        frame.add(middle);
        //down label
        JPanel f = new JPanel();
        ergebnis1 = new JLabel("0");
        f.add(ergebnis1);
        frame.add(f, BorderLayout.SOUTH);
        // frame.pack();
        frame.setTitle("Currency converter");
        frame.setMinimumSize(new Dimension(500, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static JPanel getjPanel() {
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(1, 8, 2, 2));
        JLabel label7 = new JLabel("2^7", SwingConstants.CENTER);
        middle.add(label7);
        JLabel label6 = new JLabel("2^6", SwingConstants.CENTER);
        middle.add(label6);
        JLabel label5 = new JLabel("2^5", SwingConstants.CENTER);
        middle.add(label5);
        JLabel label4 = new JLabel("2^4", SwingConstants.CENTER);
        middle.add(label4);
        JLabel label3 = new JLabel("2^3", SwingConstants.CENTER);
        middle.add(label3);
        JLabel label2 = new JLabel("2^2", SwingConstants.CENTER);
        middle.add(label2);
        JLabel label1 = new JLabel("2^1", SwingConstants.CENTER);
        middle.add(label1);
        JLabel label0 = new JLabel("2^0", SwingConstants.CENTER);
        middle.add(label0);
        return middle;
    }

    public void actionPerformed(ActionEvent e) {
        JToggleButton[] namen = {nul, eins, zwei, drei, vier, fuenf, sechs, sieben};
        int ergebnis = 0;
        for (int i = 0; i < 8; i++) {
            if (namen[i].isSelected()) {
                ergebnis += (int) Math.pow(2.0d, i);
            }
        }
        ergebnis1.setText(String.valueOf(ergebnis));
    }

    public static void main(String[] args) {
        new BinaryNumber();
    }
}
