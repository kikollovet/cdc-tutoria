package br.com.caelum.projetocdc.teste;

import java.sql.SQLException;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.dao.AutorDAO;
import br.com.caelum.projetocdc.dao.AutorMemoria;

public class TestaAutorDAO {

	public static void main(String[] args) throws SQLException {
		Autor autor = new Autor("Alexandre Lourenço");
		Autor autor2 = new Autor("Joaquim Torres");
		
		AutorDAO dao = new AutorBDDao(); 
		dao.adiciona(autor);
		dao.adiciona(autor2);
		
		System.out.println("adicionado");
		//dao.altera(autor, 2);
	}
}
