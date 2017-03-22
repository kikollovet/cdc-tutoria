package br.com.caelum.projetocdc;

import java.util.Comparator;

public class ComparadorUltimoLancamento implements Comparator<Livro> {

	@Override
	public int compare(Livro livroUm, Livro livroDois) {
		long valor = livroDois.getDataLancamento().getTimeInMillis() - livroUm.getDataLancamento().getTimeInMillis();
		return (int)valor;
	}

}
