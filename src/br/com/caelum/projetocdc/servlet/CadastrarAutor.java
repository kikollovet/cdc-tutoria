package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/cadastrarAutor")
public class CadastrarAutor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		
		if(nome.isEmpty()){
			req.setAttribute("erroNome", "Campo obrigatório");
			req.getRequestDispatcher("/WEB-INF/paginas/formularioCadastroAutor.jsp").forward(req, resp);
			return;
			
		}
		
		Autor autor = new Autor(nome);
		
		EntityManager manager = (EntityManager) req.getAttribute("Manager");
		
		AutorBDDao dao = new AutorBDDao(manager);
		
		//jpa.iniciaTransacao();
		manager.getTransaction().begin();
		dao.adiciona(autor);
		manager.getTransaction().commit();
		//jpa.comitaTransacao();
		
		req.setAttribute("autor", autor);
		
		resp.sendRedirect("/cdc-tutoria/sucessoCadastroAutor");
	}
}
