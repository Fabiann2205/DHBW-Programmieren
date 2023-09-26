package de.ownclasses;

public class Printer {
    public void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
    }

    public void printArray(double[] array) {
        for (double v : array) {
            System.out.printf("%f ", v);
        }
    }

    public void printArray(String[] array) {
        for (String s : array) {
            System.out.printf("%s ", s);
        }
    }
}

