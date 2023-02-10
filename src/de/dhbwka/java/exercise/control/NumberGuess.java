package de.dhbwka.java.exercise.control;

import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Wie ist Dein Name? ");
        String spielerName = eingabe.next();

        int minimaleZahl = 1, maximaleZahl = 100, randomNumber, versuch =0, current = 0, weiter = 1;

        while(weiter == 1) {
            randomNumber = (int) (Math.random()*maximaleZahl)+minimaleZahl;
            while (current != randomNumber) {
                versuch++;
                System.out.print(spielerName + ", rate eine Zahl [" + minimaleZahl + "-" + maximaleZahl + "]: ");
                current = eingabe.nextInt();
                if (current == randomNumber) {
                    System.out.println("Versuch " + versuch + ": " + current + " ist korrekt.");
                } else if (current > randomNumber) {
                    System.out.println("Versuch " + versuch + ": " + current + " ist zu hoch.");
                } else if (current < randomNumber) {
                    System.out.println("Versuch " + versuch + ": " + current + " ist zu niedrig.");
                }
            }
            do {
                System.out.println("Was möchtest du tun?");
                System.out.println("0 - Das Spiel beenden");
                System.out.print("1 - Das Spiel fortsetzen ");
                weiter = eingabe.nextInt();
            } while(weiter != 1 && weiter != 0);
        }
        eingabe.close();
    }
}
