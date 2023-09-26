package de.dhbwka.java.exercise.arrays;

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Wie viele Zeilen: ");
        int zeilen = eingabe.nextInt();
        eingabe.close();


        int[][] pascal = new int[zeilen][];


        for (int i = 0; i < pascal.length; i++) {
            pascal[i] = new int[i + 1];
            for (int j = 0; j < pascal[i].length; j++) {
                if (j == 0 || j == pascal[i].length - 1) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }

        //print pascal like a triangle
        for (int i = 0; i < pascal.length; i++) {
            for (int j = 0; j < pascal.length - i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < pascal[i].length; j++) {
                //System.out.print(pascal[i][j] + " ");
                System.out.printf("%5d ", pascal[i][j]);
            }
            System.out.println();
        }

    }
}
