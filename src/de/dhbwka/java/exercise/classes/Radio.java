package de.dhbwka.java.exercise.classes;

/**
 * Radio-Programm in Java
 * In einem Objekt der Klasse wird ein Radio simuliert.
 * Dabei gibt es mehrere Funktionen, wie die Lautstärke,
 * Frequenz und ob das Radio an oder aus ist.
 * Auch gibt es für jede Funktion mehrere Funktionen,
 * um diesen jeweiligen Status zu toggeln.
 *
 * @author Fabian Specht
 * @version 1.1
 * @since 1.0
 */

public class Radio {
    /**
     * Status des Radios (on/off)
     */
    private boolean on;
    /**
     * Lautstärke des Radios (0-10)
     */
    private int volume;
    /**
     * Frequenz des Radios (85.0-110.0)
     */
    private double frequency;

    /**
     * Konstruktor für Radio
     * Übergabewerte sind folgende:
     *
     * @param on        Status des Radios
     * @param volume    Lautstärke des Radios
     * @param frequency Frequenz des Radios
     */
    public Radio(boolean on, int volume, double frequency) {
        this.setOn(on);
        this.setVolume(volume);
        this.setFrequency(frequency);
    }

    /**
     * Konstruktor, um Radio mit Standardeinstellungen zu erstellen
     * On: true
     * Volume: 5
     * Frequenz: 99.9
     */
    public Radio() {
        this(true, 5, 99.9);
    }

    /**
     * toString Methode gibt Status des Radios als String zurück
     *
     * @return String Status Radio
     */
    @Override
    public String toString() {
        return "{" +
                " on='" + on + "'" +
                ", volume='" + volume + "'" +
                ", frequency='" + frequency + "'" +
                "}";
    }


    //setters und getters

    /**
     * @return Boolean Status (on/off)
     */
    public boolean isOn() {
        return this.on;
    }

    /**
     * @return Boolean Status (on/off)
     */
    public boolean getOn() {
        return this.on;
    }

    /**
     * Setzt Radio auf on oder off
     *
     * @param on Status (on/off)
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    /**
     * @return Integer Volume Radio
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Radio auf gewisse Lautstärke setzen.
     * Wenn Lautstärke nicht zwsichen 0 und 10, dann bleibt Lautstärke wie sie ist
     *
     * @param volume gewünschte Lautstärke
     */
    public void setVolume(int volume) {
        if (volume < 0) {
            this.volume = 0;
        } else this.volume = Math.min(volume, 10);
    }

    /**
     * @return Double Aktuelle Frequenz
     */
    public double getFrequency() {
        return this.frequency;
    }

    /**
     * Frequenz setzen.
     * Wenn Frequenz außerhalb des erlaubten Bereiches, dann setzen auf 99.9
     *
     * @param frequency Gewünschte Frequenz
     */
    public void setFrequency(double frequency) {
        if (frequency >= 85.0 & frequency <= 110.0) {
            this.frequency = frequency;
        } else {
            this.frequency = 99.9;
        }
    }
    //ende setters  und getters

    /**
     * Volume um 1 erhöhen
     */
    public void incVolume() {
        if (this.isOn()) {
            this.setVolume(this.volume + 1);
        }
    }

    /**
     * Volume um eins reduzieren
     */
    public void decVolume() {
        if (this.isOn()) {
            this.setVolume(this.volume - 1);
        }

    }

    /**
     * Radio einschalten
     */
    public void turnOn() {
        this.setOn(true);
    }

    /**
     * Radio ausschalten
     */
    public void turnOff() {
        this.setOn(false);
    }

    /**
     * Hauptprogramm zum Testen des Radios
     *
     * @param args Kommandozeilen-Parameter
     */

    public static void main(String[] args) {
        Radio sony = new Radio(true, 9, 200);
        sony.incVolume();
        sony.incVolume();
        System.out.println(sony);
    }

}
