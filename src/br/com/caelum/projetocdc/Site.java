package br.com.caelum.projetocdc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Site {

	private Set<Livro> livros = new HashSet<>();

	public Set<Livro> getLivros() {
		return livros;
	}

	public void inclui(Livro livro) {
		this.livros.add(livro);
	}

	public List<Livro> listaUltimosLancamentos() {
		return this.livros.stream().sorted(new ComparadorUltimoLancamento()).limit(5).collect(Collectors.toList());
	}

	public List<Livro> listaUltimasAtualizacoes() {
		return this.livros.stream().sorted(new ComparadorUltimaAtualizacao()).limit(5).collect(Collectors.toList());
	}

	public List<Livro> listaDestaques() {
		return this.livros.stream().sorted(new ComparadorUltimoLancamento()).limit(3).collect(Collectors.toList());
	}
}
