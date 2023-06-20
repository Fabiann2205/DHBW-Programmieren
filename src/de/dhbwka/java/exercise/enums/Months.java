package de.dhbwka.java.exercise.enums;

import java.util.Arrays;
import java.util.Calendar;

public enum Months {
    JANUAR(31, new String[]{"Hartung", "Eismond"}),
    FEBRUAR(28, new String[]{"Hornung","Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"}),
    MAERZ(31, new String[]{"Lenzing", "Lenzmond"}),
    APRIL(30, new String[]{"Launing", "Ostermond"}),
    MAI(31, new String[]{"Winnemond", "Blumenmond"}),
    JUNI(30, new String[]{"Brachet", "Brachmond"}),
    JULI(31, new String[]{"Heuert", "Heumond"}),
    AUGUST(31, new String[]{"Ernting", "Erntemond", "Bisemond"}),
    SEPTEMBER(30, new String[]{"Scheiding", "Herbstmond"}),
    OKTOBER(31, new String[]{"Gilbhart", "Gilbhard", "Weinmond"}),
    NOVEMBER(30, new String[]{"Nebelung", "Windmond", "Wintermond"}),
    DEZEMBER(31, new String[]{"Julmond", "Heilmond", "Christmond", "Dustermond"});

    private final int tage;
    private final String[] alteNamen;

    Months(int tage, String[] alteNamen) {
        this.tage = tage;
        this.alteNamen = alteNamen;
    }

    int getTage() {
        return this.tage;
    }
    String[] getAlteNamen() {
        return this.alteNamen;
    }

    public static void main(String[] args) {
        Months[] monate = {JANUAR, FEBRUAR, MAERZ, APRIL, MAI, JUNI, JULI, AUGUST, SEPTEMBER, OKTOBER, NOVEMBER, DEZEMBER};
        System.out.println("Der " + monate[Calendar.getInstance().get(Calendar.MONTH)] + " hat " + monate[Calendar.getInstance().get(Calendar.MONTH)].getTage() + " Tage und hieß früher " + Arrays.toString(monate[Calendar.getInstance().get(Calendar.MONTH)].getAlteNamen()));
    }
}
