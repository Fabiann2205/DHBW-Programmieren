package de.dhbwka.java.exercise.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SiebPrimesFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bis zu welcher Zahl? ");
        int n = input.nextInt();
        input.close();
        int x, y = 0, primesx = 0;

        int[] sieve = new int[n - 1];
        int[] sieve2 = new int[n / 2];
        int[] primes = new int[n / 2];

        // create sieves
        for (x = 2; x <= n; x++) {
            sieve[x - 2] = x;
        }

        // for sieve == empty implementieren
        while (sieve[0] != 0) {
            // find minimum number
            int min = 0;
            for (x = 0; x < sieve.length; x++) {
                if (sieve[x] == 0) {
                    break;
                } else if (sieve[min] > sieve[x]) { //sieve[x] != 0
                    min = x;
                }
            }

            // put min into primes
            // index ändern
            primes[primesx] = sieve[min];
            primesx++;

            // min und alle vielfachen entfernen

            for (x = 0; x < sieve.length; x++) {
                if (sieve[x] != sieve[min] && (sieve[x] % sieve[min] != 0)) {
                    sieve2[y] = sieve[x];
                    y++;
                }
            }
            y = 0;

            // alles zurück in sieve und dann sieve2 leeren
            for (x = 0; x <= sieve.length - 1; x++) {
                sieve[x] = 0;
            }

            for (x = 0; x <= sieve2.length - 1; x++) {
                sieve[x] = sieve2[x];
            }

            for (x = 0; x <= sieve2.length - 1; x++) {
                sieve2[x] = 0;
            }
        }

        //print the number of primes and all primes and to a file
        System.out.printf("Es gibt %d Primzahlen im Bereich von 2 bis %d: %n", primesx, n);
        try (BufferedWriter out = new BufferedWriter(new FileWriter("resources/primes.txt"))) {
            for (x = 0; x < primesx; x++) {
                System.out.printf("%d\n", primes[x]);
                out.write(primes[x] + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error" + e);
        }


    }
}
