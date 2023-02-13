package de.dhbwka.java.exercise.classes;

import java.util.Scanner;

public class Lotto {
    private int anzahlKugeln, gesamtzahlKugeln;
    private int[] tipp;
    private int[] gezogeneKugeln;
    
    public Lotto(int anzahlKugeln, int gesamtzahlKugeln) {
        this.anzahlKugeln = anzahlKugeln;
        this.gesamtzahlKugeln = gesamtzahlKugeln;
    }
    //tippen() schreiben methode 1
    public String tippen() {
        String meldung = "ok";
        Scanner input = new Scanner(System.in);
        tipp = new int[anzahlKugeln];
        for (int i = 1; i<= anzahlKugeln; i++) {
            System.out.print("Geben Sie bitte Ihren Tipp für die "+ i + ". Zahl ein: ");
            tipp[i-1] = input.nextInt(); 
        }
        input.close();
        boolean sorter = true;
        int temp;
        while(sorter) {
            sorter = false;
            for(int x=0; x<tipp.length-1; x++) {
                if (tipp[x]>tipp[x+1]) {
                    temp = tipp[x];
                    tipp[x] = tipp[x+1];
                    tipp[x+1] = temp;
                    sorter = true;
                }
            }
        }
        return meldung;
    }
    public String tippen(int[] tipp) {
        String meldung = "ok";
        if (tipp[0] <= 0 && tipp[tipp.length-1]>gesamtzahlKugeln) {
            meldung = "error";
        } else {
            this.tipp = tipp;
        }
        boolean sorter = true;
        int temp;
        while(sorter) {
            sorter = false;
            for(int x=0; x<tipp.length-1; x++) {
                if (tipp[x]>tipp[x+1]) {
                    temp = tipp[x];
                    tipp[x] = tipp[x+1];
                    tipp[x+1] = temp;
                    sorter = true;
                }
            }
        }
        return meldung;
    }

    public void ziehen() {
        gezogeneKugeln = new int[anzahlKugeln];
        //int neueKugel;
        // boolean newrun =true;
        // for (int i = 0; i<anzahlKugeln; i++) {
            for(int i = 0; i < gezogeneKugeln.length; i++) {
                System.out.println("Bitte int eingeben...");
                gezogeneKugeln[i] = (int) (Math.random()*gesamtzahlKugeln);
               
                for(int j = 0; j < i; j++) {
                    if(gezogeneKugeln[i] == gezogeneKugeln[j]) {
                        System.out.println("Bitte int erneut eingeben...");
                        gezogeneKugeln[i] = (int) (Math.random()*gesamtzahlKugeln);
                        i--;
                    }
                }
            // }
            // while (newrun) {
            //     neueKugel = (int) (Math.random()*gesamtzahlKugeln);
            //     boolean tester = true;
            //     int z = 0;
            //     while(tester) {
            //         if (z>gezogeneKugeln.length-1) {
            //             break;
            //         }
            //         if (gezogeneKugeln[i] == neueKugel) {
            //             tester = false;
            //         }

            //         z++;
            //     }
            //     if (tester == true) {
            //         gezogeneKugeln[i] = neueKugel;
            //         newrun = false;
            //     }
            // }
            //doppelte ziehungen vermeiden!
        }

        //sortieren
        boolean sorter = true;
        int temp;
        while(sorter) {
            sorter = false;
            for(int x=0; x<gezogeneKugeln.length-1; x++) {
                if (gezogeneKugeln[x]>gezogeneKugeln[x+1]) {
                    temp = gezogeneKugeln[x];
                    gezogeneKugeln[x] = gezogeneKugeln[x+1];
                    gezogeneKugeln[x+1] = temp;
                    sorter = true;
                }
            }
        }
    }

    public int richtige() {
        int richtige = 0;
        for (int i = 0; i<gezogeneKugeln.length; i++) {
            for (int s = 0; s<tipp.length; s++) {
                if (gezogeneKugeln[i] == tipp[s]) {
                    richtige++;
                }
            }
        }
        return richtige;
    }


    @Override
    public String toString() {
        String rueckgabe = "Tipp: ";
        if (tipp[0]!= 0) {
            for(int i = 0; i < tipp.length; i++){
                rueckgabe += tipp[i];
                rueckgabe += ", ";
            }
        }
        rueckgabe += "\nGezogene Zahlen: ";
        if (gezogeneKugeln[0] != 0) {
            for(int i = 0; i < gezogeneKugeln.length; i++){
                rueckgabe += gezogeneKugeln[i];
                rueckgabe += ", ";
            }
        }
        if (gezogeneKugeln[0] != 0 && tipp[0]!= 0) {
            rueckgabe += "\nRichtige: "+this.richtige();
        }
        return rueckgabe; //Ausgabe gestalten
    }
    
    public static void main(String[] args) {
        Lotto deutschesLotto = new Lotto(6, 49);
        deutschesLotto.ziehen();
        deutschesLotto.tippen();
        System.out.println(deutschesLotto.toString());
    }

}
