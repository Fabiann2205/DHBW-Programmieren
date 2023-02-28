package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

public class RomanNumber {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte römische Zahl eingeben: ");
        String romanNumber = eingabe.next();
        eingabe.close();
        int decimalNumber = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            char c = romanNumber.charAt(i);
            switch (c) {
                case 'M':
                    decimalNumber += 1000;
                    break;
                case 'D':
                    decimalNumber += 500;
                    break;
                case 'C':
                    if (romanNumber.charAt(i+1)== 'D') {
                        decimalNumber += (500-100);
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'M') {
                        decimalNumber += (1000-100);
                        i+=1;
                    } else {
                        decimalNumber += 100;
                    }
                    break;
                case 'L':
                    decimalNumber += 50;
                    break;
                case 'X':
                    if (romanNumber.charAt(i+1)== 'D') {
                        decimalNumber += (500-10);
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'M') {
                        decimalNumber += (1000-10); 
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'C') {
                        decimalNumber += (100-10);
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'L') {
                        decimalNumber += (50-10);
                        i+=1; 
                    } else {
                        decimalNumber += 10;
                    }
                    break;
                case 'V':
                    decimalNumber += 5;
                    break;
                case 'I':
                    if (romanNumber.charAt(i+1)== 'D') {
                        decimalNumber += (500-1);
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'M') {
                        decimalNumber += (1000-1); 
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'C') {
                        decimalNumber += (100-1);
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'L') {
                        decimalNumber += (50-1); 
                        i+=1;
                    } else if (romanNumber.charAt(i+1)== 'V') {
                        decimalNumber += (5-1); 
                        i+=1;
                    } else {
                        decimalNumber += 1;
                    }
                    break;
            }
            System.out.println(decimalNumber);
        }
        System.out.println("Der Wert der Zahl " + romanNumber + " ist " + decimalNumber);

    }
}
