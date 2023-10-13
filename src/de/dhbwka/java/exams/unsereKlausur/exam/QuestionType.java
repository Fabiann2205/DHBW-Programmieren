package de.dhbwka.java.exams.unsereKlausur.exam;

public enum QuestionType {

    YES_NO("Yes/No question"),
    WITNESS("Witness may be involved"),
    GENERAL("General question");

    private final String label;

    private QuestionType(String label) {
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
