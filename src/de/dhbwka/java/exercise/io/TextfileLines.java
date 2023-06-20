package de.dhbwka.java.exercise.io;

import java.io.*;

public class TextfileLines {
    public static void main (String[] args) {
        String ausgabeganz = "";
        try (BufferedReader br =new BufferedReader(new FileReader("resources/beispiel.txt"))){
            int i = 1;
            while (br.ready()) {
                String line = br.readLine();
                if(i==2 || i==3 || i==4 || i==5) {
                    System.out.println(line);
                    ausgabeganz += line;
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ausgabeganz);
    }
}
