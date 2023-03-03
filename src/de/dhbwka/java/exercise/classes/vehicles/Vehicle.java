package de.dhbwka.java.exercise.classes.vehicles;

public class Vehicle {
    private int tires = 0;
    private double vMax = 0.0d, position, speed; //position in km

    public Vehicle() {
        //this.tires = 0;
        //this.vMax = 0;
        //this.position = 0;
        //this.speed = 0;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        if (speed >= this.vMax) {
            this.speed = this.vMax;
        } else {
            this.speed = speed;
        }
    }

    public int getTires() {
        return this.tires;
    }

    // public void setTires(int tires) {
    //     this.tires = tires;
    // }

    public double getVMax() {
        return this.vMax;
    }

    // public void setVMax(double vMax) {
    //     this.vMax = vMax;
    // }

    public double getPosition() {
        return this.position;
    }

    // public void setPosition(double position) {
    //     this.position = position;
    // }

    public void drive(double minutes) {
        if (speed != 0) {
            this.position += minutes * (this.speed / 60.0d);
        }
    }


    @Override
    public String toString() {
        return "{" +
            " tires='" + getTires() + "'" +
            ", vMax='" + getVMax() + "'" +
            ", position='" + getPosition() + "'" +
            ", speed='" + getSpeed() + "'" +
            "}";
    }

    
}
