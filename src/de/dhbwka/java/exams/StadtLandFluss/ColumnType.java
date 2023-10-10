package de.dhbwka.java.exams.StadtLandFluss;

public enum ColumnType {

    CITY("Stadt"),
    COUNTRY("Land"),
    RIVER("Fluss"),
    PROFESSION("Beruf"),
    ANIMAL("Tier"),
    NAME("Vorname"),
    SPORT("Sportart"),
    FOOD("Lebensmittel"),
    BEVERAGE("Getränk"),
    GAME("Spiel");

    private final String titel;

    private ColumnType(String titel) {
        this.titel = titel;
    }

    @Override
    public String toString() {
        return titel;
    }
}
