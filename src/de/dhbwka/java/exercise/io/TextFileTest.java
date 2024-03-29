package de.dhbwka.java.exercise.io;

public class TextFileTest {
    public static void main(String[] args) {
        TextFile eins;
        try {
            eins = new TextFile("resources/bla.txt");
            try {
                System.out.println(eins.getLine(16));
                eins.setLine(16, "tschau");
                eins.replaceAll("meine", "unsere");
                eins.write();
                eins.close();
            } catch (LineNumberOutOfBoundsException e) {
                System.err.println("Error" + e);
            }
        } catch (IOErrorInFile e) {
            System.err.println("Error" + e);
        }

    }
}
