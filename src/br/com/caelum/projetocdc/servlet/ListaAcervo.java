package br.com.caelum.projetocdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/listaAcervo")
public class ListaAcervo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JPAUtil jpa = new JPAUtil();
		LivroBDDao dao = new LivroBDDao(jpa.getEntityManager());
		
		List<Livro> lista = dao.getLista();
		
		request.setAttribute("lista", lista);
		
		jpa.fechaConexao();
		
		request.getRequestDispatcher("/listaAcervo.jsp").forward(request, response);
		
		
	}

}
