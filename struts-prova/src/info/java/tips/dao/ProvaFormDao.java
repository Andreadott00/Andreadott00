package info.java.tips.dao;

import static info.java.tips.database.JdbcConnection.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import info.java.tips.database.Eccezione;

public class ProvaFormDao {
	public static boolean login(String password, String username) throws Eccezione {
		boolean b = false;
		System.out.println("jdbc connection");
		String sql = "SELECT * FROM struts.utenti WHERE password = ? AND username = ?";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				throw new Eccezione(e1.getMessage());
			}
			throw new Eccezione(e.getMessage());
		}
		try {
			ps.setString(1, password);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			throw new Eccezione(e.getMessage());
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				throw new Eccezione(e.getMessage());
			}
		}

		return b;
	}
	public static boolean registrazione(String username, String password, String nome
								, String cognome, String email, String telefono) throws Eccezione{
		boolean b = false;
		System.out.println("jdbc connection");
		String sql = "INSERT INTO struts.utenti"
				+ "(username, password, nome, cognome, email, telefono)"
				+ "VALUES (?,?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				throw new Eccezione(e1.getMessage());
			}
			throw new Eccezione(e.getMessage());
		}
		try {
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,nome);
			ps.setString(4,cognome);
			ps.setString(5,email);
			ps.setString(6,telefono);
		    ps.executeUpdate();
			b = true;
		} catch (SQLException e) {
			throw new Eccezione(e.getMessage());
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				throw new Eccezione(e.getMessage());
			}
		}
		return b;
	}
}
