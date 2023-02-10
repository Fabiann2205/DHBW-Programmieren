package de.dhbwka.java.exercise.datatypes;

public class Round {
    public static void main(String[] args) {
        double pi = -3.1415926; // Naeherung der Kreiszahl Pi
        int piInt;
        double negativ = (pi > 0) ? (pi+0.5) : (pi-0.5);
        piInt = (int) (negativ);

        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
    }
}
