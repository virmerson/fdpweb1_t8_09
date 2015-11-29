package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.dao.UsuarioDAO;

@WebServlet(urlPatterns={"/usucontroller"})
public class UsuarioController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1) Pegando da Tela
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//2) Criando Objeto Usuario e populando com os dados da tela
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		//3) Criando um UsuarioDAO para salvar o usuario
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		//4) Invocar o Método cadastrar
		usuarioDAO.cadastrar(usuario);
		
		//5) Respondendo mensagem na tela
		resp.getWriter().print("Salvo com Sucesso!");
		
		
	}
}
