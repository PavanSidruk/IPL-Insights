package com.ipl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "matches_played", nullable = false)
    private int matchesPlayed;

    @Column(name = "run_score", nullable = false)
    private int runsScored;

    @Column(name = "wickets", nullable = false)
    private int wickets;  // New field for wickets

    @Column(name = "team_name", nullable = false, length = 50)
    private String teamName;

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    @Override
    public String toString() {
        return "Player [ID=" + playerId + ", Name=" + name + ", Matches Played=" + matchesPlayed +
                ", Runs Scored=" + runsScored + ", Wickets=" + wickets + ", Team=" + teamName + "]";
    }
}
