package de.dhbwka.java.exams.StadtLandFluss;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private char letter;
    private List<ColumnType> columns;
    private int timeLeft;
    private boolean running;
    private int min, max;

    public Game(int min, int max, int seconds) {
        this.timeLeft = seconds;
        this.min = Math.max(min, 3);
        this.max = Math.max(max, this.min);
    }

    private char createFirstCharacter() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.charAt(random.nextInt(alphabet.length()));
    }

    private List<ColumnType> createColumns() {
        List<ColumnType> liste = new ArrayList<>();
        Random random = new Random();
        int a = random.nextInt(this.min, this.max + 1);
        liste.add(ColumnType.COUNTRY);
        liste.add(ColumnType.CITY);
        liste.add(ColumnType.RIVER);
        if (a > 3) {
            for (int i = 0; i <= a; i++) {
                liste.add(); //add random fields except country city and river and no duplicates
            }
        }
        return liste;
    }
}
