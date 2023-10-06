package de.dhbwka.java.exams.SnatChat;

public enum State {

    AVAILABLE("Available"),
    AWAY("Away"),
    DND("Do not disturb");

    private final String label;

    private State(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public String getLabel() {
        return label;
    }
}
