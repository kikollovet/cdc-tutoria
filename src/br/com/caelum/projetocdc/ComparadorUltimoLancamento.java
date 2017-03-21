package br.com.caelum.projetocdc;

import java.util.Comparator;

public class ComparadorUltimoLancamento implements Comparator<Livro> {

	@Override
	public int compare(Livro livroUm, Livro livroDois) {
		int valor = (int) livroDois.getDataLancamento().getTimeInMillis() - (int) livroUm.getDataLancamento().getTimeInMillis();
		return valor;
	}

}
