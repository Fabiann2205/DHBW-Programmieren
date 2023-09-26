package de.dhbwka.java.exercise.java8.soccer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Soccer {
    static List<Player> players;

    static int compareByNumber(Player p1, Player p2) {
        return p1.number() - p2.number();
    }

    static int compareByName(Player p1, Player p2) {
        return p1.name().compareTo(p2.name());
    }

    public static void main(String[] args) {
        try {
            players = Files.readAllLines(Path.of("resources/soccer.csv")).stream().map(line -> line.split(";")).map(line -> new Player(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], Integer.parseInt(line[5]), Integer.parseInt(line[6]))).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        players.stream().sorted(Soccer::compareByNumber).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println("Sortiert nach Name, mehr als 50 Games:");
        players.stream().sorted(Soccer::compareByName).filter(a -> (a.games() > 50)).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println("sämtliche clubs:");
        players.stream().map(Player::club).distinct().sorted().forEach(System.out::println);

        System.out.println("--------------------------------------------------");
        System.out.println("weniger als 5 Tore - Anzahl:");
        System.out.println(players.stream().filter(a -> (a.goals() < 5)).count());

        System.out.println("--------------------------------------------------");
        System.out.println("Wie viele tore haben alle spieler des kadars insgesamt erzielt:");
        System.out.println(players.stream().mapToInt(Player::goals).sum());

    }

}
