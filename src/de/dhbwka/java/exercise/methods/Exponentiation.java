package de.dhbwka.java.exercise.methods;

import java.util.Scanner;

public class Exponentiation {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Geben Sie bitte die Basis ein: ");
        double base = eingabe.nextDouble();
        System.out.print("Geben Sie bitte den positiven ganzzahligen Exponenten ein: ");
        int exponent = eingabe.nextInt();
        System.out.println(base + "^" + exponent + " = " + xPowerN(base, exponent));
        eingabe.close();
    }

    public static double xPowerN(double x,int n) {
        if (n==0) {
            return 1;
        } else {
            return x * xPowerN(x, (n-1));
        }
    }
}
