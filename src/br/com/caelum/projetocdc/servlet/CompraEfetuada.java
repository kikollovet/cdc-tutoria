package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.CarrinhoDeCompras;

@WebServlet("/compraEfetuada")
public class CompraEfetuada extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		CarrinhoDeCompras carrinho = (CarrinhoDeCompras) req.getSession().getAttribute("carrinho");
		
		carrinho.esvaziar();
		
		req.getRequestDispatcher("/WEB-INF/paginas/compraEfetuada.jsp").forward(req, resp);
	}
}
