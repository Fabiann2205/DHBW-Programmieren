package de.dhbwka.java.exercise.ui.event;

import java.util.Random;
import java.util.Scanner;

public class ShellGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean run = true;
        boolean versuche;
        int gesuchteShell;
        String nochmal;
        int shell;
        while (run) {
            gesuchteShell = (random.nextInt(3)+1);
            versuche = true;

            while (versuche) {
                System.out.println("Shell 1-3: ");
                shell = input.nextInt();
                if (shell == gesuchteShell) {
                    System.out.println("Das ist die richtige Shell!");
                    System.out.println("Nochmal spielen? (Y/N)");
                    nochmal = input.next();
                    run = nochmal.contentEquals("Y");
                    versuche = false;
                } else {
                    System.out.println("Das ist die falsche Shell, versuche es erneut: ");
                }
            }
        }
        input.close();
    }
}
