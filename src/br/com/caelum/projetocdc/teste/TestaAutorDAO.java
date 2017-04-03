package br.com.caelum.projetocdc.teste;

import java.sql.SQLException;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.dao.AutorDAO;
import br.com.caelum.projetocdc.dao.AutorMemoria;

public class TestaAutorDAO {

	public static void main(String[] args) throws SQLException {
		Autor autor = new Autor("Pedro Albuquerque");
		Autor autor2 = new Autor("Joaquim Torres");
		autor.setId(2);
		
		AutorBDDao dao = new AutorBDDao(); 
		//dao.adiciona(autor);
		//dao.adiciona(autor2);
		
		System.out.println("adicionado");
		//dao.altera(autor);
		
		//System.out.println(dao.getAutor(2));
		
		//dao.remove(9);
	}
}
