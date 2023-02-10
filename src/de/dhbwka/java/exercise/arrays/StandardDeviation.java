package de.dhbwka.java.exercise.arrays;

import java.util.Random;

public class StandardDeviation {
    public static void main(String[] args) {
        int[] randomNumbers = new int[100];
        int x;
        Random zufall = new Random();

        //Array mit Zufallszahlen
        for(x=0; x<100; x++) {
            randomNumbers[x] = zufall.nextInt(11);
        }

        for(int n=0; n<100; n++) {
            System.out.printf("%3d : %-12d %n", n+1, randomNumbers[n]);
        }

        //Mittelwert
        double mittelwert = 0.0d, standardabweichung = 0.0d;
        for(x=0; x<100; x++) {
            mittelwert += randomNumbers[x];
        }

        mittelwert/=100.0d;
        System.out.println("Mittelwert: " + mittelwert);

        //Standardabweichung
        for(x=0; x<100; x++) {
            standardabweichung += Math.pow((randomNumbers[x]-mittelwert), 2);
        }
        standardabweichung/=99; //da n-1
        standardabweichung = Math.sqrt(standardabweichung);
        System.out.println("Standardabweichung: " + standardabweichung);
    }
}
