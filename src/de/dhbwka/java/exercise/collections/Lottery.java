package de.dhbwka.java.exercise.collections;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        Random rnd = new Random();

        //Zufallszahlen generieren (random 6 aus 49)
        do {
            numbers.add(rnd.nextInt(49) + 1);
        } while (numbers.size() < 6);

        //Zusatzzahl generieren
        int zusatzzahl;
        do {
            zusatzzahl = (rnd.nextInt(49) + 1);
        } while (numbers.contains(zusatzzahl));

        for (Integer n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println("Zusatzzahl: " + zusatzzahl);


    }
}
