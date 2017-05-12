package br.com.caelum.projetocdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/formularioCadastroLivro")
public class FormularioCadastroLivro extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JPAUtil jpa = new JPAUtil();
		
		AutorBDDao dao = new AutorBDDao(jpa.getEntityManager());
		
		List<Autor> lista = dao.getLista();
		
		req.setAttribute("lista", lista);
		
		req.getRequestDispatcher("/WEB-INF/paginas/formularioCadastroLivro.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JPAUtil jpa = new JPAUtil();
		
		AutorBDDao dao = new AutorBDDao(jpa.getEntityManager());
		
		List<Autor> lista = dao.getLista();
		
		req.setAttribute("lista", lista);
		
		req.getRequestDispatcher("/WEB-INF/paginas/formularioCadastroLivro.jsp").forward(req, resp);
	
	}
}
