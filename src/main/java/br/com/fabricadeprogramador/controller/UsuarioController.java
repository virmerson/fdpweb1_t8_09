package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//2) Criando Objeto Usuario e populando com os dados da tela
		Usuario usuario = new Usuario();
		if(!id.isEmpty()){
			usuario.setId(Integer.parseInt(id));
		}
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		//3) Criando um UsuarioDAO para salvar o usuario
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		//4) Invocar o Método salvar
		usuarioDAO.salvar(usuario);
		
		//5) Respondendo mensagem na tela
		resp.getWriter().print("Salvo com Sucesso!");
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String acao =  req.getParameter("acao");
		if (acao!=null && acao.equals("exc")){
			String id = req.getParameter("id");
			if (!id.isEmpty()){
				
				Usuario usuarioAExcluir = new Usuario();
				usuarioAExcluir.setId(Integer.parseInt(id));
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioDAO.excluir(usuarioAExcluir);
				
				resp.getWriter().print("Excluido com Sucesso!");
			}
		}else  {
			//1) Consulta no banco
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario > lista = usuarioDAO.buscarTodos();
		
			//2) Colocar no Request HTTP a lista
			req.setAttribute("lista", lista);
			
			//3 Encaminhar o Request e Response para o Tela
			RequestDispatcher dispatcher = req.getRequestDispatcher("lista.jsp");
			dispatcher.forward(req, resp);
			
			
			//ou
			//req.getRequestDispatcher("lista.jsp").forward(req, resp);
			
		}
		
	
	}
}
