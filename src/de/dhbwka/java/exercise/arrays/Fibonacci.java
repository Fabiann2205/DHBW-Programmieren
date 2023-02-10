package de.dhbwka.java.exercise.arrays;

public class Fibonacci {
    public static void main(String[] args) {
        long f0 = 1, f1 =1;
        int n;
        long[] fn = new long[50];
        fn[0] = 1;
        fn[1] = 1;
        for(n=2; n<50; n++) {
            fn[n] = f0 + f1;
            f0 = f1;
            f1 = fn[n];
        }
        for(n=0; n<50; n++) {
            System.out.printf("%3d : %-12d %n", n+1, fn[n]);
        }


    }
}
