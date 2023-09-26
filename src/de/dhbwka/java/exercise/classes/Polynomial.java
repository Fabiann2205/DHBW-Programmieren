package de.dhbwka.java.exercise.classes;

public class Polynomial {
    private int a, b, c;

    // Konstruktoren

    public Polynomial(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Polynomial() {
    }

    // getter und setter

    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return this.b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return this.c;
    }

    public void setC(int c) {
        this.c = c;
    }

    // Methoden

    @Override
    public String toString() {
        return "{" + this.getA() + "x^2 + " +
                this.getB() + "x + " +
                this.getC() +
                "}";
    }

    public double[] getNullstellen() {
        double x1, x2;
        int length = 2;

        x1 = (((-1) * this.getB() + Math.sqrt((this.getB() * this.getB()) - (4 * this.getA() * this.getC())))
                / (2 * this.getA()));
        x2 = (((-1) * this.getB() - Math.sqrt((this.getB() * this.getB()) - (4 * this.getA() * this.getC())))
                / (2 * this.getA()));

        if (Double.isNaN(x1) & Double.isNaN(x2)) {
            length = 0;
        } else if (x1 == x2) {
            length = 1;
        } else {
            length = 2;
        }

        double[] werte = new double[length];
        if (length == 1) {
            werte[0] = x1;
        } else if (length == 2) {
            werte[0] = x1;
            werte[1] = x2;
        }
        return werte;
    }

    public double getErgebnis(double xWert) {
        return (this.getA() * (xWert * xWert) + this.getB() * xWert + this.getC());
    }

    public Polynomial addPolynomial(Polynomial polynom) {
        return new Polynomial((this.getA() + polynom.getA()), (this.getB() + polynom.getB()), (this.getC() + polynom.getC()));
    }

    public Polynomial subtractPolynomial(Polynomial polynom) {
        return new Polynomial((this.getA() - polynom.getA()), (this.getB() - polynom.getB()), (this.getC() - polynom.getC()));
    }

    //Rückgabe eines Arrays: 0 x^4 bis 4 kein x
    public int[] multiplicatePolynomial(Polynomial polynom) {
        int[] ergebnisse = new int[5];
        ergebnisse[0] = (this.getA() * polynom.getA());
        ergebnisse[1] = ((this.getA() * polynom.getB()) + (this.getB() * polynom.getA()));
        ergebnisse[2] = ((this.getA() * polynom.getC()) + (this.getB() * polynom.getB()) + (this.getC() * polynom.getA()));
        ergebnisse[3] = ((this.getB() * polynom.getC()) + (this.getC() * polynom.getB()));
        ergebnisse[4] = (this.getC() * polynom.getC());
        return ergebnisse;
    }

    public static void main(String[] args) {
        Polynomial krank = new Polynomial(0, 1, 1);
        double[] haha = new double[2];
        haha = krank.getNullstellen();
        for (double v : haha) {
            System.out.println(v);
        }
        Polynomial krank2 = new Polynomial(3, 9, 6);
        int[] test = krank.multiplicatePolynomial(krank2);
        for (int j : test) {
            System.out.println(j);
        }
    } // 2 nullstellen :3,9,6; 1 nullstelle:1,4,4; keine nullstelle: 2,3,30

}
