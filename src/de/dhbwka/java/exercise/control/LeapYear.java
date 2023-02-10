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
            if (jahr % 400 == 0) {
                schaltjahr = true;
            } else {
                schaltjahr = false;
            }
        } else if ( jahr % 4 == 0) {
            schaltjahr = true;
        } else {
            schaltjahr = false;
        }

        System.out.println(jahr + ((schaltjahr == true) ? " ist ein Schaltjahr" : " ist kein Schaltjahr" ));

    }
}
