package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.autentificador.Autentificador;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/autentificar")
public class Autentificar extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");
		
		JPAUtil jpa = new JPAUtil();
		
		Autentificador autentificador = new Autentificador(jpa.getEntityManager());

		Usuario usuario = autentificador.autentifica(nome, senha);
		
		jpa.fechaConexao();
		
		if(usuario != null){
			req.getSession().setAttribute("usuario", usuario);
			
			CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
			req.getSession().setAttribute("carrinho", carrinho);
			
			resp.sendRedirect("/cdc-tutoria/inicio");	
		} else {
			req.setAttribute("erroLogin", "Não foi possível autentificar o usuario");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}
