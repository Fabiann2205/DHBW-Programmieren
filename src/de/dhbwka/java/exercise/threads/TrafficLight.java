package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class TrafficLight extends JFrame implements Runnable {
    Thread runner;
    String color = "green";

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(10, 30, 100, 295);
        g.setColor(Color.white);
        g.fillOval(13, 33, 90, 90);
        g.fillOval(13, 127, 90, 90);
        g.fillOval(13, 225, 90, 90);
        System.out.println("da");
        if (Objects.equals(color, "red")) {
            //phase rot
            g.setColor(Color.red);
            g.fillOval(13, 33, 90, 90);
            g.setColor(Color.white);
            g.fillOval(13, 127, 90, 90);
            g.fillOval(13, 225, 90, 90);
            System.out.println("red");
        } else if (Objects.equals(color, "yellow")) {

            //phase gelb
            g.setColor(Color.white);
            g.fillOval(13, 33, 90, 90);
            g.fillOval(13, 225, 90, 90);
            g.setColor(Color.yellow);
            g.fillOval(13, 127, 90, 90);
            System.out.println("yellow");
        } else if (Objects.equals(color, "green")) {

            g.setColor(Color.white);
            g.fillOval(13, 33, 90, 90);
            g.fillOval(13, 127, 90, 90);
            g.setColor(Color.green);
            g.fillOval(13, 225, 90, 90);
            System.out.println("green");
        } else if (Objects.equals(color, "redyellow")) {


            //phase rot-gelb
            g.setColor(Color.red);
            g.fillOval(13, 33, 90, 90);
            g.setColor(Color.yellow);
            g.fillOval(13, 127, 90, 90);
            g.setColor(Color.white);
            g.fillOval(13, 225, 90, 90);
            System.out.println("redyellow");
        } else {
            System.out.println("error");
        }
    }



    public void ui () {


        this.pack();
        this.setTitle("Traffic Light");
        this.setMinimumSize(new Dimension(200, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.runner = new Thread(this);
        this.runner.start();
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.ui();
    }

    @Override
    public void run() {
        while (true) {
            try {
                color = "green";
                repaint();
                System.out.println("1");
                Thread.sleep(5000);

                color = "yellow";
                repaint();
                System.out.println("2");
                Thread.sleep(1000);

                color = "red";
                repaint();
                System.out.println("3");
                Thread.sleep(5000);

                color = "redyellow";
                repaint();
                System.out.println("4");
                Thread.sleep(1000);



            } catch (InterruptedException ex) {
                System.out.println("interrupt");
            }
        }
    }
}
