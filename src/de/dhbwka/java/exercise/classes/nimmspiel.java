package de.dhbwka.java.exercise.classes;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class nimmspiel {
    private int haufen1, haufen2, maxSteineProHaufen;
    private String spieler1, spieler2, nächsterSpieler;

    public nimmspiel(int maxSteineProHaufen, String spieler1, String spieler2) {
        this.maxSteineProHaufen = maxSteineProHaufen;
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        this.nächsterSpieler = spieler1;
        this.haufen1 = ThreadLocalRandom.current().nextInt(1, maxSteineProHaufen + 1);
        this.haufen2 = ThreadLocalRandom.current().nextInt(1, maxSteineProHaufen + 1);
    }

    public int getHaufen1() {
        return this.haufen1;
    }

    public void setHaufen1(int haufen1) {
        this.haufen1 = haufen1;
    }

    public int getHaufen2() {
        return this.haufen2;
    }

    public void setHaufen2(int haufen2) {
        this.haufen2 = haufen2;
    }

    public int getMaxSteineProHaufen() {
        return this.maxSteineProHaufen;
    }

    public void setMaxSteineProHaufen(int maxSteineProHaufen) {
        this.maxSteineProHaufen = maxSteineProHaufen;
    }

    public String getSpieler1() {
        return this.spieler1;
    }

    public void setSpieler1(String spieler1) {
        this.spieler1 = spieler1;
    }

    public String getSpieler2() {
        return this.spieler2;
    }

    public void setSpieler2(String spieler2) {
        this.spieler2 = spieler2;
    }

    public String getNächsterSpieler() {
        return this.nächsterSpieler;
    }

    public void setNächsterSpieler(String nächsterSpieler) {
        this.nächsterSpieler = nächsterSpieler;
    }

    public void nächsterZug() {
        Scanner eingabe = new Scanner(System.in);
        int haufen = 0, haufen1;
        while(haufen != 1 && haufen != 2 || haufen == 1 && this.getHaufen1()<1 || haufen == 2 && this.getHaufen2()<1) {
            System.out.print("Spieler " + this.getNächsterSpieler() + ": Von welchem Haufen ziehen Sie Steine? (1/2) ");
            haufen = eingabe.nextInt();
        }
        int anzahl = 99999;
        if (haufen == 1) {
            haufen1 = this.getHaufen1();
        } else {
            haufen1 = this.getHaufen2();
        }
        while(anzahl<=0 || anzahl > haufen1) {
            System.out.print("Spieler " + this.getNächsterSpieler() + ": Wieviele Kugeln ziehen Sie? ");
            anzahl = eingabe.nextInt();
        }
        // eingabe.close();

        if(haufen == 1) {
            this.setHaufen1(this.getHaufen1()-anzahl);
        } else {
            this.setHaufen2(this.getHaufen2()-anzahl);
        }
        if (nächsterSpieler.toString() == spieler1.toString()) {
            nächsterSpieler = spieler2;
        } else {
            nächsterSpieler = spieler1;
        } 
    }

    public Boolean winner() {
        if (this.getHaufen1()== 0 && this.getHaufen2() == 0) {
            System.out.println("Spiel beendet.");
            if (this.getNächsterSpieler() == this.getSpieler1()) {
                System.out.println("Gewonnen hat Spieler " + this.getSpieler2());
            } else {
                System.out.println("Gewonnen hat Spieler " + this.getSpieler1());
            }
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public String toString() {
        return "Spieler: " + this.getSpieler1() + ", " + this.getSpieler2() + 
        ", Haufen 1: " + this.getHaufen1() + " Steine, Haufen 2: " + this.getHaufen2() + " Steine";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie folgende Daten ein: Anzahl Steine pro Haufen Max, Spieler 1, Spieler 2 ");
        nimmspiel erstesGame = new nimmspiel(input.nextInt(), input.next(), input.next());
        input.nextLine();
        // input.close();
        System.out.println(erstesGame.toString());
        while(erstesGame.winner()) {
            erstesGame.nächsterZug();
            System.out.println("\n" + erstesGame.toString());
        }
    }

}
//trys catch implement