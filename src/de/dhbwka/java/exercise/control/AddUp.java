package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUp {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        double wert = 0.0d;
        double ergebnis = 0.0d;
        while (wert >= 0.0) {
            ergebnis += wert;
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            wert = eingabe.nextDouble();
        }
        eingabe.close();
        System.out.println("Summe: " + ergebnis);
    }
}
