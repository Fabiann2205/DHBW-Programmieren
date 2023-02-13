package de.dhbwka.java.exercise.classes;

public class Horner {
    double[] werte;


    public Horner(double[] werte) {
        this.werte = werte;
    }


    public double[] getWerte() {
        return this.werte;
    }

    public void setWerte(double[] werte) {
        this.werte = werte;
    }

    @Override
    public String toString() {
        String rueckgabe = "Wert: ";
        for(int i = 0; i < werte.length; i++){
            rueckgabe += werte[i];
            rueckgabe += ", ";
        }
        return rueckgabe;
    }

    public double getValue(double xWert) {
        double ergebnis;
        ergebnis = werte[werte.length-1];
        
        for (int i = werte.length-1; i > 0; i--) {
            ergebnis = ergebnis * xWert;
            ergebnis = ergebnis += werte[i-1];
        }

        return ergebnis;
    }
    
    public static void main(String[] args) {
        double[] testwerte = {11.0,7.0,-5.0,-4.0,2.0};
        Horner test = new Horner(testwerte);

        System.out.println(test.toString());
        System.out.println(test.getValue(2));
    }
}
