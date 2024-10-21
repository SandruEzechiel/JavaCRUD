package ro.emanuel.cantina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.cantina.helper.DBHelper;
import ro.emanuel.cantina.pojo.Meniu;

public class MeniuDAO {

	public static Meniu getMeniuById(int id) throws SQLException {
		Connection conn =DBHelper.getConnection();
		String query = "SELECT * FROM meniu WHERE id = ?";
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setInt(1, id);
		
		Meniu m=null;
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			String fel1=rs.getString("fel1");
			String fel2=rs.getString("fel2");
			String desert = rs.getString("desert");
			int pret=rs.getInt("pret");
			m=new Meniu(id,fel1,fel2,desert,pret);
		}
		
		DBHelper.closeConnection();
		return m;
	}
	
	public static ArrayList<Meniu> getAllMeniu() throws SQLException{
		Connection conn =DBHelper.getConnection();
		
		String query="select * from meniu";
		Statement stmt=conn.createStatement();
		ArrayList<Meniu> results = new ArrayList<Meniu>();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			int id = rs.getInt("id");
			String fel1=rs.getString("fel1");
			String fel2=rs.getString("fel2");
			String desert = rs.getString("desert");
			int pret=rs.getInt("pret");
			Meniu m=new Meniu(id,fel1,fel2,desert,pret);
			results.add(m);
		}
		DBHelper.closeConnection();
		return results;
	}
}