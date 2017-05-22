package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/inserirItemNoEstoque")
public class InserirItemNoEstoque extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int idLivro = Integer.parseInt(req.getParameter("livro"));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		
		JPAUtil jpa = new JPAUtil();
		
		LivroBDDao livroDao = new LivroBDDao(jpa.getEntityManager());
		Livro livro = livroDao.getLivro(idLivro);
		
		ItemNoEstoque itemNoEstoque = new ItemNoEstoque(livro, quantidade);
		
		EstoqueBDDao estoqueDao = new EstoqueBDDao(jpa.getEntityManager());
		
		jpa.iniciaTransacao();
		estoqueDao.adiciona(itemNoEstoque);
		jpa.comitaTransacao();
		
		jpa.fechaConexao();
		
		resp.sendRedirect("/cdc-tutoria/cadastroItemNoEstoque");
	}
}
