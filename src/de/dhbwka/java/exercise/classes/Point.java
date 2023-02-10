package de.dhbwka.java.exercise.classes;

import java.lang.Math;

public class Point {
    private int x, y;

    // constructors
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 1;
        this.y = 1;
    }

    // getter und setter

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                " x='" + getX() + "'" +
                ", y='" + getY() + "'" +
                "}";
    }

    // methods
    public double getUrsprung() {
        return Math.sqrt(((this.getX()) + (this.getY())));
    }

    public double getAbstandZuAnderemPunkt(Point punkt) {
        return Math.sqrt(((punkt.getX() - this.getX()) + (punkt.getY() - this.getY())));
    }

    public Point getSpiegelungX() {
        return new Point(this.getX(), (this.getY() * (-1)));
    }

    public Point getSpiegelungY() {
        return new Point(this.getX() * (-1), this.getY());
    }

    public Point getSpiegelungUrsprung() {
        return new Point(this.getX() * (-1), this.getY() * (-1));
    }

    public static void main(String[] args) {
        Point punkt = new Point(3, 3);
        System.out.println(punkt.getSpiegelungX().toString());
        System.out.println(punkt.getSpiegelungY().toString());
        System.out.println(punkt.getSpiegelungUrsprung().toString());
        System.out.println(punkt.getUrsprung());
        System.out.println(punkt.getAbstandZuAnderemPunkt(new Point(5, 5)));
    }

}
