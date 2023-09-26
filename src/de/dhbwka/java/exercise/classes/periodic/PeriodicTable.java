package de.dhbwka.java.exercise.classes.periodic;

import java.util.ArrayList;
import java.util.List;

public class PeriodicTable {
    private final List<Element> arrlist = new ArrayList<>();

    public void addElement(Element e) {
        boolean add = true;
        for (Element element : arrlist) {
            if ((element.equals(e))) {
                add = false;
                break;
            }
        }
        if (add) {
            arrlist.add(e);
        }

    }

    public boolean hasElement(int o) {
        for (Element element : arrlist) {
            if ((element.getOrd() == o)) {
                return true;
            }
        }
        return false;
    }

    public Element getElement(int o) {
        for (Element element : arrlist) {
            if ((element.getOrd() == o)) {
                return element;
            }
        }
        return null;
    }

    public Element[] getMetals() {
        List<Metal> arrlistausgabe = new ArrayList<>();
        for (Element element : arrlist) {
            if (element instanceof Metal tester) {                   // instanceof!!!!
                arrlistausgabe.add(tester);
            }
        }
        return arrlistausgabe.toArray(new Element[0]);
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

        for (Element element : metalle) {
            System.out.println(element.toString());
        }
    }
}
