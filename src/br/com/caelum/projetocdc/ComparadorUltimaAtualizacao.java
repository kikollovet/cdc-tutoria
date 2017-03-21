package br.com.caelum.projetocdc;

import java.util.Comparator;

public class ComparadorUltimaAtualizacao implements Comparator<Livro> {

	@Override
	public int compare(Livro livroUm, Livro livroDois) {
		int valor = (int) livroDois.getDataUltimaAtualizacao().getTimeInMillis() - (int) livroUm.getDataUltimaAtualizacao().getTimeInMillis();
		return valor;
	}

}
