package de.dhbwka.java.exams.soederMemory;

public class Player {
    private String name;
    private int points;
    private PlayerStatus status;

    public Player(String name, int points, PlayerStatus status) {
        this.name = name;
        this.points = points;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public PlayerStatus getStatus() {
        return status;
    }
}
