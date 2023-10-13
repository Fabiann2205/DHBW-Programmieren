package de.dhbwka.java.exams.unsereKlausur.exam;

import java.util.ArrayList;
import java.util.List;

public class Evasion {
    private String text;
    private List<QuestionType> types = new ArrayList<>();

    public Evasion(String text, List<QuestionType> types) {
        this.text = text;
        this.types = types;
    }

    public boolean isEvasionFor(Question q) {
        for (QuestionType s : this.types) {
            if (q.getType() == s) {
                return true;
            }
        }
        return false;
    }

    public String getText() {
        return text;
    }

    public List<QuestionType> getTypes() {
        return types;
    }

}
