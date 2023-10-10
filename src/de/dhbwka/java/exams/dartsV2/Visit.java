package de.dhbwka.java.exams.dartsV2;

import java.util.ArrayList;
import java.util.List;

public class Visit {
    private List<Field> fields = new ArrayList<>();

    public Visit(List<Field> fields) {
        if (fields.size() > 3) {
            throw new IllegalArgumentException();
        } else {
            this.fields = fields;
        }
    }

    public List<Field> getFields() {
        return this.fields;
    }

    public int getValue() {
        int value = 0;
        for (Field f : this.fields) {
            value += f.getValue();
        }
        return value;
    }

    public Field getLastField() {
        return this.fields.get(this.fields.size() - 1);
    }

    public static void main(String[] args) {
        Board board = new Board();
        List<Field> testfields = new ArrayList<>();
        testfields.add(board.parseField("20"));
        testfields.add(board.parseField("D20"));
        testfields.add(board.parseField("T20"));
        Visit test = new Visit(testfields);
        Field test2 = test.getLastField();
        int n = test.getValue();
        System.out.println("f");
    }
}
