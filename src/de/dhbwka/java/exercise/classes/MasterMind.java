package de.dhbwka.java.exercise.classes;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MasterMind {
    private char[] gegeben = new char[5];
    private int versuch, anzahlVersuche = 20;
    private String[] historie = new String[anzahlVersuche];
    private char[] buchstaben = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private int richtigeStelle = 0, falscheStelle = 0, indexHistorie = 0;
    private Boolean[] notUsed = {true, true, true, true, true};
    private Boolean[] notUsedInner = {true, true, true, true, true};

    //setter and getter
    public char[] getGegeben() {
        return this.gegeben;
    }

    public void setGegeben(char[] gegeben) {
        this.gegeben = gegeben;
    }

    public int getVersuch() {
        return this.versuch;
    }

    public int getIndexHistorie() {
        return this.indexHistorie;
    }

    public int getRichtigeStelle() {
        return this.richtigeStelle;
    }

    public void setVersuch(int versuch) {
        this.versuch = versuch;
    }

    public int getAnzahlVersuche() {
        return this.anzahlVersuche;
    }

    public void setAnzahlVersuche(int anzahlVersuche) {
        this.anzahlVersuche = anzahlVersuche;
    }

    public String[] getHistorie() {
        return this.historie;
    }

    public void setHistorie(String[] historie) {
        this.historie = historie;
    }

    //constructor
    public MasterMind() {;
        for(int i=0; i<gegeben.length; i++) {
            gegeben[i] = buchstaben[ThreadLocalRandom.current().nextInt(0, 7)];
        }
    }


    @Override
    public String toString() {
        String rueckgabe = "Solution: " ;
        for (int j = 0; j<gegeben.length; j++) {
            rueckgabe += gegeben[j];
        }
        
        rueckgabe += "\n" +indexHistorie + " bisherige(r) Versuch(e):\n";
        for (int i = 0; i < historie.length; i++) {
            if(historie[i] != null) {
                rueckgabe += historie[i] + "\n";
            }
        }
        return rueckgabe;

    }

    //raten
    public Boolean raten(String rate) {
        for(int i = 0; i<gegeben.length; i++) {
            if (notUsed[i]) {
                for(int j = 0; j<5; j++) {
                    if (notUsedInner[j]) {
                        if ((rate.charAt(j) == gegeben[i]) && (j == i) || gegeben[j] == rate.charAt(j)) {
                            richtigeStelle += 1;
                            notUsed[i] = false;
                            notUsedInner[j] = false;
                            notUsedInner[i] = false;
                            //notUsed[j] = false;
                            break;
                        } else if ((rate.charAt(j) == gegeben[i])) {
                            falscheStelle += 1;
                            notUsed[i] = false;
                            notUsedInner[j] = false;
                            break;
                        }
                    }
                } //ABCDE FADDB
            }
        }
        for (int f = 0; f<notUsed.length; f++) {
            notUsed[f] = true;
            notUsedInner[f] = true;
        };

        historie[indexHistorie] = rate + " " + richtigeStelle + "  " + falscheStelle;
        indexHistorie++;
        if (richtigeStelle == 5 || indexHistorie == 20) {
            return false;
        } else {
            richtigeStelle = 0;
            falscheStelle = 0;
            return true;
        }
    }

    public static void main(String[] args) {
        MasterMind einGame = new MasterMind();
        System.out.println("test");
        Scanner input = new Scanner(System.in);
        System.out.print("\nGeben Sie ihren Tipp ab: (5 Zeichen) ");
        String zumRaten = input.next();
        while(einGame.raten(zumRaten)) {
            System.out.print(einGame.toString());
            System.out.print("\nGeben Sie ihren Tipp ab: ");
            zumRaten = input.next();
        }
        if (einGame.getRichtigeStelle() == 5 && einGame.getIndexHistorie() == 20) {
            System.out.println("Geschafft mit 20 Zügen!");
        } else if (einGame.getRichtigeStelle() == 5) {
            System.out.println("Geschafft mit " + einGame.getIndexHistorie() + " Zügen!");
        } else {
            System.out.println("Leider nicht geschafft (mehr als 20 Züge)!");
        }
        


    } 
    
}
