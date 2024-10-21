package ro.emanuel.rubikscube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.rubikscube.helper.DBHelper;
import ro.emanuel.rubikscube.pojo.RubiksCube;

public class RubiksCubeDAO {

    public static RubiksCube getRubiksCubeById(int id) throws SQLException {
        String query = "SELECT * FROM rubikscube WHERE id = ?";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String brand = rs.getString("brand");
                    double weight = rs.getDouble("weight");
                    int sides = rs.getInt("sides");
                    return new RubiksCube(id, brand, weight, sides);
                }
            }
        }
        return null;
    }

    public static ArrayList<RubiksCube> getAllRubiksCubes() throws SQLException {
        String query = "SELECT * FROM rubikscube";
        ArrayList<RubiksCube> results = new ArrayList<>();
        try (Connection conn = DBHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                double weight = rs.getDouble("weight");
                int sides = rs.getInt("sides");

                RubiksCube cube = new RubiksCube(id, brand, weight, sides);
                results.add(cube);
            }
        }
        return results;
    }

    public static void createRubiksCube(String brand, double weight, int sides) throws SQLException {
        String query = "INSERT INTO rubikscube (brand, weight, sides) VALUES (?, ?, ?)";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, brand);
            stmt.setDouble(2, weight);
            stmt.setInt(3, sides);
            stmt.executeUpdate();
        }
    }

    public static void updateRubiksCube(int id, String brand, double weight, int sides) throws SQLException {
        String query = "UPDATE rubikscube SET brand = ?, weight = ?, sides = ? WHERE id = ?";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, brand);
            stmt.setDouble(2, weight);
            stmt.setInt(3, sides);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public static void deleteRubiksCube(int id) throws SQLException {
        String query = "DELETE FROM rubikscube WHERE id = ?";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
