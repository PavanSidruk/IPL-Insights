package com.ipl.controller;

import java.util.Scanner;

import com.ipl.entity.Player;
import com.ipl.service.PlayerService;

public class PlayerController {
    public static void main(String[] args) {
        PlayerService playerService = new PlayerService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Cricket Player Management ---");
            System.out.println("1. Add Player");
            System.out.println("2. Update Player");
            System.out.println("3. View Player by ID");
            System.out.println("4. View All Players");
            System.out.println("5. Delete Player");
            System.out.println("6. View Player with Most Wickets");
            System.out.println("7. View Team with Most Wickets");
            System.out.println("8. View Player with Most Runs"); // New option for Most Runs
            System.out.println("9. View Team with Most Runs");  // New option for Most Runs
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    Player player = new Player();
                    System.out.print("Enter Player ID: ");
                    player.setPlayerId(scanner.nextInt());
                    System.out.print("Enter Name: ");
                    player.setName(scanner.next());
                    System.out.print("Enter Matches Played: ");
                    player.setMatchesPlayed(scanner.nextInt());
                    System.out.print("Enter Runs Scored: ");
                    player.setRunsScored(scanner.nextInt());
                    System.out.print("Enter Team Name: ");
                    player.setTeamName(scanner.next());
                    System.out.print("Enter Wickets: ");
                    player.setWickets(scanner.nextInt());
                    playerService.addPlayer(player);
                    System.out.println("Player added successfully!");
                    break;
                }
                case 2: {
                    System.out.print("Enter Player ID to update: ");
                    int playerId = scanner.nextInt();
                    Player player = playerService.getPlayerById(playerId);
                    if (player != null) {
                        System.out.print("Enter Updated Name: ");
                        player.setName(scanner.next());
                        System.out.print("Enter Updated Matches Played: ");
                        player.setMatchesPlayed(scanner.nextInt());
                        System.out.print("Enter Updated Runs Scored: ");
                        player.setRunsScored(scanner.nextInt());
                        System.out.print("Enter Updated Team Name: ");
                        player.setTeamName(scanner.next());
                        System.out.print("Enter Updated Wickets: ");
                        player.setWickets(scanner.nextInt());
                        playerService.updatePlayer(player);
                        System.out.println("Player updated successfully!");
                    } else {
                        System.out.println("Player not found!");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter Player ID to view: ");
                    int playerId = scanner.nextInt();
                    Player player = playerService.getPlayerById(playerId);
                    System.out.println(player != null ? player : "Player not found!");
                    break;
                }
                case 4: {
                    System.out.println("--- All Players ---");
                    playerService.getAllPlayers().forEach(System.out::println);
                    break;
                }
                case 5: {
                    System.out.print("Enter Player ID to delete: ");
                    int playerId = scanner.nextInt();
                    playerService.deletePlayer(playerId);
                    System.out.println("Player deleted successfully!");
                    break;
                }
                case 6: {
                    Player topPlayer = playerService.getPlayerWithMostWickets();
                    System.out.println("Player with most wickets: " + (topPlayer != null ? topPlayer : "No player found!"));
                    break;
                }
                case 7: {
                    String topTeam = playerService.getTeamWithMostWickets();
                    System.out.println("Team with most wickets: " + (topTeam != null ? topTeam : "No team found!"));
                    break;
                }
                case 8: {
                    Player topPlayer = playerService.getPlayerWithMostRuns();
                    System.out.println("Player with most runs: " + (topPlayer != null ? topPlayer : "No player found!"));
                    break;
                }
                case 9: {
                    String topTeam = playerService.getTeamWithMostRuns();
                    System.out.println("Team with most runs: " + (topTeam != null ? topTeam : "No team found!"));
                    break;
                }
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
