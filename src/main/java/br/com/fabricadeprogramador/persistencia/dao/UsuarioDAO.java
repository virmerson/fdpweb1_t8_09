package br.com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void salvar(Usuario usuario){
			if (usuario.getId()==0){
				cadastrar(usuario);
			}else{
				alterar(usuario);
			}
	}
	
	public void excluir(Usuario usuario){
		String sql = "delete from usuario where id=? ";
	
	
		try (PreparedStatement stm =  con.prepareStatement(sql)){
			stm.setInt(1, usuario.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Usuario> buscarTodos(){
		//1) SQL
		
			String sql =  "select * from usuario";
			
		//2) Armazenar o Resultado - "ResultSet"
			try (PreparedStatement stm = con.prepareStatement(sql) ){
				
				ResultSet resultSet = stm.executeQuery();
				
				//3) Colocar os Resultados como Objetos na Lista
				List<Usuario> lista = new ArrayList<Usuario>();
				
				while(resultSet.next()){
					
					Usuario usuario =  new Usuario();
					usuario.setId(resultSet.getInt("id"));
					usuario.setNome(resultSet.getString("nome"));
					usuario.setLogin(resultSet.getString("login"));
					usuario.setSenha(resultSet.getString("senha"));
					
					lista.add(usuario);
				}
				
				//4) Retornar a Lista		
				
				return lista;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return null;
	}

	public Usuario buscarPorId(int id) {
	//1) SQL
		String sql =  "select * from usuario where id =?";
	//2) Armazenar o Resultado - "ResultSet"
		try (PreparedStatement stm = con.prepareStatement(sql) ){
			stm.setInt(1, id);
			ResultSet resultSet = stm.executeQuery();
			if(resultSet.next()){
				Usuario usuario =  new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setLogin(resultSet.getString("login"));
				usuario.setSenha(resultSet.getString("senha"));
				return usuario;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return null;
	}

	public Usuario buscarPorLogin(Usuario usuario) {
		
		//1) SQL
				String sql =  "select * from usuario where login =?";
			//2) Armazenar o Resultado - "ResultSet"
				try (PreparedStatement stm = con.prepareStatement(sql) ){
					stm.setString(1, usuario.getLogin());
					ResultSet resultSet = stm.executeQuery();
					if(resultSet.next()){
						Usuario usu =  new Usuario();
						usu.setId(resultSet.getInt("id"));
						usu.setNome(resultSet.getString("nome"));
						usu.setLogin(resultSet.getString("login"));
						usu.setSenha(resultSet.getString("senha"));
						return usu;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return null;
	}

}
