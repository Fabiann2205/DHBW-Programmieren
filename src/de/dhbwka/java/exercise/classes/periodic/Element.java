package de.dhbwka.java.exercise.classes.periodic;

import java.util.*;

public class Element {
    private String name, symbol;
    private int ord, shell, phase;
    private boolean grouptype;


    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrd() {
        return this.ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public int getShell() {
        return this.shell;
    }

    public void setShell(int shell) {
        this.shell = shell;
    }

    public int getPhase() {
        return this.phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public boolean isGrouptype() {
        return this.grouptype;
    }

    public boolean getGrouptype() {
        return this.grouptype;
    }

    public void setGrouptype(boolean grouptype) {
        this.grouptype = grouptype;
    }


    // Konstruktoren

    public Element(String name, String symbol, int ord, int shell, int phase, boolean grouptype) {
        this.name = name;
        this.symbol = symbol;
        this.ord = ord;
        this.shell = shell;
        this.phase = phase;
        this.grouptype = grouptype;
    }


    @Override
    public String toString() {
        String type = (this.getGrouptype()) ? "Hauptgruppe" : "Nebengruppe";
        String zustand = "fest";
        switch (this.getPhase()) {
            case 1: 
                zustand = "fest";
                break;
            case 2:
                zustand = "flüssig";
                break;
            case 3:
                zustand = "gasförmig";
                break;
            default:
                zustand = "haha";
                break;
        }
        return this.getName() + " (" + this.getSymbol() + "," + 
            this.getOrd() + ") Schale: " + this.getShell() + ", " +
            zustand + ", Gruppe: " + type;
    }


    @Override
    public boolean equals(Object o) {
        Element test = (Element) o;
        if (o.getClass().getSimpleName() == "Element" && this.getOrd() == test.getOrd()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, ord, shell, phase, grouptype);
    }
    

}
