package de.dhbwka.java.exercise.collections.comparators;

import java.util.Comparator;

public class titleComparator implements Comparator<String> {
// wenn o1>o2 dann positiver rückgabewert
    @Override
    public int compare(String o1, String o2) {
        String[] splittedO1 = o1.split(";");
        String[] splittedO2 = o2.split(";");
        return splittedO1[0].compareTo(splittedO2[0]);
    }
}
