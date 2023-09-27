package de.dhbwka.java.exams.CHORonaProbe;

import java.util.ArrayList;
import java.util.Random;

public class RoomSetting {
    private int width, height;
    private ArrayList<Point> pollutants = new ArrayList<>();

    public RoomSetting(int width, int height, int pollutantsNum) throws AHAException {
        this.width = width;
        this.height = height;
        //this.pollutants = pollutants;
        if ((this.width * this.height) < pollutantsNum) {
            throw new AHAException("Insufficient singers");
        } else {
            Random rng = new Random();
            Point current;
            boolean ja = true;
            this.pollutants.add(new Point(rng.nextInt(this.width), rng.nextInt(this.height)));
            while (this.pollutants.size() < pollutantsNum) {
                ja = true;
                current = new Point(rng.nextInt(this.width), rng.nextInt(this.height));
                for (Point s : this.pollutants) {
                    if (s.equals(current)) {
                        ja = false;
                        break;
                    }
                }
                if (ja) {
                    this.pollutants.add(current);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Point[] getPolluters() {
        return pollutants.toArray(new Point[0]);
    }

    public static void main(String[] args) throws AHAException {
        new RoomSetting(3, 4, 8);
    }
}
