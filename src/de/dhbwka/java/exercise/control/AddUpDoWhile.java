package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class AddUpDoWhile {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        double wert = 0.0d;
        double ergebnis = 0.0d;
        do {
            ergebnis += wert;
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            wert = (double) eingabe.nextDouble();
        } while(wert>=0.0);
            
        eingabe.close();
        System.out.println("Summe: " + ergebnis);
    }
}
