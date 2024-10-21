package ro.emanuel.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.toy.helper.DBHelper;
import ro.emanuel.toy.pojo.Toy;

public class ToyDAO {

    public static Toy getToyById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM toy WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);

        Toy toy = null;
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            String type = rs.getString("type");
            double price = rs.getDouble("price");
            toy = new Toy(id, name, type, price);
        }

        DBHelper.closeConnection();
        return toy;
    }

    public static ArrayList<Toy> getAllToys() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM toy";
        Statement stmt = conn.createStatement();
        ArrayList<Toy> results = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String type = rs.getString("type");
            double price = rs.getDouble("price");
            Toy toy = new Toy(id, name, type, price);
            results.add(toy);
        }
        DBHelper.closeConnection();
        return results;
    }

    public static void createToy(Toy toy) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "INSERT INTO toy (name, type, price) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, toy.getName());
        stmt.setString(2, toy.getType());
        stmt.setDouble(3, toy.getPrice());
        stmt.executeUpdate();
        DBHelper.closeConnection();
    }

    public static void updateToy(Toy toy) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "UPDATE toy SET name = ?, type = ?, price = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, toy.getName());
        stmt.setString(2, toy.getType());
        stmt.setDouble(3, toy.getPrice());
        stmt.setInt(4, toy.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection();
    }

    public static void deleteToy(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "DELETE FROM toy WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        DBHelper.closeConnection();
    }
}
