package de.dhbwka.java.exams.SnatChat;

import java.awt.*;
import java.util.Random;

public class Account {
    private String name;
    private State state;
    private Color color;

    public Account(String name) {
        this.name = name;
        this.state = State.AVAILABLE;
        Random random = new Random();
        this.color = new Color(random.nextInt(201), random.nextInt(201), random.nextInt(201));
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
