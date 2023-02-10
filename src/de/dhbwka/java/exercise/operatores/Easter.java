package de.dhbwka.java.exercise.operatores;

import java.util.Scanner;

public class Easter {
    public static void main(String[] args) {
        System.out.print("Jahr eingeben: ");
        Scanner eingabeJahr = new Scanner(System.in);
        int jahr = eingabeJahr.nextInt();
        eingabeJahr.close();
        int a = jahr % 19;
        int b = jahr % 4;
        int c = jahr % 7;
        int k = jahr / 100;
        int p = (8*k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19*a + m) % 30;
        int e = (2*b + 4*c + 6*d + n) % 7;
        int ostern = (22 + d + e);

        String ausgabe = (ostern<32) ? (ostern + ". März "+ jahr) : ((ostern-31) + ". April "+ jahr);
        System.out.println(ausgabe + "\n" +ostern);
    }
}
