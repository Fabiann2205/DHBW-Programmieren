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
/*
        g.setColor(Color.black);
        g.fillRect(0,0,widthPerElement,(int) height);
        g.setColor(Color.white);
        g.drawString("Union - " + ergebnisse[0] + "%", widthPerElement/2-40,height-15);
        g.setColor(Color.red);
        g.fillRect(widthPerElement,height-(int) (height/ergebnisse[0]*ergebnisse[1]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[1]));
        g.setColor(Color.white);
        g.drawString("SPD - " + ergebnisse[1] + "%", widthPerElement+widthPerElement/2-40,height-15);
        g.setColor(Color.blue);
        g.fillRect(widthPerElement*2,height-(int) (height/ergebnisse[0]*ergebnisse[2]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[2]));
        g.setColor(Color.white);
        g.drawString("AFD - " + ergebnisse[2] + "%", widthPerElement*2+widthPerElement/2-40,height-15);
        g.setColor(Color.yellow);
        g.fillRect(widthPerElement*3,height-(int) (height/ergebnisse[0]*ergebnisse[3]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[3]));
        g.setColor(Color.black);
        g.drawString("FDP - " + ergebnisse[3] + "%", widthPerElement*3+widthPerElement/2-40,height-15);
        g.setColor(Color.pink);
        g.fillRect(widthPerElement*4,height-(int) (height/ergebnisse[0]*ergebnisse[4]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[4]));
        g.setColor(Color.black);
        g.drawString("Linke - " + ergebnisse[4] + "%", widthPerElement*4+widthPerElement/2-40,height-15);
        g.setColor(Color.green);
        g.fillRect(widthPerElement*5,height-(int) (height/ergebnisse[0]*ergebnisse[5]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[5]));
        g.setColor(Color.black);
        g.drawString("Grüne - " + ergebnisse[5] + "%", widthPerElement*5+widthPerElement/2-40,height-15);
        g.setColor(Color.gray);
        g.fillRect(widthPerElement*6,height-(int) (height/ergebnisse[0]*ergebnisse[6]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[6]));
        g.setColor(Color.white);
        g.drawString("Andere - " + ergebnisse[6] + "%", widthPerElement*6+widthPerElement/2-40,height-15);
*/
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
