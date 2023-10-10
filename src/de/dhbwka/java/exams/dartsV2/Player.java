package de.dhbwka.java.exams.dartsV2;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int countDartsThrown;
    private List<Visit> visits;

    public Player(String name) {
        this.name = name;
        this.countDartsThrown = 0;
        this.visits = new ArrayList<>(9);
    }

    public String getName() {
        return name;
    }

    public int getCountDartsThrown() {
        return countDartsThrown;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public int getRemainingPoints() {
        int points = 0;
        for (Visit v : visits) {
            points += v.getValue();
        }
        return (501 - points);
    }

    public boolean addVisit(Visit visit) {
        int currentPoints = 0;
        for (Visit v : visits) {
            currentPoints += v.getValue();
        }

        if (!(501 - (currentPoints + visit.getValue()) < 0)) {
            if ((501 - (currentPoints + visit.getValue()) == 0)) {
                if (!visit.getLastField().isDoubleField()) {
                    return false;
                } else {
                    this.visits.add(visit);
                }
            } else if ((501 - (currentPoints + visit.getValue()) == 1)) {
                return false;
            } else {
                this.visits.add(visit);
            }

        } else {
            return false;
        }
        this.countDartsThrown += visit.getFields().size();
        return true;
    }
}
