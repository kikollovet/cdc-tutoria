package br.com.caelum.projetocdc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Site {

	Set<Livro> livros = new HashSet<>();

	public Set<Livro> getLivros() {
		return livros;
	}

	public void inclui(Livro livro) {
		this.livros.add(livro);
	}

	public void imprimeTodosOsLivros() {
		this.livros.forEach(livro -> {
			System.out.println(livro);
		});
	}

	public void imprimeUltimosLancamentos() {
		List<Livro> livrosLista = new ArrayList<>(this.livros);
		Collections.sort(livrosLista, new ComparadorUltimoLancamento());
		for(int i=0; i < 5; i++){
			System.out.println(livrosLista.get(i).getTitulo() + " " + livrosLista.get(i).getDataLancamentoString());
		}
	}
	
	public void imprimeUltimasAtualizacoes() {
		List<Livro> livrosLista = new ArrayList<>(this.livros);
		Collections.sort(livrosLista, new ComparadorUltimaAtualizacao());
		for(int i=0; i < 5; i++){
			System.out.println(livrosLista.get(i).getTitulo() + " " + livrosLista.get(i).getDataUltimaAtualizacaoString());
		}
	}
	
	public void imprimeDestaques() {
		List<Livro> livrosLista = new ArrayList<>(this.livros);
		Collections.sort(livrosLista, new ComparadorUltimoLancamento());
		for(int i=0; i < 3; i++){
			System.out.println(livrosLista.get(i).getTitulo() + " " + livrosLista.get(i).getDataLancamentoString());
		}
	}
}
