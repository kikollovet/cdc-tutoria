package br.com.caelum.projetocdc.teste;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;

public class TesteData {

	public static void main(String[] args) {
		
		Autor a = new Autor("luis");
		Livro l1 = new Livro("Teste", "teste2", a, 60.00, 30.00, "22/03/2017", "15/01/2015");
		
		System.out.println(l1.getDataUltimaAtualizacao());
		System.out.println(l1.getDataLancamento());
		System.out.println(l1.getDataUltimaAtualizacaoString());
		System.out.println(l1.getDataLancamentoString());
	}
	
}
