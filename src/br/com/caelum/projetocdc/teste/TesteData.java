package br.com.caelum.projetocdc.teste;

import java.util.Calendar;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;

public class TesteData {

	public static void main(String[] args) {
		
		Calendar dataUltimaAtualizacao = Calendar.getInstance();
		dataUltimaAtualizacao.set(2017, 03, 01);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.set(2014, 02, 15);
		
		Autor a = new Autor("luis");
		Livro l1 = new Livro("Teste", "teste2", a, Tipo.EBOOK, 30.00, dataUltimaAtualizacao, dataLancamento);
		
		System.out.println(l1.getDataUltimaAtualizacao());
		System.out.println(l1.getDataLancamento());
		System.out.println(l1.getDataUltimaAtualizacaoString());
		System.out.println(l1.getDataLancamentoString());
	}
	
}
