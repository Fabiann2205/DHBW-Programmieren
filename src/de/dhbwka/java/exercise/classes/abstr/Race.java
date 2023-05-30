package de.dhbwka.java.exercise.classes.abstr;

public class Race {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Bicycle(20.0d);
        vehicles[1] = new Car(150.0d);
        vehicles[2] = new RacingCar(200.0d);
        vehicles[3] = new Ambulance(80.0d);

        // 4 hours lead for the bike
        vehicles[0].drive(240.0);
        // 1 hour of driving for everyone
        for (int i = 0; i < vehicles.length; i++) { 
            vehicles[i].drive(60);
        }
      // Output Race
        for (int i = 0; i < vehicles.length; i++) { 
            System.out.println(vehicles[i].toString());
        }

        System.out.println(vehicles[0].hashCode());
        System.out.println(vehicles[1].hashCode());
        System.out.println(vehicles[2].hashCode());
        System.out.println(vehicles[3].hashCode());
        System.out.println(vehicles[0].equals(vehicles[0]));
        
    }
}
