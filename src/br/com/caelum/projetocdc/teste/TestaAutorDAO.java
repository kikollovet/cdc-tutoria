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
		
		AutorDAO dao = new AutorMemoria(); 
		dao.adiciona(autor);
		dao.adiciona(autor2);
		
		System.out.println("adicionado");
		dao.alteraNome("Pedro Albuquerque", 2);
		
		System.out.println(autor.getId());
		System.out.println(autor2.getId());
		System.out.println(autor2);
	}
}
