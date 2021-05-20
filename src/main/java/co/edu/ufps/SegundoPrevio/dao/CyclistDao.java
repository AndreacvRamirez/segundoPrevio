package co.edu.ufps.SegundoPrevio.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import co.edu.ufps.SegundoPrevio.beans.Cyclist;
import co.edu.ufps.SegundoPrevio.utils.Conexion;


public class CyclistDao {

private Conexion conexion;
	
	private static final String INSERT_CICLISTA_SQL = "INSERT INTO cyclist (name, email, birthdate, country, team) VALUES (?, ?, ?, ?, ?);";
	private static final String DELETE_CICLISTA_SQL = "DELETE FROM cyclist WHERE id = ?;";
	private static final String UPDATE_CICLISTA_SQL = "UPDATE cyclist SET name = ?, email = ?, birthdate = ?,  country = ?, team = ? WHERE id = ?;";
	private static final String SELECT_CICLISTA_BY_ID = "SELECT * FROM cyclist WHERE id = ?;";
	private static final String SELECT_ALL_CICLISTA = "SELECT * FROM cyclist;";
	
	public CyclistDao(){
		this.conexion = conexion.getConexion();
	}
	
	
	public void insert(Cyclist cyclist) throws SQLException{
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_CICLISTA_SQL);
			preparedStatement.setString(1, cyclist.getName());
			preparedStatement.setString(2, cyclist.getEmail());
			preparedStatement.setString(3, cyclist.getBirthdate());
			preparedStatement.setString(4, cyclist.getCountry());
			preparedStatement.setString(5, cyclist.getTeam());
			conexion.execute();
		}catch (SQLException e){
			
		}
	}
	
	
	public void delete (int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_CICLISTA_SQL);
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e) {
		}
	}
	
	
	public void update(Cyclist cyclist) throws SQLException{
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_CICLISTA_SQL);
			preparedStatement.setString(1, cyclist.getName());
			preparedStatement.setString(2, cyclist.getEmail());
			preparedStatement.setString(3, cyclist.getBirthdate());
			preparedStatement.setString(4, cyclist.getCountry());
			preparedStatement.setString(5, cyclist.getTeam());
			preparedStatement.setInt(6, cyclist.getId());
			conexion.execute();
		}catch (SQLException e){
		}
	}
	
	
	public List<Cyclist> selectAll(){
		List <Cyclist> ciclistas = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_CICLISTA);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthdate = rs.getString("birthdate");
				String country = rs.getString("country");
				String team = rs.getString("team");
				ciclistas.add(new Cyclist(id, name, email, birthdate, country, team));
			}
		}catch (SQLException e){
		}
		
		return ciclistas;
	}
	
	
	public Cyclist select(int id){
		Cyclist ciclista = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_CICLISTA_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String birthdate = rs.getString("birthdate");
				String country = rs.getString("country");
				String team = rs.getString("team");
				ciclista = new Cyclist(id, name, email, birthdate, country, team);
			}
		}catch (SQLException e){
		}
		
		return ciclista;
	}
	
}
