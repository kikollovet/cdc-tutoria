package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/adicionarCarrinho")
public class AdicionarCarrinho extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idLivro = Integer.parseInt(req.getParameter("id"));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		
		JPAUtil jpa = new JPAUtil();
		LivroBDDao dao = new LivroBDDao(jpa.getEntityManager());
		
		Livro livro = dao.getLivro(idLivro);
		
		Item item = new Item(livro, quantidade);
		
		CarrinhoDeCompras carrinho = (CarrinhoDeCompras) req.getSession().getAttribute("carrinho");
		carrinho.adiciona(item);
		
		req.getSession().setAttribute("carrinho", carrinho);
		
		resp.sendRedirect("/cdc-tutoria/itemAdicionadoNoCarrinho");
	}
}
