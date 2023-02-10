package de.dhbwka.java.exercise.control;

public class ShoeSize {
    public static void main(String[] args) {
        int size = 30;
        double fromC, toC;
        fromC = getCentimetres(size-1);
        toC = getCentimetres(size);
        System.out.printf("%-13S | %S %n", "Zentimeter", "Größe");
        System.out.println("--------------+---------");
        while(size < 50.0) { 
            System.out.printf("%5.2f - %5.2f | %2d %n", fromC, toC ,size);
            size++;
            fromC = toC;
            toC = getCentimetres(size);
            
        }
    }

    private static double getCentimetres(int size) {
        return size / 1.5;
    }
}
