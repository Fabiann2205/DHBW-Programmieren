package de.dhbwka.java.exams.darts;

/**
 * @param fields max 3 Würfe
 */ //Teilaufgabe c
public record Visit(Field[] fields) {
    public Visit(Field[] fields) {
        if (fields.length > 3) {
            throw new IllegalArgumentException();
        } else {
            this.fields = fields;
        }
    }

    public int getValue() {
        int valuetoreturn = 0;
        for (Field field : this.fields) {
            valuetoreturn += field.getValue();
        }
        return valuetoreturn;
    }

    public Field getLastField() {
        return fields[2];
    }
}
