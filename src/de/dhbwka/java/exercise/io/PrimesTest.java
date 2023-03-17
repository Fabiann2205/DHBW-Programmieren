package de.dhbwka.java.exercise.io;

import java.util.Scanner;

public class PrimesTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welche Zahl auf Primzahl prüfen? ");
        int zahl = input.nextInt();
        input.close();
        try {
            TextFile datei = new TextFile("primes.txt");
            Boolean gefunden = false;
            for(int i=1; i<=datei.availableLines(); i++) {
                if(datei.getLine(i).equals(String.valueOf(zahl))) {
                    gefunden = true;
                    break;
                }
            }
            datei.close();
            if (gefunden) {
                System.out.println(zahl + " ist eine Primzahl!");
            } else {
                System.out.println(zahl + " ist keine Primzahl!");
            }
        } catch (IOErrorInFile e) {
            e.printStackTrace();
        } catch (LineNumberOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
