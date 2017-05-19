package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/aumentaQuantidade")
public class AumentaQuantidade extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idItemNoEstoque = Integer.parseInt(req.getParameter("id"));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		
		JPAUtil jpa = new JPAUtil();
		
		EstoqueBDDao dao = new EstoqueBDDao(jpa.getEntityManager());
		
		ItemNoEstoque itemNoEstoque = dao.getItemNoEstoque(idItemNoEstoque);
		
		jpa.iniciaTransacao();
		dao.aumentaQuantidade(itemNoEstoque, quantidade);
		jpa.comitaTransacao();
		
		jpa.fechaConexao();
		
		resp.sendRedirect("/cdc-tutoria/alterarEstoque");
	}
}
