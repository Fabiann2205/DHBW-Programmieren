package de.dhbwka.java.exams.coronaWarn;
import java.awt.Color;
public enum WarnStatus {
    UNKNOWN("Unknown", new Color(175,175,175)),
    OK("Ok", new Color(100,200,100)),
    ALARM("Possible encounter", new Color(255,100,100)),
    INFECTED("In quarantine", new Color(150,150,255));

    private final String text;
    private final Color color;

    WarnStatus(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }
}
