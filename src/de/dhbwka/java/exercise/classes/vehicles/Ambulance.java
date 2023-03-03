package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car {
    public Ambulance(double speed) {
        super(speed);
        tires = 4;
        vMax = 140.0d;
    }

    Boolean blaulicht = false;

    public Boolean getBlaulicht() {
        return this.blaulicht;
    }

    public void setBlaulicht(Boolean blaulicht) {
        this.blaulicht = blaulicht;
    }

    public void enableBlaulicht() {
        this.blaulicht = true;
    }

    public void disableBlaulicht() {
        this.blaulicht = false;
    }

}
