package de.dhbwka.java.exams.darts;

import java.util.ArrayList;
import java.util.List;

//Teilaufgabe d
public class Player {
    //fields
    private final String name;
    private int countDartsThrown;
    // private Visit[] visits = new Visit[9];
    private final List<Visit> visits1;

    //konstruktor
    public Player(String name) {
        this.name = name;
        visits1 = new ArrayList<>();
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getCountDartsThrown() {
        return this.countDartsThrown;
    }

    public Visit[] getVisits() {
        return this.visits1.toArray(new Visit[visits1.size()]);
    }

    //other methods
    public int getRemainingPoints() {
        //wie viele Punkte noch um 501 auf 0 zu bringen
        int valuetoreturn = 0;
        for (Visit visit : this.visits1) {
            for (int s = 0; s < visit.fields().length; s++) {
                valuetoreturn += visit.fields()[s].getValue();
            }
        }
        return (501 - valuetoreturn);
    }

    public boolean addVisit(Visit visit) {
        this.countDartsThrown += 3;
        if (!((this.getRemainingPoints() - visit.getValue()) < 0)) {
            if ((this.getRemainingPoints() - visit.getValue() != 1)) {
                //Teilaufgabe g: 2. Bedingung
                if (((this.getRemainingPoints() - visit.getValue() == 0 && visit.getLastField().isDoubleField())) || (this.getRemainingPoints() - visit.getValue() > 1)) {
                    this.visits1.add(visit);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
