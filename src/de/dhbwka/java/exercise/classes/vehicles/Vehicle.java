package de.dhbwka.java.exercise.classes.vehicles;

import java.util.Objects;

public class Vehicle{
    protected int tires;
    protected double vMax, position, speed; //position in km

    public Vehicle(double speed) {
        this.tires = 0;
        this.vMax = 0;
        this.position = 0;
        this.speed = speed;
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
        return (this.getClass().getSimpleName()
        + " at position " + this.getPosition()
        + " km with " + this.getTires()
        + " wheels at speed " + this.getSpeed()
        + " km/h of max. " + this.getVMax() + " km/h.");
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return tires == vehicle.tires && vMax == vehicle.vMax && position == vehicle.position && speed == vehicle.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tires, vMax, position, speed);
    }


    
}
