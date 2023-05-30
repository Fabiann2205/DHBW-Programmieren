package de.dhbwka.java.exercise.classes.abstr;

public class Bicycle extends Vehicle {
    public Bicycle(double speed) {
        super(speed);
        tires = 2;
        vMax = 30.0d;
    }

    public String info() {
        return ("Bicycle: 2 Räder mit 30 km/h max Speed, " + this.getClass().getSimpleName()
        + " at position " + this.getPosition()
        + " km with " + this.getTires()
        + " wheels at speed " + this.getSpeed()
        + " km/h of max. " + this.getVMax() + " km/h.");
    }
}
