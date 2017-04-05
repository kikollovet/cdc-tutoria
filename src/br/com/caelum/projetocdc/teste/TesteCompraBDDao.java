package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.dao.LivroBDDao;
import br.com.caelum.projetocdc.dao.UsuarioBDDao;

public class TesteCompraBDDao {

	public static void main(String[] args) {
		
		UsuarioBDDao uDao = new UsuarioBDDao();
		Usuario usuario = uDao.getUsuario(1);
		
		LivroBDDao lDao = new LivroBDDao();
		Livro guiaStartup = lDao.getLivro(2);
		Livro descAWeb = lDao.getLivro(3);

	}

}
