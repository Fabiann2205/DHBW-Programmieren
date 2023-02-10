package de.dhbwka.java.exercise.control;

import java.util.Scanner;
import java.lang.Math;

public class Quadratics {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        System.out.println("Gebe a ein: ");
        double a = eingabe.nextDouble();

        System.out.println("Gebe b ein: ");
        double b = eingabe.nextDouble();

        System.out.println("Gebe c ein: ");
        double c = eingabe.nextDouble();

        eingabe.close();

        double ergebnis1, ergebnis2;

        if (a == 0) {
            if (b == 0) {
                System.err.println("Die Gleichung ist degeneriert.");
            } else {
                ergebnis1 =  (c / b) * -1;
                System.out.println(ergebnis1);
            }
        } else {
            double D = ((b*b)-4*a*c);
            if (D >= 0) {
                ergebnis1 = (-b + Math.sqrt(D))/(2*a);
                ergebnis2 = (-b - Math.sqrt(D))/(2*a);
                System.out.println("x1: " + ergebnis1);
                System.out.println("x2: " + ergebnis2);
            } else if (D < 0) {
                System.err.println("Die Lösung ist konjugiert komplex.");
            } else {
                System.err.println("Something went wrong!");
            }
        }
    }
}
