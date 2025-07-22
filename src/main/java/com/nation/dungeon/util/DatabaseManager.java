package com.nation.dungeon.util;

import java.io.File;
import java.sql.*;

public class DatabaseManager {

    private Connection conn;
    private final String dbPath = "data/database/userData.db";
    private final String url = "jdbc:sqlite:" + dbPath;

    public DatabaseManager() {
        connect();
        createDatabase();
    }

    public void createUser(String username, String password) {

        if(!doesUserExist(username, password) && ((username != null && password != null) && username.length() >= 4 && username.length() <= 10) && (password.length() >= 4 && password.length() <= 10)) {

            String sql = "INSERT INTO Users (level, username, password, strength, currentHP, maxHP, defence, currentMana, maxMana, money) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try(PreparedStatement stmt = conn.prepareStatement(sql)) {

                //default stats
                double defaultLevel = 1;
                double defaultStrength = 1;
                double defaultCurrentHP = 100;
                double defaultMaxHP = 100;
                double defaultDefence = 1;
                double defaultCurrentMana = 100;
                double defaultMaxMana = 100;
                long defaultMoney = 1000;

                stmt.setDouble(1, defaultLevel);
                stmt.setString(2, username);
                stmt.setString(3, password);
                stmt.setDouble(4, defaultStrength);
                stmt.setDouble(5, defaultCurrentHP);
                stmt.setDouble(6, defaultMaxHP);
                stmt.setDouble(7, defaultDefence);
                stmt.setDouble(8, defaultCurrentMana);
                stmt.setDouble(9, defaultMaxMana);
                stmt.setLong(10, defaultMoney);

                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createDatabase() {

        File dbFile = new File(dbPath);
        File fileFolder = dbFile.getParentFile();

        if(!fileFolder.exists()) {
            fileFolder.mkdirs();
        }

        //creates the table if not found
        try(Statement stmt = conn.createStatement()) {
            String sql = """ 
                         CREATE TABLE IF NOT EXISTS Users(
                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                         level INTEGER NOT NULL,
                         username VARCHAR(12) NOT NULL UNIQUE,
                         password VARCHAR(12) NOT NULL,
                         strength DOUBLE NOT NULL,
                         currentHP DOUBLE NOT NULL,
                         maxHP DOUBLE NOT NULL,
                         defence DOUBLE NOT NULL,
                         currentMana DOUBLE NOT NULL,
                         maxMana DOUBLE NOT NULL,
                         money INTEGER NOT NULL
                         );
                         """;
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error when creating table" + e.getMessage());
        }
    }

    //setters
    public void setUserStats(int level, double strength, double currentHP, double maxHP, double defence, double currentMana, double maxMana, long money, String currentUserName) {

        String sql = "UPDATE Users SET level = ?, strength = ?, currentHP = ?, maxHP = ?, defence = ?, currentMana = ?, maxMana = ?, money = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, level);
            stmt.setDouble(2, strength);
            stmt.setDouble(3, currentHP);
            stmt.setDouble(4, maxHP);
            stmt.setDouble(5, defence);
            stmt.setDouble(6, currentMana);
            stmt.setDouble(7, maxMana);
            stmt.setLong(8, money);
            stmt.setString(9, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no user to update: " + e.getMessage());
        }
    }

    public void setUserLevel(int level, String currentUserName) {

        String sql = "UPDATE Users SET level = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, level);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userLevel to update: " + e.getMessage());
        }
    }

    public void setUserStrength(double strength, String currentUserName) {

        String sql = "UPDATE Users SET strength = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, strength);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userStrength to update: " + e.getMessage());
        }
    }

    public void setUserCurrentHP(double currentHP, String currentUserName) {

        String sql = "UPDATE Users SET currentHP = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, currentHP);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userCurrentHP to update: " + e.getMessage());
        }
    }

    public void setUserMaxHP(double maxHP, String currentUserName) {

        String sql = "UPDATE Users SET maxHP = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, maxHP);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userMaxHP to update: " + e.getMessage());
        }
    }

    public void setUserDefence(double defence, String currentUserName) {

        String sql = "UPDATE Users SET defence = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, defence);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userDefence to update: " + e.getMessage());
        }
    }

    public void setUserCurrentMana(double currentMana, String currentUserName) {

        String sql = "UPDATE Users SET currentMana = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, currentMana);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userCurrentMana to update: " + e.getMessage());
        }
    }

    public void setUserMaxMana(double maxMana, String currentUserName) {

        String sql = "UPDATE Users SET maxMana = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, maxMana);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userMaxMana to update: " + e.getMessage());
        }
    }

    public void setUserMoney(long money, String currentUserName) {

        String sql = "UPDATE Users SET money = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, money);
            stmt.setString(2, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userMoney to update: " + e.getMessage());
        }
    }


    //getters
    public int getUserLevel(String currentUserName) {

        String sql = "SELECT level FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, currentUserName);
            ResultSet rs = stmt.executeQuery();
            return rs.getInt("level");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB userLevel: " +  e.getMessage());
        }
        return 0;
    }

    public String getUsername(String currentUsersName) {

        String sql = "SELECT username FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getString("username");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB username: " +  e.getMessage());
        }
        return "NONE";
    }

    public double getUserStrength(String currentUsersName) {

        String sql = "SELECT strength FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getDouble("strength");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB strength: " +  e.getMessage());
        }
        return 0;
    }

    public double getUserCurrentHP(String currentUsersName) {

        String sql = "SELECT currentHP FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getDouble("currentHP");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB currentHP: " +  e.getMessage());
        }
        return 0;
    }

    public double getUserMaxHP(String currentUsersName) {

        String sql = "SELECT maxHP FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getDouble("maxHP");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB maxHP: " +  e.getMessage());
        }
        return 0;
    }

    public double getUserDefence(String currentUsersName) {

        String sql = "SELECT defence FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getDouble("defence");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB defence: " +  e.getMessage());
        }
        return 0;
    }

    public double getUserCurrentMana(String currentUsersName) {

        String sql = "SELECT currentMana FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getDouble("currentMana");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB currentMana: " +  e.getMessage());
        }
        return 0;
    }

    public double getUserMaxMana(String currentUsersName) {

        String sql = "SELECT maxMana FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getDouble("maxMana");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB maxMana: " +  e.getMessage());
        }
        return 0;
    }

    public long getUserMoney(String currentUsersName) {

        String sql = "SELECT money FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getLong("money");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB money: " +  e.getMessage());
        }
        return 0;
    }

    public boolean doesUserExist(String username, String password) {

        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        return rs.next();

        } catch (SQLException e) {
            System.out.println("Error from doesUserExist: " + e.getMessage());
        }
        return false;
    }

    private void connect() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}