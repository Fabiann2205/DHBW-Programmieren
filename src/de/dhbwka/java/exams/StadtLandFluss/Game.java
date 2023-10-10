package de.dhbwka.java.exams.StadtLandFluss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    private char letter;
    private List<ColumnType> columns;
    private int timeLeft;
    private boolean running;
    private int min, max;

    private List<Sheet> registeredSheets = new ArrayList<>();

    public char getLetter() {
        return letter;
    }

    public List<ColumnType> getColumns() {
        return columns;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public boolean isRunning() {
        return running;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

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
            int b = 0;
            if (a - 3 > ColumnType.values().length - 3) {
                b = ColumnType.values().length - 3;
            } else {
                b = a - 3;
            }
            liste.addAll(Arrays.asList(ColumnType.values()).subList(3, b + 3));
        }
        return liste;
    }

    public void register(Sheet sheet) {
        this.registeredSheets.add(sheet);
    }

    public void startGame() {
        if (!this.running) {
            this.letter = this.createFirstCharacter();
            this.columns = this.createColumns();
        }
    }

    public void stopGame() {
        for (Sheet a : registeredSheets) {
            a.inform();
        }
    }

    private List<Integer> calculatePoints() {
        int i = 0;
        List<Integer> ergebnisse = new ArrayList<>();
        List<String> woerter = new ArrayList<>();
        for (ColumnType c : columns) {
            for (Sheet d : registeredSheets) {
                woerter.add(d.getWordsForAllLabels().get(i));
            }
            int j = 0;
            int ergebnis = 0;
            for (String s : woerter) {
                if (s.charAt(0) == this.letter) {
                    ergebnis += 5;
                }
                woerter.remove(j);
                if (!woerter.contains(s)) {
                    ergebnis += 5;
                }
                j++;
            }
            i++;
        }
        return ergebnisse;
    }

    public static void main(String[] args) {
        Game game = new Game(3, 20, 60);
    }


}
