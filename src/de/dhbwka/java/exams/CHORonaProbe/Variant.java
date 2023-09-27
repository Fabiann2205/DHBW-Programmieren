package de.dhbwka.java.exams.CHORonaProbe;

public enum Variant {
    WILD_TYPE("Wildtyp", "SARS-COV-2"),
    ALPHA("Alpha", "B.1.1.7"),
    BETA("Beta", "B.1.351"),
    GAMMA("Gamma", "P.1"),
    DELTA("Delta", "B.1.617"),
    FETA("Feta", "O.u.z.o"),
    LAMBDA("Lambda", "C.37"),
    OMICRON("Omikron", "B.1.1.529");

    private final String label, designation;

    Variant(String label, String designation) {
        this.label = label;
        this.designation = designation;
    }

    public String getLabel() {
        return label;
    }

    public String getDesignation() {
        return designation;
    }
}
