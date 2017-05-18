package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Item;

@WebServlet("/visualizarCarrinho")
public class VisualizarCarrinho extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CarrinhoDeCompras carrinho = (CarrinhoDeCompras) req.getSession().getAttribute("carrinho");
		
		double total = carrinho.getValorTotal();
		
		req.setAttribute("total", total);
		
		req.getRequestDispatcher("/WEB-INF/paginas/visualizarCarrinho.jsp").forward(req, resp);
	}
}
