package de.dhbwka.java.exams.soederMemory;

import java.awt.*;

public enum PlayerStatus {
    ACTIVE(Color.ORANGE),
    WAITING(Color.BLACK),
    FINISHED(Color.GRAY);


    private final Color color;
    PlayerStatus(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
