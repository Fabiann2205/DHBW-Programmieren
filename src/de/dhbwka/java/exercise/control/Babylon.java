package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class Babylon {
    public static void main(String[] args) {
        double newValue = 1.0, oldValue = 0.0;
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen? ");
        double wurzelZumZiehen = eingabe.nextDouble();
        eingabe.close();
        if (wurzelZumZiehen == 0) {
            newValue = 0.0d;
        } else if (wurzelZumZiehen == 1) {
            newValue = 1.0d;
        } else if (wurzelZumZiehen < 0) {
            throw new ArithmeticException("Nicht von negativen Zahlen Wurzeln ziehen!");
        } else {
            do {
                System.out.println(newValue);
                oldValue = newValue;
                newValue = calculateIteration(newValue, wurzelZumZiehen);
            } while (Math.abs(oldValue - newValue) >= 10e-6);
        }
        System.out.println("Die Wurzel aus " + wurzelZumZiehen + " ist " + newValue);

    }

    private static double calculateIteration(double value, double wurzel) {
        return ((value + (wurzel / value)) / 2);
    }
}
