package br.com.caelum.projetocdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.dao.LivrosSemRegistroNoEstoqueBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/cadastroItemNoEstoque")
public class CadastroItemNoEstoque extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JPAUtil jpa = new JPAUtil();
		
		LivrosSemRegistroNoEstoqueBDDao dao = new LivrosSemRegistroNoEstoqueBDDao(jpa.getEntityManager());
		
		List<Livro> lista = dao.getLista();
		
		req.setAttribute("lista", lista);
		
		req.getRequestDispatcher("/WEB-INF/paginas/cadastroItemNoEstoque.jsp").forward(req, resp);
	}
}
