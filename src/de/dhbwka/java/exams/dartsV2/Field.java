package de.dhbwka.java.exams.dartsV2;

public class Field {
    private String label;
    private int value;
    private boolean doubleField;

    public Field(String label, int value, boolean doubleField) {
        this.label = label;
        this.value = value;
        this.doubleField = doubleField;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    public boolean isDoubleField() {
        return doubleField;
    }
}
