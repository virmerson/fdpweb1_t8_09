package br.com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.entidades.Usuario;

/**
 * DATA ACCESS OBJECT (D.A.O.) Designs Pattern
 * 
 * @author Virmerson
 *
 */
public class UsuarioDAO {

	Connection con = ConnectionFactory.getConnection();
	
	public void cadastrar(Usuario usu) {

		String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usu.getNome());
			stm.setString(2, usu.getLogin());
			stm.setString(3, usu.getSenha());

			stm.execute();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Usuario usu) {

	

		String sql = "update usuario  set nome=? , login=?, senha=? where id=?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usu.getNome());
			stm.setString(2, usu.getLogin());
			stm.setString(3, usu.getSenha());
			stm.setInt(4, usu.getId());

			stm.execute();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
