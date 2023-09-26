package de.dhbwka.java.exercise.classes;

public class Horner {
    private double[] werte;


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
        StringBuilder rueckgabe = new StringBuilder("Wert: ");
        for (double v : werte) {
            rueckgabe.append(v);
            rueckgabe.append(", ");
        }
        return rueckgabe.toString();
    }

    public double getValue(double xWert) {
        double ergebnis;
        ergebnis = werte[werte.length - 1];

        for (int i = werte.length - 1; i > 0; i--) {
            ergebnis = ergebnis * xWert;
            ergebnis += werte[i - 1];
        }

        return ergebnis;
    }

    public static void main(String[] args) {
        double[] testwerte = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        Horner test = new Horner(testwerte);

        System.out.println(test);
        System.out.println(test.getValue(1));
    }
}
