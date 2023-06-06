package de.dhbwka.java.exercise.ui.paint;

import javax.swing.*;
import java.awt.*;

public class Election extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        double[] ergebnisse = {33,20.5,12.6,10.7,9.2,8.9,5.1};
        String[] parteien = {"Union", "SPD", "AfD", "FDP", "Linke", "Grüne", "Andere"};
        Color[] colors = {Color.black, Color.red, Color.blue, Color.yellow, Color.pink, Color.green, Color.gray};
        Color[] fontColor = {Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.white};

        int width = getWidth();
        int height = getHeight();
        int widthPerElement = width/7;


        g.setColor(colors[0]);
        g.fillRect(0,0,widthPerElement,height);
        g.setColor(fontColor[0]);
        g.drawString(parteien[0] + " - " + ergebnisse[0] + "%", widthPerElement/2-40,height-15);
        for (int i = 1; i<7; i++) {
            g.setColor(colors[i]);
            g.fillRect(widthPerElement*i,height-(int) (height/ergebnisse[0]*ergebnisse[i]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[i]));
            g.setColor(fontColor[i]);
            g.drawString(parteien[i] + " - " + ergebnisse[i] + "%", widthPerElement*i+widthPerElement/2-40,height-15);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new Election());
        f.setTitle("Election");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(1000,500));
        f.setVisible(true);
    }
}
