package com.nation.dungeon.util;

import java.io.File;
import java.sql.*;

public class DatabaseManager {

    private Connection conn;
    private final String dbPath = "data/database/userData.db";
    private final String url = "jdbc:sqlite:" + dbPath;

    public DatabaseManager() {
        connect();
    }

    public void createUser(String username, String password) {

        if(!doesUserExist(username) && (username != null && username.length() >= 4 && username.length() <= 12) && (password.length() >= 4 && password.length() <= 12)) {

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

                stmt.setDouble(0, defaultLevel);
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setDouble(3, defaultStrength);
                stmt.setDouble(4, defaultCurrentHP);
                stmt.setDouble(5, defaultMaxHP);
                stmt.setDouble(6, defaultDefence);
                stmt.setDouble(7, defaultCurrentMana);
                stmt.setDouble(8, defaultMaxMana);
                stmt.setDouble(9, defaultMoney);

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
                         id INTEGER PRIMARY KEY AUTOINCRIMENT,
                         level INTEGER NOT NULL,
                         username VARCHAR(12) NOT NULL UNIQUE,
                         password VARCHAR(12) NOT NULL,
                         strength DOUBLE NOT NULL,
                         currentHP DOUBLE NOT NULL,
                         maxHP DOUBLE NOT NULL,
                         defence DOUBLE NOT NULL,
                         currentMana DOUBLE NOT NULL,
                         maxMana DOUBLE NOT NULL,
                         money LONG NOT NULL,
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

            stmt.setInt(0, level);
            stmt.setDouble(1, strength);
            stmt.setDouble(2, currentHP);
            stmt.setDouble(3, maxHP);
            stmt.setDouble(4, defence);
            stmt.setDouble(5, currentMana);
            stmt.setDouble(6, maxMana);
            stmt.setLong(7, money);
            stmt.setString(8, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no user to update: " + e.getMessage());
        }
    }

    public void setUserLevel(int level, String currentUserName) {

        String sql = "UPDATE Users SET level = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(0, level);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userLevel to update: " + e.getMessage());
        }
    }

    public void setUserStrength(double strength, String currentUserName) {

        String sql = "UPDATE Users SET strength = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(0, strength);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userStrength to update: " + e.getMessage());
        }
    }

    public void setUserCurrentHP(double currentHP, String currentUserName) {

        String sql = "UPDATE Users SET currentHP = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(0, currentHP);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userCurrentHP to update: " + e.getMessage());
        }
    }

    public void setUserMaxHP(double maxHP, String currentUserName) {

        String sql = "UPDATE Users SET maxHP = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(0, maxHP);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userMaxHP to update: " + e.getMessage());
        }
    }

    public void setUserDefence(double defence, String currentUserName) {

        String sql = "UPDATE Users SET defence = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(0, defence);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userDefence to update: " + e.getMessage());
        }
    }

    public void setUserCurrentMana(double currentMana, String currentUserName) {

        String sql = "UPDATE Users SET currentMana = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(0, currentMana);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userCurrentMana to update: " + e.getMessage());
        }
    }

    public void setUserMaxMana(double maxMana, String currentUserName) {

        String sql = "UPDATE Users SET maxMana = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(0, maxMana);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userMaxMana to update: " + e.getMessage());
        }
    }

    public void setUserMoney(long money, String currentUserName) {

        String sql = "UPDATE Users SET money = ? WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(0, money);
            stmt.setString(1, currentUserName);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error, no userMoney to update: " + e.getMessage());
        }
    }


    //getters
    public int getUserLevel(String currentUserName) {

        String sql = "SELECT level FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(0, currentUserName);
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
            stmt.setString(0, currentUsersName);
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
            stmt.setString(0, currentUsersName);
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
            stmt.setString(0, currentUsersName);
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
            stmt.setString(0, currentUsersName);
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
            stmt.setString(0, currentUsersName);
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
            stmt.setString(0, currentUsersName);
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
            stmt.setString(0, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getDouble("maxMana");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB maxMana: " +  e.getMessage());
        }
        return 0;
    }

    public double getUserMoney(String currentUsersName) {

        String sql = "SELECT money FROM Users WHERE username = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(0, currentUsersName);
            ResultSet rs = stmt.executeQuery();
            return rs.getLong("money");
        } catch (SQLException e) {
            System.out.println("Error, couldn't get DB money: " +  e.getMessage());
        }
        return 0;
    }

    private boolean doesUserExist(String username) {

        String sql = "SELECT username FROM Users";

        try(Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String dbName = rs.getString("username");

                if(dbName.equals(username)) {
                    return true;
                }
            }

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