package br.com.caelum.projetocdc.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.CarrinhoDeCompras;
import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.GeradoraDeCompra;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.VerificadorDeEstoque;
import br.com.caelum.projetocdc.dao.CompraBDDao;
import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/finalizarCompra")
public class FinalizarCompra extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		CarrinhoDeCompras carrinho = (CarrinhoDeCompras) req.getSession().getAttribute("carrinho");
		
		JPAUtil jpa = new JPAUtil();
		
		EstoqueBDDao dao = new EstoqueBDDao(jpa.getEntityManager());
		
		VerificadorDeEstoque verificador = new VerificadorDeEstoque(dao);
		
		GeradoraDeCompra gerador = new GeradoraDeCompra(verificador);
		
		Compra compra = gerador.novaCompra(usuario, Calendar.getInstance(), carrinho);
		
		CompraBDDao compraDao = new CompraBDDao(jpa.getEntityManager());
		
		jpa.iniciaTransacao();
		compraDao.adiciona(compra);
		jpa.comitaTransacao();
		
		jpa.fechaConexao();
		
		resp.sendRedirect("/cdc-tutoria/compraEfetuada");
	}
}
