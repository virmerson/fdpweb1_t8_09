package br.com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con;
	public static Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/fabricawebdb";
		String usuario = "postgres";
		String senha = "postgres";

		try {
			//Singleton
			if (con==null){
				//cria um novo
				con =  DriverManager.getConnection(url, usuario, senha);
			}
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
