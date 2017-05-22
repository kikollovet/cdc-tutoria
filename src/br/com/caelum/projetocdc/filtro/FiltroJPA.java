package br.com.caelum.projetocdc.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebFilter("/*")
public class FiltroJPA implements Filter {

	@Override
	public void destroy() {
		JPAUtil.fechaFabrica();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		JPAUtil jpa = new JPAUtil();
		
		request.setAttribute("Manager", jpa.getEntityManager());
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
