package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.autentificador.Autentificador;
import br.com.caelum.projetocdc.jpa.JPAUtil;

public class TesteAutentificador {

	public static void main(String[] args) {

		JPAUtil jpa = new JPAUtil();
		
		Autentificador autentificador = new Autentificador(jpa.getEntityManager());
		
		System.out.println(autentificador.autentifica("Joao Almeida", "joao.almeida@email.com"));
		
		jpa.fechaConexao();
	}

}
