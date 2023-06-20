package de.dhbwka.java.exercise.collections.gas;

public class GasPrices {
    private final double diesel;
    private final double superE5;
    private final double superE10;

    public GasPrices(double diesel, double superE5, double superE10) {
        this.diesel = diesel;
        this.superE5 = superE5;
        this.superE10 = superE10;
    }

    @Override
    public String toString() {
        return "Diesel: " + diesel +
                ", SuperE5: " + superE5 +
                ", SuperE10: " + superE10;
    }
}
