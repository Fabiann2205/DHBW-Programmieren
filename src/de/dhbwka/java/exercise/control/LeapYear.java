package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.print("Welches Jahr soll auf Schaltjahr geprüft werden? ");
        Scanner eingabe = new Scanner(System.in);
        int jahr = eingabe.nextInt();
        eingabe.close();

        boolean schaltjahr = false;

        if (jahr % 100 == 0) {
            schaltjahr = jahr % 400 == 0;
        } else schaltjahr = jahr % 4 == 0;

        System.out.println(jahr + ((schaltjahr) ? " ist ein Schaltjahr" : " ist kein Schaltjahr"));

    }
}
