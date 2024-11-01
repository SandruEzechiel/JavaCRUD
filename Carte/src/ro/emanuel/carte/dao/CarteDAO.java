package ro.emanuel.carte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.carte.helper.DBHelper;
import ro.emanuel.carte.pojo.Carte;

public class CarteDAO {

    public static void createCarte(String titlu, String autor, double pret) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "INSERT INTO carte (titlu, autor, pret) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, titlu);
        stmt.setString(2, autor);
        stmt.setDouble(3, pret);
        stmt.executeUpdate();
        DBHelper.closeConnection();
    }

    public static Carte getCarteById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM carte WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);

        Carte carte = null;
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String titlu = rs.getString("titlu");
            String autor = rs.getString("autor");
            double pret = rs.getDouble("pret");
            carte = new Carte(id, titlu, autor, pret);
        }

        DBHelper.closeConnection();
        return carte;
    }

    public static ArrayList<Carte> getAllCarti() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM carte";
        Statement stmt = conn.createStatement();
        ArrayList<Carte> results = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String titlu = rs.getString("titlu");
            String autor = rs.getString("autor");
            double pret = rs.getDouble("pret");
            Carte carte = new Carte(id, titlu, autor, pret);
            results.add(carte);
        }
        DBHelper.closeConnection();
        return results;
    }

    public static void updateCarte(int id, String titlu, String autor, double pret) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "UPDATE carte SET titlu = ?, autor = ?, pret = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, titlu);
        stmt.setString(2, autor);
        stmt.setDouble(3, pret);
        stmt.setInt(4, id);
        stmt.executeUpdate();
        DBHelper.closeConnection();
    }

    public static void deleteCarte(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "DELETE FROM carte WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        DBHelper.closeConnection();
    }
}
