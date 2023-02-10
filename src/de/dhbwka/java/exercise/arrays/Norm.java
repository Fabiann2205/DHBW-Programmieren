package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Norm {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = eingabe.nextInt();

        int[] vektor = new int[n];
        int ergebnis = 0;
        for(int x=0; x<n; x++) {
            System.out.printf("Bitte x_%d eingeben: ", x);
            vektor[x] = eingabe.nextInt();
            ergebnis += vektor[x] * vektor[x]; 
        }
        eingabe.close();
        double ergebnis2 = Math.sqrt(ergebnis);

        System.out.println("Der Betrag von x ist " + ergebnis2);



    }
}
