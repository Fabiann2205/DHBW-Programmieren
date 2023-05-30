package de.dhbwka.java.exercise.classes.abstr;

public class RacingCar extends Car{
    public RacingCar(double speed) {
        super(speed);
        tires = 4;
        vMax = 220.0d;
    }
}
