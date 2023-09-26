package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String s = eingabe.next();
        eingabe.close();
        if (isPalindrome(s)) {
            System.out.println(s + " ist ein Palindrom");
        } else {
            System.out.println(s + " ist kein Palindrom");
        }
    }

    public static boolean isPalindrome(String s) {
        StringBuilder s2 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            s2.append(s.charAt(i));
        }
        System.out.println("Umgedreht: " + s2);
        return s.equalsIgnoreCase(s2.toString());
    }
}
