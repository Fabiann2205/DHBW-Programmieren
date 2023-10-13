package de.dhbwka.java.exams.CHORonaProbe;

import exam.ownclasses.TextFile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;

public class Chorona {

    // Icon in "binaerform" damit keine Datei eingelesen werden muss :-)
    private final static ImageIcon ICON_500 = new ImageIcon(new byte[]{71, 73, 70, 56, 57, 97, 64, 0, 56, 0, -11, 0, 0, 0, 0, 0, 8, 7, 1, 12, 10, 2, 17, 14, 3, 21, 17, 4, 27, 22, 5, 30, 24, 5, 34, 28, 6, 39, 33, 7, 42, 34, 7, 45, 37, 8, 52, 43, 9, 56, 46, 10, 61, 50, 11, 66, 54, 11, 69, 57, 12, 75, 62, 13, 79, 65, 14, 84, 70, 15, 89, 73, 15, 94, 77, 16, 96, 79, 17, 100, 82, 17, 105, 87, 18, 108, 89, 19, 114, 94, 20, 118, 97, 20, 121, 100, 21, 127, 104, 22, -124, 108, 23, -120, 112, 23, -116, 115, 24, -112, 119, 25, -108, 122, 26, -102, 127, 27, -99, -127, 27, -94, -123, 28, -90, -119, 29, -86, -116, 29, -77, -108, 31, -73, -105, 32, -67, -101, 33, -64, -98, 33, -60, -94, 34, -54, -90, 35, -51, -87, 35, -45, -83, 36, -42, -80, 37, -37, -75, 38, -33, -72, 39, -29, -69, 39, -26, -66, 40, -24, -65, 40, -21, -63, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, -7, 4, 1, 0, 0, 54, 0, 33, -1, 11, 73, 109, 97, 103, 101, 77, 97, 103, 105, 99, 107, 13, 103, 97, 109, 109, 97, 61, 48, 46, 52, 53, 52, 53, 53, 0, 44, 0, 0, 0, 0, 64, 0, 56, 0, 0, 6, -2, 64, -101, 112, 72, 44, 26, -113, 67, 0, 0, -55, 108, 58, -97, 78, -91, 18, 74, -83, 90, -123, -46, -27, 117, -53, 37, 102, -89, -35, 112, -11, 43, 21, -101, -93, 74, 6, -93, 124, 110, 23, -91, 2, -109, 73, -64, 118, -69, -91, 20, -103, -116, 82, -73, -101, -91, 5, 41, 53, 53, 41, 6, 125, 126, 93, 82, 26, 53, 52, -116, 26, -121, -120, 87, 82, 10, 45, 53, 51, -115, 45, 10, -112, -111, 80, 82, 1, 32, -116, 52, -115, 53, 32, 1, -101, -100, 77, 82, 15, 49, -105, -94, -115, 48, 15, -89, -88, 71, 82, 3, 38, -95, -82, -115, 38, 3, -78, -77, 94, 74, 121, -71, -71, 123, -67, -66, 54, 82, 6, 42, -72, -62, 53, 42, -122, 96, -58, -76, 74, 27, -72, -105, 51, -83, 51, 53, 27, -59, -88, -109, 46, -116, -39, -95, -125, -82, 46, 11, -36, -120, -98, 33, -106, 53, 50, 44, -107, 52, 45, 44, 50, -125, 53, 33, -90, -48, -47, -57, 74, -85, 53, 49, 36, 26, 32, 86, 12, 90, 1, 66, 3, -119, 24, -20, 98, -31, 51, 86, -21, -42, 10, 9, 22, 86, 52, 18, 101, 105, -123, 5, 9, 2, 79, -16, 90, 56, 75, -118, -123, 26, 39, 20, 88, 64, 72, -93, -43, -88, 24, 21, 18, -100, -104, 97, -31, -36, 25, 100, 43, 86, 36, 96, -16, -51, -110, -80, 108, 46, 24, 36, -120, 121, -64, -91, -2, 24, 41, 28, 100, 68, 0, -96, 78, 88, -82, 65, 32, 0, 68, -112, -63, -63, 103, 34, 37, 11, 94, -112, 8, 96, -128, -59, -78, -101, 53, 88, 24, 8, 64, -30, -123, 57, -114, 118, 60, -119, -104, 1, 1, 0, -125, 24, 70, -103, -59, 88, 3, 65, -122, -120, 123, 90, 34, 73, 105, -85, 21, -128, 3, 25, 20, -57, -47, 3, 39, -93, 1, -128, -86, 100, -99, -114, 81, 50, -32, 68, 13, 19, -90, 22, -64, 24, -28, -30, -97, 5, 11, 6, 107, -62, 48, 23, -32, -106, 70, -63, -99, -108, 88, -56, 22, -126, 112, -118, 23, 29, 18, -64, 5, 16, 32, 1, -121, 23, 41, 8, 40, 17, 97, -23, 2, 102, 52, 0, 14, 8, -84, 39, 101, 67, 6, 37, 84, 23, 44, -40, -86, 68, -61, 54, 37, -22, 106, -84, -24, 9, 54, -116, -108, 14, -93, 62, 72, 57, -48, 1, 65, 3, 17, 45, 96, -64, 96, 33, -94, 65, 2, 15, -60, 1, 124, -96, -41, 33, -53, -99, 52, 47, -78, 94, 40, -112, -91, 1, -119, -59, -30, 106, -64, 32, -79, 6, -112, 5, -85, 57, 95, 27, -15, 52, -30, 112, 2, 50, 0, 20, -116, 64, 63, 40, -122, 8, 77, 100, 36, 112, -53, 8, 112, -67, -92, -60, 82, 37, 60, -125, 95, 0, 12, 96, 80, 66, 9, 23, 48, 48, -38, 23, 6, -108, 32, -125, 4, -14, 37, -95, 4, 1, 40, -2, -80, 112, 31, 0, 3, 44, 0, 1, 4, 12, 108, -124, 91, 6, 26, -116, 54, 0, 3, 35, 46, -80, 81, 2, 44, -100, -96, 90, 113, 84, 72, 113, -63, 12, 124, 8, 64, -63, 9, 49, -96, 0, 89, 9, 22, -48, 17, 64, 7, 122, 116, 7, -128, 0, 22, -108, -96, 1, 5, 40, -12, 72, 1, 29, 20, -52, -32, 26, -115, 79, 44, -41, 66, 106, 4, -124, 16, -50, 8, 32, 42, 51, 66, 1, 6, 84, 82, 67, 11, 6, 20, 80, -97, 10, -68, -44, 103, 73, 8, 4, 16, -112, 2, 11, -39, 113, -111, 69, 7, -38, 4, 16, -36, 32, 92, 10, -128, -62, 32, 34, 72, 80, -109, 11, 18, -80, 86, 3, 10, 116, -88, -39, -120, 61, 28, -44, -32, -127, 119, -110, 40, -47, -64, 11, 50, 60, 32, 1, 94, 20, -99, 64, 71, 112, 51, -112, 32, 1, 9, -102, -110, 64, -111, 8, 71, -18, 73, -47, -123, 15, -56, -16, -126, 95, 84, 74, 67, 26, 9, 53, -68, -64, 64, 9, -72, -76, -86, -55, -92, -115, 88, 26, 64, 0, 2, 24, 86, 18, -122, 9, 124, 35, 74, 54, 37, 48, 16, 30, 9, 116, -92, -6, -122, 18, -109, -42, -32, 2, 4, -66, -26, -126, 1, -120, -80, -54, -86, -124, 2, -31, 29, -58, 11, 6, -52, -76, -64, 44, 59, 24, 26, -85, 33, 0, 28, 90, -30, -62, 72, 38, 53, -94, 66, 79, -2, 10, 40, 19, -23, 62, -13, -88, -96, -55, 1, -54, 8, 19, -125, 5, 46, 52, -126, -62, -116, 113, -63, -122, 65, 43, 49, 112, 0, 67, -71, -115, 124, 96, 74, 2, 93, 41, -12, -128, 84, -9, 5, -80, -99, 81, 48, 112, -128, -48, 53, -49, 122, 43, 5, -116, -95, -52, 16, -62, 59, -62, -56, -80, 1, 29, 2, 124, 0, -96, 2, 31, 112, -68, 1, -91, -82, 100, -45, -126, -106, 37, -115, -7, 97, -66, -86, 6, -32, 65, -84, 44, -8, 90, 46, 59, 33, 28, 96, 64, 7, -59, 10, -48, -127, 1, 7, -96, 12, 112, -85, 86, -75, -94, 104, -127, 76, 72, -15, -88, 77, 41, 51, 114, 21, 69, 44, -108, -48, 45, -78, 37, 88, -107, 86, 94, -40, -76, -118, 42, -53, -65, 28, -55, -86, 81, 51, -72, 48, 79, 73, 96, -113, 18, 66, -79, 74, 8, -64, 90, 46, 38, -55, -32, 2, -64, -115, -108, 64, 54, 18, 82, -48, -118, -107, 9, 34, -52, -93, -12, 32, 50, -80, 73, 70, -106, 118, -113, -62, -114, 8, 38, 112, 77, -61, -123, -101, 0, -78, 103, 53, -82, -56, 48, -126, -125, 94, -85, 109, -62, -109, -53, 101, 23, 0, 5, 38, 52, -18, 66, 9, 24, -44, 61, -11, -96, -28, 113, 36, 69, 6, 108, -1, 106, -55, 9, 18, 44, -48, 64, 3, 8, -64, 53, 0, 5, 42, -84, 64, -127, -119, 2, 36, 112, -6, 112, 2, 18, -100, 48, -47, -26, -73, 45, 52, -15, 59, -21, -36, 46, 78, 12, 16, 50, 96, -13, 1, 14, 104, 112, -62, -41, 50, -96, -112, 1, -22, 60, 47, 96, -127, 9, -13, 100, 115, -119, 56, -82, -88, 92, -121, 39, -96, -20, -91, -3, -10, -20, -72, -32, 2, -92, -36, -77, -13, -62, -9, 118, -121, -49, 125, 41, 108, 72, 65, -128, 6, 29, -76, -17, -2, -5, -16, -57, 47, -1, -4, -12, -53, -81, 1, -66, -6, -32, -89, -1, -2, -4, -9, -17, -1, -1, 0, 12, -96, 0, -5, -105, -65, 1, 26, -16, -128, 95, -80, 65, 16, 0, 0, 59});

