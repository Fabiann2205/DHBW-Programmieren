package de.dhbwka.java.exams.coronaWarn;

import java.util.Date;

import static java.util.UUID.randomUUID;

public class Token {
    private final String value;
    private final Date date;

    public Token(String value, Date date) {
        this.value = value;
        this.date = date;
    }

    public Token() {
        this.value = randomUUID().toString();
        this.date = new Date();
    }

    @Override
    public String toString() {
        return this.value + " @ " + this.date;
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
