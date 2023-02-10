package de.dhbwka.java.exercise.control;

public class TemperatureTable {
    public static void main(String[] args) {
        double f = 0.0, c;
        System.out.printf("%10s|%s %n", "Fahrenheit", "Celsius" );
        System.out.printf("----------+-------- %n");
        while (f<=300) {
            c = getTemperature(f);
            System.out.printf("%-10.0f|%3.2f %n", f, c);
            f+=20;
        }
    }
    
    private static double getTemperature(double fahrenheit) {
        return ((5.0/9.0)*(fahrenheit-32.0));
    }
}
