package de.dhbwka.java.exercise.collections.comparators;

import java.util.Comparator;

public class yearComparator implements Comparator<String> {
    // wenn o1>o2 dann positiver rückgabewert
    @Override
    public int compare(String o1, String o2) {
        String[] splittedO1 = o1.split(";");
        String[] splittedO2 = o2.split(";");
        return Integer.parseInt(splittedO1[2])-Integer.parseInt(splittedO2[2]);
    }
}