package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Fibonacci {
    final int[] einArray;

    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        boolean input = true;
        int wert = 0;
        while (input) {
            System.out.print("Wie viele Fibonacci-Zahlen berechnen? ");
            try {
                wert = eingabe.nextInt();
            } catch (java.util.InputMismatchException e) {
                input = true;
                String errStr = eingabe.next();
                System.out.println(errStr + " keine Zahl!");
                continue;
            }
            if (wert < 1) {
                System.out.println("Zahl ist kleiner als 1! VERBOTEN!!!");
                input = true;
            } else if (wert > 46) {
                System.out.println("Endergebnis wird zu groß für INT! Nicht möglich!!!");
                input = true;
            } else {
                input = false;
            }

        }
        eingabe.close();
        Fibonacci test = new Fibonacci(wert);
        System.out.println(test.fibonacciwert(wert));
        System.out.println(test);
    }

    public Fibonacci(int laenge) {
        einArray = new int[laenge];
    }

    public int fibonacciwert(int i) {
        if (i == 1 || i == 2) {
            if (i == 2) {
                this.einArray[1] = 1;
            }
            this.einArray[0] = 1;
            return 1;
        } else {
            this.einArray[i - 1] = fibonacciwert(i - 1) + fibonacciwert(i - 2);
            return this.einArray[i - 1]; //Fi = Fi-1 + Fi-2
        }
    }


    @Override
    public String toString() {
        StringBuilder ausgabe = new StringBuilder("Zahlen: ");
        for (int j : this.einArray) {
            ausgabe.append(j).append(", ");
        }
        ausgabe = new StringBuilder(ausgabe.substring(0, ausgabe.length() - 2));
        return ausgabe.toString();
    }


}
