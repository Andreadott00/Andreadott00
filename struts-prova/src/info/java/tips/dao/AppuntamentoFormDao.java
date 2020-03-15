package info.java.tips.dao;

import static info.java.tips.database.JdbcConnection.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import info.java.tips.database.Eccezione;


public class AppuntamentoFormDao {
	public static void creaAppuntamento(String ora, String data, String descrizione) throws Eccezione {
		System.out.println("jdbc connection");
		String sql = "INSERT INTO FROM struts.appuntamenti (ora, data, descrizione)" + "VALUES (?,?,?)";
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
			ps.setString(1, ora);
			ps.setString(2, data);
			ps.setString(3, descrizione);
			ps.executeUpdate();
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
	}

	public static void eliminaAppuntamento(Long id) throws Eccezione {
		System.out.println("jdbc connection");
		String sql = "DELETE FROM struts.appuntamenti WHERE id = ?";
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
			ps.setLong(1, id);
			ps.executeUpdate();
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
	}
	public static void modificaAppuntamento(String ora, String data, String descrizione)throws Eccezione{
		String sql = "UPDATE struts.appuntamenti SET "
				+ "ora = ?, data = ?, descrizione = ?"
				+ "WHERE id = ?";
		Connection conn = getConnection();
		PreparedStatement ps;
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
			ps.setString(1, ora);
			ps.setString(2, data);
			ps.setString(3, descrizione);
			ps.executeUpdate();
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
	}
}
