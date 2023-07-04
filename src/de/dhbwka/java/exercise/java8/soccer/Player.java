package de.dhbwka.java.exercise.java8.soccer;

public class Player {
    private String birthday,club, position, name;
    private int number, games, goals;

    public Player(int number, String name, String position, String birthday, String club, int games, int goals) {
        this.birthday = birthday;
        this.club = club;
        this.position = position;
        this.name = name;
        this.number = number;
        this.games = games;
        this.goals = goals;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getGames() {
        return games;
    }

    public int getGoals() {
        return goals;
    }

    @Override
    public String toString() {
        return String.format("%d | %s, %s, %s, %s, %d games, %d goals", number, name, position, birthday, club, games, goals);
    }
}
