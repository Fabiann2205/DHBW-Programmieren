package de.dhbwka.java.exercise.classes.periodic;

public class Metal extends Element{
    private boolean metalloid;
    private double leitfaehigkeit;

    // Element class
    public Metal(String name, String symbol, int ord, int shell, int phase, boolean grouptype, boolean metalloid, double leitfaehigkeit) {
        super(name, symbol, ord, shell, phase, grouptype);
        this.setMetalloid(metalloid);
        this.setLeitfaehigkeit(leitfaehigkeit);
    }


    public boolean isMetalloid() {
        return this.metalloid;
    }

    public boolean getMetalloid() {
        return this.metalloid;
    }

    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }

    public double getLeitfaehigkeit() {
        return this.leitfaehigkeit;
    }

    public void setLeitfaehigkeit(double leitfaehigkeit) {
        this.leitfaehigkeit = leitfaehigkeit;
    }

    @Override
    public String toString() {
        return super.toString() + ", o: " + this.getLeitfaehigkeit() + 
            ", Metalloid? " + this.getMetalloid();
    }
}
