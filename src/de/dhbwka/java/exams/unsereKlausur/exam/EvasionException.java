package de.dhbwka.java.exams.unsereKlausur.exam;

public class EvasionException extends Exception {
    public EvasionException() {
        super("Message");
    }

    public EvasionException(String message) {
        super(message);
    }
}