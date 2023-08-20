package de.dhbwka.java.exams.darts;

//Teilaufgabe c
public class Visit {
    //max 3 Würfe
    private Field[] fields;

    public Visit(Field[] fields) {
        if (fields.length>3) {
            throw new IllegalArgumentException();
        } else {
            this.fields = fields;
        }
    }

    public Field[] getFields() {
        return this.fields;
    }

    public int getValue() {
        int valuetoreturn = 0;
        for (int i = 0; i<this.fields.length; i++) {
            valuetoreturn += this.fields[i].getValue();
        }
        return valuetoreturn;
    }

    public Field getLastField() {
        return fields[2];
    }
}
