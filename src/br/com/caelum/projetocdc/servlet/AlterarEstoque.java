package br.com.caelum.projetocdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/alterarEstoque")
public class AlterarEstoque extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JPAUtil jpa = new JPAUtil();
		
		EstoqueBDDao estoqueDao = new EstoqueBDDao(jpa.getEntityManager());
		
		List<ItemNoEstoque> lista = estoqueDao.getLista();
		
		req.setAttribute("lista", lista);
		
		req.getRequestDispatcher("/WEB-INF/paginas/alterarEstoque.jsp").forward(req, resp);
	}
}
