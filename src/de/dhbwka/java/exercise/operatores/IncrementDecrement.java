package de.dhbwka.java.exercise.operatores;

public class IncrementDecrement {
    public static void main(String[] args) { 
        int i=0;
        int j=0;
        j = ++i; //j=1 i=1
        int k=j++ + ++i; //i=2 j=2 k=3
        System.out.println("k: " + k); 
        System.out.println("*: " + j++ + ++i); //j=3 i=3 k=3
        System.out.println(j++ + ++i); //j=4 i=4
        int m=j++ * ++i;    //m= 20 j=5 i=5
        System.out.println("m: " + m);
        int n=--j * --i;    //n= 16 j=4 i=4
        System.out.println("n: " + n); 
        System.out.println("i: " + i); 
        System.out.println("j: " + j);
    }
}
