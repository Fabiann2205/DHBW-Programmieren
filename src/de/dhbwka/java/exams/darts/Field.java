package de.dhbwka.java.exams.darts;

// Teilaufgabe a
public class Field {
    //values
    private final String label;
    private final int value;
    private final boolean doubleField;

    //konstruktoren
    public Field(String label, int value, boolean doubleField) {
        this.label = label;
        this.value = value;
        this.doubleField = doubleField;
    }

    //getters
    public String getLabel() {
        return this.label;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isDoubleField() {
        return this.doubleField;
    }

    public boolean getDoubleField() {
        return this.doubleField;
    }
}
