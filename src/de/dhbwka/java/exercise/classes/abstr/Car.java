package de.dhbwka.java.exercise.classes.abstr;

public class Car extends Vehicle{
    public Car(double speed) {
        super(speed);
        tires = 4;
        vMax = 140.0d;
    }

    public String info() {
        return ("Fahrzeug (Auto): 4 Räder mit 140 km/h max Speed, " + this.getClass().getSimpleName()
        + " at position " + this.getPosition()
        + " km with " + this.getTires()
        + " wheels at speed " + this.getSpeed()
        + " km/h of max. " + this.getVMax() + " km/h.");
    }
}
