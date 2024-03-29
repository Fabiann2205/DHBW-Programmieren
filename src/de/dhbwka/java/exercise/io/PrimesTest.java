package de.dhbwka.java.exercise.io;

import java.util.Scanner;

public class PrimesTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welche Zahl auf Primzahl prüfen? ");
        int zahl = input.nextInt();
        input.close();
        try {
            TextFile datei = new TextFile("resources/primes.txt");
            if (datei.isInFile(String.valueOf(zahl))) {
                System.out.println(zahl + " ist eine Primzahl!");
            } else {
                System.out.println(zahl + " ist keine Primzahl!");
            }
            datei.close();
        } catch (IOErrorInFile e) {
            System.err.println("Error" + e);
        }
    }
}