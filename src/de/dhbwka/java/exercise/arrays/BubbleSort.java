package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = eingabe.nextInt();

        int[] vektorX = new int[n];
        for (int x = 0; x < n; x++) {
            System.out.printf("Bitte %d. Zahl eingeben: ", x);
            vektorX[x] = eingabe.nextInt();
        }
        eingabe.close();

        //BubbleSorter
        boolean sorter = true;
        int temp;
        while (sorter) {
            sorter = false;
            for (int x = 0; x < vektorX.length - 1; x++) {
                if (vektorX[x] > vektorX[x + 1]) {
                    temp = vektorX[x];
                    vektorX[x] = vektorX[x + 1];
                    vektorX[x + 1] = temp;
                    sorter = true;
                }
            }
        }

        //Vektor ausgeben
        for (int i : vektorX) {
            System.out.printf("%d ", i);
        }
    }
}
