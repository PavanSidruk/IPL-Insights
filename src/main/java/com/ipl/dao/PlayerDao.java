package com.ipl.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ipl.entity.Player;
import com.ipl.utility.HibernateUtil;

import java.util.List;

public class PlayerDao {

    public void addPlayer(Player player) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(player);  // Player object will now contain teamName
            transaction.commit();
        }
    }

    public void updatePlayer(Player player) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(player);  // Make sure the player includes teamName
            transaction.commit();
        }
    }

    public Player getPlayerById(int playerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Player.class, playerId);  // Fetches player with teamName
        }
    }

    public List<Player> getAllPlayers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Player> query = session.createQuery("from Player", Player.class);
            return query.list();  // Retrieves list of players including teamName
        }
    }

    public void deletePlayer(int playerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Player player = session.get(Player.class, playerId);
            if (player != null) {
                session.delete(player);  // Deleting player including teamName
            }
            transaction.commit();
        }
    }

    // Method to get player with the most runs
    public Player getPlayerWithMostRuns() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Player> query = session.createQuery("from Player order by runsScored desc", Player.class);
            query.setMaxResults(1);
            return query.uniqueResult();  // Fetches player with most runs
        }
    }

    // Method to get team with the most runs
    public String getTeamWithMostRuns() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Creating query to calculate total runs by team
            Query<Object[]> query = session.createQuery(
                    "select p.teamName, sum(p.runsScored) from Player p group by p.teamName order by sum(p.runsScored) desc", 
                    Object[].class
            );
            query.setMaxResults(1);
            Object[] result = query.uniqueResult();
            return result != null ? (String) result[0] : null;  // Returns team with most runs
        }
    }

    // Method to get player with most wickets
    public Player getPlayerWithMostWickets() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Player> query = session.createQuery("from Player order by wickets desc", Player.class);
            query.setMaxResults(1);
            return query.uniqueResult();  // Fetches player with most wickets
        }
    }

    // Method to get team with the most wickets
    public String getTeamWithMostWickets() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Creating query to calculate total wickets by team
            Query<Object[]> query = session.createQuery(
                    "select p.teamName, sum(p.wickets) from Player p group by p.teamName order by sum(p.wickets) desc", 
                    Object[].class
            );
            query.setMaxResults(1);
            Object[] result = query.uniqueResult();
            return result != null ? (String) result[0] : null;  // Returns team with most wickets
        }
    }
}
