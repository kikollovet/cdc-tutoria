package br.com.caelum.projetocdc.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.caelum.projetocdc.Usuario;

@WebFilter("/inicio")
public class FiltroLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario"); 

		if(usuario == null)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		if(usuario != null)
			request.getRequestDispatcher("/WEB-INF/paginas/inicio.jsp").forward(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
