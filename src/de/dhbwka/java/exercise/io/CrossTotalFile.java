package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class CrossTotalFile {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String s = eingabe.next();

        int sInt = Integer.parseInt(s);
        int sum = 0;
        while (sInt > 0) {
            sum += sInt % 10;
            sInt /= 10;
        }

        File output = new File("resources/crosstotals.txt");
        try {
            output.createNewFile();
        } catch (IOException e) {
            System.err.println("Error" + e);
        }

        System.out.println("Quersumme: " + sum);

        try (Writer fWriter = new FileWriter("resources/crosstotals.txt", true)) {
            fWriter.write("Quersumme von " + s + " ist " + sum + "\n");
        } catch (IOException ex) {
            System.err.println("Error" + ex);
        }

        eingabe.close();


    }
}
