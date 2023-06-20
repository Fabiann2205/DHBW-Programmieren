package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class PalindromeFile {
    public static void main(String[] args) {
        boolean run = true;
        Scanner eingabe = new Scanner(System.in);
        File apt = new File("resources/palindrome.txt");
        try {
            apt.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer fWriter = new FileWriter("resources/palindrome.txt", true)) {
            while(run) {
                System.out.print("Bitte Wort eingeben: ");
                String s = eingabe.next();
                //eingabe.close();
                if (s.matches("exit")) {
                    run = false;
                    break;
                }
                if (isPalindrome(s)) {
                    System.out.println(s + " ist ein Palindrom");
                    fWriter.write(s + "\n");
                } else {
                    System.out.println(s + " ist kein Palindrom");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        eingabe.close();
    }

    public static boolean isPalindrome(String s) {
        String s2 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s2 += s.charAt(i);
        }
        System.out.println("Umgedreht: " + s2);
        return s.equalsIgnoreCase(s2);
    }
}
