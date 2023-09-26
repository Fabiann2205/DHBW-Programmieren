package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class CrossTotal {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String s = eingabe.next();

        int sInt = Integer.parseInt(s);
        // int i = Integer.parseInt(s);
        //Quersumme aus sInt berechnen
        int sum = 0;
        while (sInt > 0) {
            sum += sInt % 10;
            sInt /= 10;
        }


        System.out.println("Quersumme: " + sum);
        eingabe.close();


    }
}
