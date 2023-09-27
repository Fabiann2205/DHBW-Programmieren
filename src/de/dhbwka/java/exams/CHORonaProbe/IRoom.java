package de.dhbwka.java.exams.CHORonaProbe;

public interface IRoom {
    double getDose(int x, int y);

    void setDose(int x, int y, double dose);

    void addDose(int x, int y, double dose);

    void step();
}
