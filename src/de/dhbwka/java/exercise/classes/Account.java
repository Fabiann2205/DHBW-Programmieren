package de.dhbwka.java.exercise.classes;

public class Account {
    private int kontonummer;
    private String vorname, nachname;
    private double kontostand, limit;

    // Konstruktoren
    public Account(int kontonummer, String vorname, String nachname, double kontostand, double limit) {
        this.kontonummer = kontonummer;
        this.vorname = vorname;
        this.nachname = nachname;
        this.kontostand = kontostand;
        this.limit = limit;
    }

    public Account() {
    }

    // Setter und Getter

    public int getKontonummer() {
        return this.kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public double getKontostand() {
        return this.kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public double getLimit() {
        return this.limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    // Methoden

    @Override
    public String toString() {
        return "kontonummer='" + getKontonummer() + "', " +
                "vorname='" + getVorname() + "', " +
                "nachname='" + getNachname() + "', " +
                "kontostand='" + getKontostand() + "', " +
                "limit='" + getLimit() + "'\n";
    }

    public String einzahlung(double amount) {
        String meldung;
        if (amount > 0.0d) {
            this.setKontostand(this.getKontostand() + amount);
            meldung = "success";
        } else {
            meldung = "failed";
        }
        return meldung;
    }

    public String auszahlung(double amount) {
        String meldung;

        if (this.kontostand + this.limit >= amount & amount > 0.0d) {
            this.setKontostand(this.getKontostand() - amount);
            meldung = "success";
        } else if (amount <= 0.0d) {
            meldung = "Keine Auszahlung unter oder gleich 0";
        } else {
            meldung = "Deckung nicht ausreichend";
        }
        return meldung;
    }

    // main

    public static void main(String[] args) {
        Account konto = new Account(859467986, "hallo", "NACHnaME", 1000, 1000);
        System.out.println(konto);
        System.out.println(konto.einzahlung(1000));
        System.out.println(konto);
        // 2000
        System.out.println(konto.auszahlung(1500));
        System.out.println(konto);
        // 500
        System.out.println(konto.auszahlung(1000));
        System.out.println(konto);
        // -500
        System.out.println(konto.auszahlung(1500));
        System.out.println(konto);
        // zu wenig

    }

}
