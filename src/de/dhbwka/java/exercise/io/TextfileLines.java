package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextfileLines {
    public static void main(String[] args) {
        StringBuilder ausgabeganz = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("resources/beispiel.txt"))) {
            int i = 1;
            while (br.ready()) {
                String line = br.readLine();
                if (i == 2 || i == 3 || i == 4 || i == 5) {
                    System.out.println(line);
                    ausgabeganz.append(line);
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Error" + e);
        }
        System.out.println(ausgabeganz);
    }
}
