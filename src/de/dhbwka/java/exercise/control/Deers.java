package de.dhbwka.java.exercise.control;

public class Deers {
    public static void main(String[] args) {
        int hirsche = 200, vermehrung = 10, freigabe = 15;
        int counter = 1;
        while (hirsche < 300) {
            hirsche = (int) (((hirsche / 100.0d) * (100.0d + vermehrung)) - freigabe);
            System.out.printf("%d: %3d Hirsche %n", counter, hirsche);
            counter++;
        }
    }

}
