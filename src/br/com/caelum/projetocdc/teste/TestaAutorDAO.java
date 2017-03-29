package br.com.caelum.projetocdc.teste;

import java.sql.SQLException;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.dao.AutorBDDao;
import br.com.caelum.projetocdc.dao.AutorMemoria;

public class TestaAutorDAO {

	public static void main(String[] args) throws SQLException {
		Autor autor = new Autor("Alexandre Lourenço");
		Autor autor2 = new Autor("Joaquim Torres");
		
		AutorBDDao dao = new AutorBDDao(); 
		dao.adiciona(autor);
		dao.adiciona(autor2);
		
		
		//dao.altera(autor, 2);
	}
}
