package de.dhbwka.java.exercise.java8.soccer;

public record Player(int number, String name, String position, String birthday, String club, int games, int goals) {

    @Override
    public String toString() {
        return String.format("%d | %s, %s, %s, %s, %d games, %d goals", number, name, position, birthday, club, games, goals);
    }
}
