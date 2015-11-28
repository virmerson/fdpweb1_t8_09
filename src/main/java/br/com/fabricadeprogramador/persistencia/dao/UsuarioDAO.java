package br.com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.entidades.Usuario;
/**
 * DATA ACCESS OBJECT (D.A.O.) Design Pattern
 * @author Virmerson
 *
 */
public class UsuarioDAO {

	public void cadastrar(Usuario usu) {
		
		String url = "jdbc:postgresql://localhost:5432/fabricawebdb";
		String usuario = "postgres";
		String senha= "postgres";
	
		try {
			Connection con = DriverManager.getConnection(url,usuario,senha );
		
			String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usu.getNome());
			stm.setString(2,usu.getLogin());
			stm.setString(3, usu.getSenha());
			
			stm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void alterar(Usuario usu) {
		String url = "jdbc:postgresql://localhost:5432/fabricawebdb";
		String usuario = "postgres";
		String senha= "postgres";
	
		try {
			Connection con = DriverManager.getConnection(url,usuario,senha );
		
			String sql = "update usuario  set nome=? , login=?, senha=? where id=?";
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usu.getNome());
			stm.setString(2,usu.getLogin());
			stm.setString(3, usu.getSenha());
			stm.setInt(4, usu.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
