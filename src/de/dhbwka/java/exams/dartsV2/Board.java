package de.dhbwka.java.exams.dartsV2;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields = new ArrayList<>();

    public Board() {
        for (int i = 1; i <= 20; i++) { // von 0-19 ist belegt
            fields.add(new Field(String.valueOf(i), i, false));
        }
        for (int i = 1; i <= 20; i++) { // von 20-39
            fields.add(new Field("D" + i, i * 2, true));
        }
        for (int i = 1; i <= 20; i++) { // von 40-59
            fields.add(new Field("T" + i, i * 3, true));
        }
        fields.add(new Field("25", 25, false));
        fields.add(new Field("BULL", 25, false));
        fields.add(new Field("x", 0, false));
    }

    public Field parseField(String label) {
        for (int i = 0; i < fields.size(); i++) {
            if (label.equals(this.fields.get(i).getLabel())) {
                return this.fields.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Board test = new Board();
        System.out.println(test.parseField("D20"));
    }
}
