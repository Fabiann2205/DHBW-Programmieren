package de.dhbwka.java.exams.FasidWorldCup;

public class FasidException extends Exception {
    public FasidException() {
        super("Message");
    }

    public FasidException(String message) {
        super(message);
    }
}