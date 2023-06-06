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
        int widthPerElement = width/ergebnisse.length;


        // erste Partei ganz links
        g.setColor(colors[0]);
        g.fillRect(0,0,widthPerElement,height);
        g.setColor(fontColor[0]);
        g.drawString(parteien[0] + " - " + ergebnisse[0] + "%", widthPerElement/2-40,height-15);


        String parteiname;
        Color colorname;
        Color fontcolorname;
        for (int i = 1; i<ergebnisse.length; i++) {
            try{
                parteiname = parteien[i];
            } catch(Exception e) {
                parteiname = "undefined";
            }
            try{
                colorname = colors[i];
            } catch(Exception e) {
                colorname = Color.BLACK;
            }
            try{
                fontcolorname = fontColor[i];
            } catch(Exception e) {
                fontcolorname = Color.white;
            }
            g.setColor(colorname);
            g.fillRect(widthPerElement*i,height-(int) (height/ergebnisse[0]*ergebnisse[i]),widthPerElement,(int) (height/ergebnisse[0]*ergebnisse[i]));
            g.setColor(fontcolorname);
            g.drawString(parteiname + " - " + ergebnisse[i] + "%", widthPerElement*i+widthPerElement/2-40,height-15);
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
