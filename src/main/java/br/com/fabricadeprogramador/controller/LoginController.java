package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
@WebServlet(urlPatterns="/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		//1 - Pegar os dados da tela
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//2 - Colocar em um objeto do tipo usuário
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		//3 - Busca o usuario no banco de dados
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioEncontrado = usuarioDAO.buscarPorLogin(usuario);
		//4 - Se tiver o usuário compara a senha
		if (usuarioEncontrado.getSenha().equals(usuario.getSenha())){
			
			req.getRequestDispatcher("bemvindo.jsp").forward(req, resp);
		}else {
			
			resp.sendRedirect("login.html");
		}
		//5 - Decide o redirecionamento (Login ou Bem vindo)
		
	}
}
