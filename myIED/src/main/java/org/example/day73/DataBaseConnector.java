package org.example.day73;


import java.sql.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class DataBaseConnector {
    /**
     * Connect to a sample database
     */
    public Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:myData.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
        return connection;
    }

    public void selectAllMenu() {
        String sql = "SELECT * FROM Menu";
        try (Connection connection = this.connect();
             Statement stmt  = connection.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("MenuItemID") + "\t" +
                        rs.getString("ItemName") + "\t" +
                        rs.getDouble("Price")  + "\t" +
                        rs.getDouble("Category"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing SELECT statement");
            e.printStackTrace();
        }
    }
}

