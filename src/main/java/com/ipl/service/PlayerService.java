package com.ipl.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.ipl.dao.PlayerDao;
import com.ipl.entity.Player;

public class PlayerService {
    private final PlayerDao playerDAO = new PlayerDao();

    public void addPlayer(Player player) {
        if (player.getTeamName() == null || player.getTeamName().isEmpty()) {
            System.out.println("Team name cannot be empty");
            return;
        }
        playerDAO.addPlayer(player);
    }

    public void updatePlayer(Player player) {
        if (player.getTeamName() == null || player.getTeamName().isEmpty()) {
            System.out.println("Team name cannot be empty");
            return;
        }
        playerDAO.updatePlayer(player);
    }

    public Player getPlayerById(int playerId) {
        return playerDAO.getPlayerById(playerId);
    }

    public List<Player> getAllPlayers() {
        return playerDAO.getAllPlayers();
    }

    public void deletePlayer(int playerId) {
        playerDAO.deletePlayer(playerId);
    }

    // Method to get player with the most wickets
    public Player getPlayerWithMostWickets() {
        List<Player> players = playerDAO.getAllPlayers();
        Player topPlayer = null;
        int maxWickets = -1;

        for (Player player : players) {
            if (player.getWickets() > maxWickets) {
                maxWickets = player.getWickets();
                topPlayer = player;
            }
        }
        return topPlayer;
    }

    // Method to get team with the most wickets
    public String getTeamWithMostWickets() {
        List<Player> players = playerDAO.getAllPlayers();
        Map<String, Integer> teamWickets = new HashMap<>();

        for (Player player : players) {
            teamWickets.put(player.getTeamName(), teamWickets.getOrDefault(player.getTeamName(), 0) + player.getWickets());
        }

        String topTeam = null;
        int maxWickets = -1;
        for (Map.Entry<String, Integer> entry : teamWickets.entrySet()) {
            if (entry.getValue() > maxWickets) {
                maxWickets = entry.getValue();
                topTeam = entry.getKey();
            }
        }
        return topTeam;
    }

    // Method to get player with the most runs
    public Player getPlayerWithMostRuns() {
        List<Player> players = playerDAO.getAllPlayers();
        Player topPlayer = null;
        int maxRuns = -1;

        for (Player player : players) {
            if (player.getRunsScored() > maxRuns) {
                maxRuns = player.getRunsScored();
                topPlayer = player;
            }
        }
        return topPlayer;
    }

    // Method to get team with the most runs
    public String getTeamWithMostRuns() {
        List<Player> players = playerDAO.getAllPlayers();
        Map<String, Integer> teamRuns = new HashMap<>();

        for (Player player : players) {
            teamRuns.put(player.getTeamName(), teamRuns.getOrDefault(player.getTeamName(), 0) + player.getRunsScored());
        }

        String topTeam = null;
        int maxRuns = -1;
        for (Map.Entry<String, Integer> entry : teamRuns.entrySet()) {
            if (entry.getValue() > maxRuns) {
                maxRuns = entry.getValue();
                topTeam = entry.getKey();
            }
        }
        return topTeam;
    }
}
