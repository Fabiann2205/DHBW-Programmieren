package de.ownclasses;

public class Printer {
    public void printArray(int[] array) {
        for(int x=0; x < array.length; x++) {
            System.out.printf("%d ", array[x]);
        }
    }

    public void printArray(double[] array) {
        for(int x=0; x < array.length; x++) {
            System.out.printf("%f ", array[x]);
        }
    }

    public void printArray(String[] array) {
        for(int x=0; x < array.length; x++) {
            System.out.printf("%s ", array[x]);
        }
    }
}