    public static void main(String[] args) {
        try {
            Map<Variant, Double> pollutants = Chorona.getPollutantFactors();
            Random rng = new Random();
            // Diese drei Werte sind im Verlauf der Aufgabe zufaellig zu setzen
            int width = rng.nextInt(7, 10);
            int height = rng.nextInt(7, 10);
            int noOfPolluters = rng.nextInt(5, 8);

            RoomSetting setting = new RoomSetting(width, height, noOfPolluters);
            for (Entry<Variant, Double> e : pollutants.entrySet()) {
                new ChoronaTerminal(e.getKey(), new Room(e.getValue(), setting));
            }
        } catch (Exception ignored) {
        }
    }


    public static Map<Variant, Double> getPollutantFactors() {
        Map<Variant, Double> map = new HashMap<>();

        // Diese beiden TEST (!) Zeilen auskommentieren und das Einlesen der Datei
        // "/de/dhbwka/java/exams/CHORonaProbe/pollutantfactors.txt" ergaenzen
        /*Chorona.parsePolluteFactor("DELTA,50", map);
        Chorona.parsePolluteFactor("OMICRON,200", map);
        Chorona.parsePolluteFactor("DELTA,250", map);
        Chorona.parsePolluteFactor("FETA,500", map);
        Chorona.parsePolluteFactor("LAMBDA,2", map);
        Chorona.parsePolluteFactor("ALPHA,100", map);
        Chorona.parsePolluteFactor("BETA,150", map);*/

        TextFile file = new TextFile("resources/pollutantfactors.txt");
        List<String> datei;
        try {
            datei = file.getAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String s : datei) {
            Chorona.parsePolluteFactor(s, map);
        }

        // Wenn nach dem Einlesen der Datei mehr als zwei Eintraege in der Map
        // sind werden zwecks Uebersicht zufaellig so lange Eintraege entfernt,
        // bis nur noch zwei uebrig sind (daher auch weiterhin nur zwei Fenster)!
        if (map.size() > 2) {
            List<Variant> keys = new LinkedList<>(map.keySet());
            Collections.shuffle(keys);
            while (map.size() > 2) {
                map.remove(keys.remove(0));
            }
        }

        return map;
    }

    public static void parsePolluteFactor(String line, Map<Variant, Double> map) {
        String[] parts = line.split(",");
        if (parts.length >= 2) {
            map.put(Variant.valueOf(parts[0]), Double.parseDouble(parts[1]));
        }
    }

    /*public static Color getColorForDose(double dose) {
        final int limit1 = 200;
        final int limit2 = 500;
        int val = Math.max(0, 255 - (int) (255 * (dose / limit1)));
        if (dose < limit1) {
            return new Color(255, val, val);
        }
        if (dose >= limit2) {
            return Color.GREEN; // new Color( 216, 216, 216 );
        }
        return new Color(160, 32, 240);
    }*/

    public static void updateButtonForDose(JButton btn, double dose) {
        final int limit1 = 200;
        final int limit2 = 500;
        int val = Math.max(0, 255 - (int) (255 * (dose / limit1)));
        if (dose < limit1) {
            btn.setBackground(new Color(255, val, val));
            btn.setText(String.format("%5.1f ", dose));
        } else if (dose >= limit2) {
            btn.setIcon(Chorona.ICON_500);
            btn.setText("");
        } else {
            btn.setBackground(new Color(160, 32, 240));
            btn.setText(String.format("%d ", (int) dose));
        }
    }
}
