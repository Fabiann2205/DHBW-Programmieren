package de.dhbwka.java.exercise.classes;

public record Complex(double real, double imag) {

    @Override
    public String toString() {
        return "Komplexe Zahl: " + this.real() + "+" + this.imag() + "i\n";
    }

    public Complex add(Complex comp) {
        return new Complex((this.real() + comp.real()), (this.imag() + comp.imag()));
    }

    public Complex sub(Complex comp) {
        return new Complex((this.real() - comp.real()), (this.imag() - comp.imag()));
    }

    public Complex mult(Complex comp) {
        return new Complex((this.real() * comp.real() - this.imag() * comp.imag()), (this.real() * comp.imag() + this.imag() * comp.real()));
    }

    public Complex div(Complex comp) {
        return new Complex(((this.real() * comp.real() + this.imag() * comp.imag()) / (comp.real() * comp.real() + comp.imag() * comp.imag())), ((this.imag() * comp.real() + this.real() * comp.imag()) / (comp.real() * comp.real() + comp.imag() * comp.imag())));
    }

    public double getMagnitude() {
        return Math.sqrt((this.real() * this.real()) + (this.imag() * this.imag()));
    }

    public static Complex[] sort(Complex[] unsort) {
        //Ausgabe unsortiert
        System.out.println("\nUnsortiert:\n");
        for (int x = 0; x < 10; x++) {
            System.out.println(unsort[x].real() + "+" + unsort[x].imag() + "i  Betrag: " + unsort[x].getMagnitude());

        }

        //BubbleSorter
        boolean sorter = true;
        Complex temp;
        while (sorter) {
            sorter = false;
            for (int x = 0; x < unsort.length - 1; x++) {
                if (unsort[x].getMagnitude() > unsort[x + 1].getMagnitude()) {
                    temp = unsort[x];
                    unsort[x] = unsort[x + 1];
                    unsort[x + 1] = temp;
                    sorter = true;
                }
            }
        }

        //Ausgabe sortiert

        return unsort;
    }

    public boolean isLess(Complex comp) {
        return this.getMagnitude() < comp.getMagnitude();
    }

    public static void main(String[] args) {
        Complex test = new Complex(2, 2);
        System.out.println(test.add(test));
        System.out.println(test.sub(test));
        System.out.println(test.mult(test));
        System.out.println(test.div(new Complex(3, 3)));
        System.out.println(test.getMagnitude());
        System.out.println(test.isLess(new Complex(8.571, 9.513)));

        //Sort Complex Numbers
        Complex[] unsortiert = new Complex[10];
        for (int x = 0; x < 10; x++) {
            unsortiert[x] = new Complex(Math.random() * 100, Math.random() * 100);
        }
        Complex[] sortiert;
        sortiert = sort(unsortiert);
        System.out.println("\nSortiert:\n");
        for (int x = 0; x < 10; x++) {
            System.out.println(sortiert[x].real() + "+" + sortiert[x].imag() + "i  Betrag: " + sortiert[x].getMagnitude());
        }
    }

}
