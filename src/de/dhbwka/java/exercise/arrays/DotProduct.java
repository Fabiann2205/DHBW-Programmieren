package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = eingabe.nextInt();

        int[] vektorX = new int[n];
        for(int x=0; x<n; x++) {
            System.out.printf("Bitte x_%d eingeben: ", x);
            vektorX[x] = eingabe.nextInt();
        }
        int[] vektorY = new int[n];
        for(int x=0; x<n; x++) {
            System.out.printf("Bitte y_%d eingeben: ", x);
            vektorY[x] = eingabe.nextInt();
        }
        eingabe.close();

        int ergebnis = 0;
        for(int x=0; x<n; x++) {
            ergebnis += vektorX[x] * vektorY[x];
        }

        System.out.println("Der Betrag von x ist " + ergebnis);


    }
}
