package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car {
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
