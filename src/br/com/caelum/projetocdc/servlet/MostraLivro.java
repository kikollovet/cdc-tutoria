package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/mostraLivro")
public class MostraLivro extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JPAUtil jpa = new JPAUtil();
		LivroBDDao dao = new LivroBDDao(jpa.getEntityManager());
		
		int idLivro = Integer.parseInt(request.getParameter("id"));
		
		Livro livro = dao.getLivro(idLivro);
		
		request.setAttribute("livro", livro);
		
		jpa.fechaConexao();
		
		request.getRequestDispatcher("/livro.jsp").forward(request, response);
	}
}
