package br.com.fabricadeprogramador.autenticacao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter(urlPatterns={"/*"})
public class FiltroAutenticacao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httRequest= ((HttpServletRequest) request ) ;
		// 1 Acessando a Sessao
		HttpSession  session = httRequest.getSession(false);
		
		boolean existeSession = (session!=null);
		
		
		boolean estaTelaLogin=httRequest.getRequestURI().lastIndexOf("/login.html")!=-1 ;
		boolean estaLoginController=httRequest.getRequestURI().lastIndexOf("/login")!=-1 ;;
		
		//2 Verifica se existe sessao associada ao request
		if (existeSession || estaTelaLogin || estaLoginController ){
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("login.html") ;
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
