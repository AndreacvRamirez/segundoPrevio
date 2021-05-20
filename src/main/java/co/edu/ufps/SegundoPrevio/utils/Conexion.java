package co.edu.ufps.SegundoPrevio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexion {
	
	private Connection con = null;
	private static Conexion db;
	private PreparedStatement preparedStatement;
	
	private static final String url= "jdbc:postgresql://queenie.db.elephantsql.com:5432/";
	private static final String dbName = "mnjgxshj";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	
	public Conexion(){
	
	try {
		Class.forName(driver).newInstance();
		con = (Connection)DriverManager.getConnection(url+dbName, userName, password);
	}catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e){
			e.printStackTrace();
	}catch (Exception e){
				e.printStackTrace();
			}
		}


	public void cerrarConexion() {
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//
	public static Conexion getConexion() {
		if(db == null) {
			db = new Conexion();
		}
		return db;
	}
	
	
	//Retorna el resultado de una consulta
	public ResultSet query() throws SQLException{
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	//Actualizaciones y ejecucción 
	public int execute() throws SQLException{
		int result = preparedStatement.executeUpdate();
		return result;
	}
	
	//Obtiene el objeto conexión
	public Connection getCon() {
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement (String sql) throws SQLException{
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
	
}
