package de.dhbwka.java.exercise.classes;
import java.lang.Math;
public class Complex {

    private double real, imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    @Override
    public String toString() {
        return "Komplexe Zahl: " + this.getReal() + "+" + this.getImag() + "i\n";
    }

    public Complex add(Complex comp) {
        return new Complex((this.getReal()+comp.getReal()),(this.getImag()+comp.getImag()));
    }

    public Complex sub(Complex comp) {
        return new Complex((this.getReal()-comp.getReal()), (this.getImag()-comp.getImag()));
    }

    public Complex mult(Complex comp) {
        return new Complex((this.getReal()*comp.getReal()-this.getImag()*comp.getImag()), (this.getReal()*comp.getImag()+this.getImag()*comp.getReal()));
    }

    public Complex div(Complex comp) {
        return new Complex(((this.getReal()*comp.getReal()+this.getImag()*comp.getImag())/(comp.getReal()*comp.getReal()+comp.getImag()*comp.getImag())), ((this.getImag()*comp.getReal()+this.getReal()*comp.getImag())/(comp.getReal()*comp.getReal()+comp.getImag()*comp.getImag())));
    }

    public double getMagnitude() {
        return Math.sqrt((this.getReal()*this.getReal())+(this.getImag()*this.getImag()));
    }

    public static Complex[] sort(Complex[] unsort) {
        //Ausgabe unsortiert
        System.out.println("\nUnsortiert:\n");
        for(int x=0; x<10; x++) {
            System.out.println(unsort[x].getReal()+ "+" + unsort[x].getImag() + "i  Betrag: " + unsort[x].getMagnitude());
            
        }

        //BubbleSorter
        boolean sorter = true;
        Complex temp;
        while(sorter) {
            sorter = false;
            for(int x=0; x<unsort.length-1; x++) {
                if (unsort[x].getMagnitude()>unsort[x+1].getMagnitude()) {
                    temp = unsort[x];
                    unsort[x] = unsort[x+1];
                    unsort[x+1] = temp;
                    sorter = true;
                }
            }
        }

        //Ausgabe sortiert
        
        return unsort;
    }

    public boolean isLess(Complex comp) {
        if (this.getMagnitude()<comp.getMagnitude()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        Complex test = new Complex(2,2);
        System.out.println(test.add(test).toString());
        System.out.println(test.sub(test).toString());
        System.out.println(test.mult(test).toString());
        System.out.println(test.div(new Complex(3,3)).toString());
        System.out.println(test.getMagnitude());
        System.out.println(test.isLess(new Complex(8.571,9.513)));

        //Sort Complex Numbers
        Complex[] unsortiert = new Complex[10];
        for(int x = 0; x<10; x++) {
            unsortiert[x] = new Complex(Math.random()*100, Math.random()*100);
        }
        Complex[] sortiert;
        sortiert = sort(unsortiert);
        System.out.println("\nSortiert:\n");
        for(int x=0; x < 10; x++) {
            System.out.println(sortiert[x].getReal()+ "+" + sortiert[x].getImag() + "i  Betrag: " + sortiert[x].getMagnitude());
        }
    }

}
