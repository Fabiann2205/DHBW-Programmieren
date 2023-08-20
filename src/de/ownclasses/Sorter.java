package de.ownclasses;

import java.util.Arrays;

public class Sorter {
    double[] vector;

    public Sorter(int[] vector) {
        this.vector = Arrays.stream(vector).asDoubleStream().toArray();
    }

    public Sorter(double[] vector) {
        this.vector = vector;
    }

    public double[] getVector() {
        return this.vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public void bubblesort() {
        boolean sorter = true;
        double temp;
        while(sorter) {
            sorter = false;
            for(int x=0; x<this.vector.length-1; x++) {
                if (this.vector[x]>this.vector[x+1]) {
                    temp = this.vector[x];
                    this.vector[x] = this.vector[x+1];
                    this.vector[x+1] = temp;
                    sorter = true;
                }
            }
        }
    }

    public void insertSort() {
        double k;
        for (int i = 0; i < this.vector.length; i++) {
            for (int j = this.vector.length-1; j > 0; j--) {
                if (this.vector[j-1] > this.vector[j]) {
                    k = this.vector[j];
                    this.vector[j] = this.vector[j - 1];
                    this.vector[j - 1] = k;
                }
            }
        }
    }
}

