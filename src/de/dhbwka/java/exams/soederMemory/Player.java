package de.dhbwka.java.exams.soederMemory;

public class Player {
    private final String name;
    private int points;
    private PlayerStatus status;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.status = PlayerStatus.WAITING;
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

    public void addPoint() {
        this.points++;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }
}
