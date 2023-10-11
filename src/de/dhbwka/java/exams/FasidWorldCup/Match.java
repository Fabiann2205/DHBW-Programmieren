package de.dhbwka.java.exams.FasidWorldCup;

public class Match {
    private String homeTeam, guestTeam;
    private String date, time, stadium, result;
    private ResultType resultType;

    public Match(String homeTeam, String guestTeam, String date, String time, String stadium, String result) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
        this.result = result;
        this.resultType = ResultType.UNKNOWN;
    }

    @Override
    public String toString() {
        return this.homeTeam + " : " + this.guestTeam;
    }

    public boolean hasResult() {
        return this.result != null;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStadium() {
        return stadium;
    }

    public String getResult() {
        return result;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }
}
