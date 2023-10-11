package de.dhbwka.java.exams.FasidWorldCup;

public enum ResultType {

    UNKNOWN("Unknown", -1),
    DRAW("Draw", 0),
    HOME("Home", 1),
    GUEST("Guest", 2),
    FASID("Fasid", 99);

    private final String label;
    private final int toto;

    private ResultType(String label, int toto) {
        this.label = label;
        this.toto = toto;
    }

    @Override
    public String toString() {
        return label + " (" + toto + ")";
    }
}
