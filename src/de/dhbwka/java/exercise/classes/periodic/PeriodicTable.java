package de.dhbwka.java.exercise.classes.periodic;

import java.util.*;

public class PeriodicTable {
    private List<Element> arrlist = new ArrayList<Element>();

    public void addElement(Element e) {
        boolean add = true;
        for(int i=0; i<arrlist.size(); i++) {
            if((arrlist.get(i).equals(e))) {
                add = false;
            }
        }
        if (add) {
            arrlist.add(e);
        }
        
    }

    public boolean hasElement(int o) {
        for(int i=0; i<arrlist.size(); i++) {
            if((arrlist.get(i).getOrd() == o)) {
                return true;
            } 
        }
        return false;
    }

    public Element getElement(int o) {
        for(int i=0; i<arrlist.size(); i++) {
            if((arrlist.get(i).getOrd() == o)) {
                return arrlist.get(i);
            }
        }
        return null;
    }

    public Element[] getMetals() {
        List<Metal> arrlistausgabe = new ArrayList<Metal>();
        for(int i=0; i<arrlist.size(); i++) {
            if(arrlist.get(i) instanceof Metal) {                   // instanceof!!!!
                Metal tester = (Metal) (arrlist.get(i));
                arrlistausgabe.add(tester);
            }
        }
        Element[] a = arrlistausgabe.toArray(new Element[0]);
        return a;
    }

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();
        table.addElement(new Element("Wasserstoff", "H", 1, 'K', 3, true));
        table.addElement(new Element("Helium", "He", 2, 'K', 3, true));
        table.addElement(new Metal("Natrium", "Na", 11, 'M', 1, true, false, 21e6));
        table.addElement(new Metal("Eisen", "Fe", 26, 'N', 1, false, false, 10.02e6));
        table.addElement(new Metal("Germanium", "Ge", 32, 'N', 1, false, true, 1.45));
        table.addElement(new Element("Brom", "Br", 35, 'K', 2, true));
        table.addElement(new Metal("Tellur", "Te", 52, 'O', 1, true, true, 0.005));
        table.addElement(new Metal("Gold", "Au", 79, 'P', 1, false, false, 44e6));

        Element[] metalle = table.getMetals();

        System.out.println(table.getElement(2));

        for (int i = 0; i<metalle.length; i++) {
            System.out.println(metalle[i].toString());
        }
    }
}
