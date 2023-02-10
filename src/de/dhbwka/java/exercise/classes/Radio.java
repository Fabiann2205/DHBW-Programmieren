package de.dhbwka.java.exercise.classes;

public class Radio {
    private boolean on;
    private int volume;
    private double frequency;


    public Radio(boolean on, int volume, double frequency) {
        this.setOn(on);
        this.setVolume(volume);
        this.setFrequency(frequency);
    }

    public Radio () {
        this(true,5,99.9);
    }


    @Override
    public String toString() {
        return "{" +
            " on='" + on + "'" +
            ", volume='" + volume + "'" +
            ", frequency='" + frequency + "'" +
            "}";
    }
    //setters und getters
    public boolean isOn() {
        return this.on;
    }

    public boolean getOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        if (volume<0) {
            this.volume = 0;
        } else if (volume>10) {
            this.volume = 10;
        } else {
            this.volume = volume;
        }
    }

    public double getFrequency() {
        return this.frequency;
    }

    public void setFrequency(double frequency) {
        if ( frequency >= 85.0 & frequency <= 110.0){
            this.frequency = frequency;
        } else {
            this.frequency = 99.9;
        }
    }
    //ende setters  und getters

    public void incVolume() {
        if(this.isOn()) {
            this.setVolume(this.volume+1);
        }
        
    }
    public void decVolume() {
        if (this.isOn()) {
             this.setVolume(this.volume-1);
        }
       
    }

    public void turnOn(){
        this.setOn(true);
    }
    public void turnOff(){
        this.setOn(false);
    }

    public static void main(String[] args) {
        Radio sony = new Radio(true, 9,200);
        sony.incVolume();
        sony.incVolume();
        System.out.println(sony);
    }
    
}
