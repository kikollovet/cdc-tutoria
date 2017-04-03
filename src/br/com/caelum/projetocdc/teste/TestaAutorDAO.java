package br.com.caelum.projetocdc.teste;

import java.sql.SQLException;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;

public class TestaAutorDAO {

	public static void main(String[] args) throws SQLException {
		Autor autor = new Autor("Pedro Albuquerque");
		autor.setId(2);
		
		AutorBDDao dao = new AutorBDDao(); 
		//dao.adiciona(autor);
		
		System.out.println("adicionado");
		//dao.altera(autor);
		
		//System.out.println(dao.getAutor(2));
		
		//dao.remove(9);
	}
}
