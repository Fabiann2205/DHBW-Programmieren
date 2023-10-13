package de.dhbwka.java.exams.unsereKlausur.exam;

public class Question {
    private String text;
    private boolean start;
    private QuestionType type;

    public Question(String text, boolean start, QuestionType type) {
        this.text = text;
        this.start = start;
        this.type = type;
    }


    public String getText() {
        return text;
    }

    public boolean isStart() {
        return start;
    }

    public QuestionType getType() {
        return type;
    }
}
