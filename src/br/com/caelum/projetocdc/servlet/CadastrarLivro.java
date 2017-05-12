package br.com.caelum.projetocdc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.ValidadorLivro;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.jpa.JPAUtil;

@WebServlet("/cadastrarLivro")
public class CadastrarLivro extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String subTitulo = req.getParameter("subTitulo");
		String idAutorTexto = req.getParameter("autor");
		String dataUltimaAtualizacaoTexto = req.getParameter("dataUltimaAtualizacao");
		String dataLancamentoTexto = req.getParameter("dataLancamento");
		String precoTexto = req.getParameter("preco");
		String tipoTexto = req.getParameter("tipo");
		
		ValidadorLivro validador = new ValidadorLivro();
		if(validador.validaDadosLivro(titulo, subTitulo, precoTexto, dataUltimaAtualizacaoTexto, dataLancamentoTexto, req)){
			req.getRequestDispatcher("/formularioCadastroLivro").forward(req, resp);
			return;
		}
		
		//if(titulo.isEmpty()){
			//req.setAttribute("erroTitulo", "Campo obrigatório");
			//req.getRequestDispatcher("/formularioCadastroLivro").forward(req, resp);
			//return;
		//}
		
		//if(subTitulo.isEmpty()){
			//req.setAttribute("erroSubTitulo", "Campo obrigatório");
			//req.getRequestDispatcher("/formularioCadastroLivro").forward(req, resp);
			//return;
		//}
		
		
		Calendar dataUltimaAtualizacao = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy")
			.parse(dataUltimaAtualizacaoTexto);
			dataUltimaAtualizacao = Calendar.getInstance();
			dataUltimaAtualizacao.setTime(date);
		} catch (ParseException e) {
			//req.setAttribute("erroDataUltimaAtualizacao", "Data em formato dd/MM/aaaa");
			//req.getRequestDispatcher("/formularioCadastroLivro").forward(req, resp);
			//return;
		}
		
		Calendar dataLancamento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy")
			.parse(dataLancamentoTexto);
			dataLancamento = Calendar.getInstance();
			dataLancamento.setTime(date);
		} catch (ParseException e) {
			//req.setAttribute("erroDataLancamento", "Data em formato dd/MM/aaaa");
			//req.getRequestDispatcher("/formularioCadastroLivro").forward(req, resp);
			//return;
		}
		
		double preco = 0;
		
		try {
			preco = Double.parseDouble(precoTexto);
		} catch (NumberFormatException e) {
			//req.setAttribute("erroPreco", "Campo deve ser preenchido com número");
			//req.getRequestDispatcher("/formularioCadastroLivro").forward(req, resp);
			//return;
		}
		
		//if(preco == 0){
			//req.setAttribute("erroPreco", "O preço deve ser diferente de zero");
			//req.getRequestDispatcher("/formularioCadastroLivro").forward(req, resp);
			//return;
		//}
		
		Tipo tipo = Tipo.valueOf(tipoTexto);
		
		int idAutor = Integer.parseInt(idAutorTexto);
		
		JPAUtil jpa = new JPAUtil();
		AutorBDDao dao = new AutorBDDao(jpa.getEntityManager());
		
		Autor autor = dao.getAutor(idAutor);
		
		Livro livro = new Livro(titulo, subTitulo, autor, tipo, preco, dataUltimaAtualizacao, dataLancamento);
		
		LivroBDDao daoLivro = new LivroBDDao(jpa.getEntityManager());
		
		jpa.iniciaTransacao();
		daoLivro.adiciona(livro);
		jpa.comitaTransacao();
		
		jpa.fechaConexao();
		
		resp.sendRedirect("/cdc-tutoria/sucessoCadastroLivro");
	}
}
