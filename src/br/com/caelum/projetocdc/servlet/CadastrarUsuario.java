package br.com.caelum.projetocdc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/cadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		if(nome.isEmpty() && email.isEmpty()){
			request.setAttribute("erroNome", "Campo obrigatório");
			request.setAttribute("erroEmail", "Campo obrigatório");
			request.getRequestDispatcher("/WEB-INF/paginas/formularioCadastroUsuario.jsp").forward(request, response);
			return;
		}
		
		if(nome.isEmpty()){
			request.setAttribute("erroNome", "Campo obrigatório");
			request.getRequestDispatcher("/WEB-INF/paginas/formularioCadastroUsuario.jsp").forward(request, response);
			return;
		}
		
		if(email.isEmpty()){
			request.setAttribute("erroEmail", "Campo obrigatório");
			request.getRequestDispatcher("/WEB-INF/paginas/formularioCadastroUsuario.jsp").forward(request, response);
			return;
		}
		
		JPAUtil jpa = new JPAUtil();
		UsuarioBDDao dao = new UsuarioBDDao(jpa.getEntityManager());
		
		Usuario usuario = new Usuario(nome, email);
		
		jpa.iniciaTransacao();
		dao.adiciona(usuario);
		jpa.comitaTransacao();
		
		jpa.fechaConexao();
		
		request.setAttribute("usuario", usuario);
		
		request.getRequestDispatcher("/WEB-INF/paginas/cadastroUsuarioSucesso.jsp").forward(request, response);
		
	}
}
