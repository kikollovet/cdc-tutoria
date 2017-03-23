package br.com.caelum.projetocdc;

import java.util.Comparator;

public class ComparadorUltimaAtualizacao implements Comparator<Livro> {

	@Override
	public int compare(Livro livroUm, Livro livroDois) {
		long valor = livroDois.getDataUltimaAtualizacao().getTimeInMillis() - livroUm.getDataUltimaAtualizacao().getTimeInMillis();
		return (int) valor;
	}

}
