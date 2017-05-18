package br.com.caelum.projetocdc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.dao.CompraBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/visualizarCompras")
public class VisualizarCompras extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JPAUtil jpa = new JPAUtil();
		
		CompraBDDao dao = new CompraBDDao(jpa.getEntityManager());
		
		List<Compra> compras = dao.getLista();
		
		req.setAttribute("compras", compras);
		
		req.getRequestDispatcher("/WEB-INF/paginas/compras.jsp").forward(req, resp);
	
	}
}
