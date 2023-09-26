package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class MatrixSubtraction {
    public static void main(String[] args) {
        //Anzahl an Zeilen und Spalten einlesen von Konsole
        Scanner input = new Scanner(System.in);
        System.out.print("Anzahl an Zeilen: ");
        int zeilen = input.nextInt();
        System.out.print("Anzahl an Spalten: ");
        int spalten = input.nextInt();

        //Anlegen der Matrizen
        int[][] matrix1 = new int[zeilen][spalten];
        int[][] matrix2 = new int[zeilen][spalten];
        int[][] matrix3 = new int[zeilen][spalten];


        //Werte für Matrix 1 von Konsole einlesen
        System.out.println("Matrix 1:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print("Zeile " + (i + 1) + " Spalte " + (j + 1) + ": ");
                matrix1[i][j] = input.nextInt();
            }
        }
        //Werte für Matrix 2 von Konsole einlesen
        System.out.println("Matrix 2:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print("Zeile " + (i + 1) + " Spalte " + (j + 1) + ": ");
                matrix2[i][j] = input.nextInt();
            }
        }
        input.close();

        //Matrix 3 berechnen Subtraktion    
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        //Matrixen ausgeben
        printArray(matrix1, "Matrix 1");
        printArray(matrix2, "Matrix 2");
        printArray(matrix3, "Matrix 3");
    }

    private static void printArray(int[][] matrix, String name) {
        System.out.println(name + ":");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%5d ", anInt);
            }
            System.out.println();
        }
    }
}
