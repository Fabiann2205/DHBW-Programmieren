package de.dhbwka.java.exercise.control;

public class MultiplicationTable {
    public static void main(String[] args) {
        int tableSize = 10, counter = 1, counter2 = 1, ergebnis;
        while(counter <= tableSize) {
            while(counter2 <= tableSize) {
                ergebnis = counter2*counter;
                System.out.printf("%5d", ergebnis);
                counter2++;
            }
            System.out.printf("%n");
            counter2 = 1;
            counter++;
        }
    }
}
