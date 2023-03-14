package de.dhbwka.java.exercise.io;

import java.io.File;
import java.util.Scanner;

public class FileExperiments {
    public static void main(String[] args) {
        File dir = new File("tempFiles");  //File.seperator
        dir.mkdir();
        File[] dateien = new File[3];
        for(int i=0; i<3; i++) {
            dateien[i] = new File(dir, "foo"+(i+1));
            try {
                dateien[i].createNewFile();
                System.out.println(dateien[i].getAbsolutePath());
            } catch (Exception e) {
                System.out.println(dateien[i].getAbsolutePath());
            }
        }
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        scanner.close();
        for (int i=0; i<3; i++) {
            dateien[i].delete();
        }
        dir.delete();

    }
}
