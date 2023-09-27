package de.dhbwka.java.exams.CHORonaProbe;

import javax.swing.*;

public class CellButton extends JButton {
    private double dose;
    private boolean polluter;
    private int positionX, positionY;

    public double getDose() {
        return dose;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isPolluter() {
        return polluter;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public void setPolluter(boolean polluter) {
        this.polluter = polluter;
    }

    public CellButton(String text, double dose, boolean polluter) {
        super(text);
        this.dose = dose;
        this.polluter = polluter;
    }

    public CellButton(String text, int xValue, int yValue) {
        super(text);
        this.positionX = xValue;
        this.positionY = yValue;
    }


}
