package br.com.caelum.projetocdc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Site {

	Set<Livro> destaques = new HashSet<>();
	Set<Livro> ultimosLancamentos = new HashSet<>();
	Set<Livro> ultimosAtualizados = new HashSet<>();
	Set<Livro> todosOsLivros = new HashSet<>();

	public Set<Livro> getDestaques() {
		return destaques;
	}

	public Set<Livro> getUltimosLancamentos() {
		return ultimosLancamentos;
	}

	public Set<Livro> getUltimosAtualizados() {
		return ultimosAtualizados;
	}

	public Set<Livro> getTodosOsLivros() {
		return todosOsLivros;
	}

	public void adicionaDestaques(Livro livro) {
		this.destaques.add(livro);
	}
	
	public void adicionaUltimosLancamentos(Livro livro) {
		this.ultimosLancamentos.add(livro);
	}
	
	public void adicionaUltimosAtualizados(Livro livro) {
		this.ultimosAtualizados.add(livro);
	}
	
	public void adicionaTodosOsLivros(Livro livro) {
		this.todosOsLivros.add(livro);
	}
	
	public void inclui(Livro livro){
		if(livro.getCategoria() instanceof Destaques)
			adicionaDestaques(livro);
		if(livro.getCategoria() instanceof UltimosLancamentos)
			adicionaUltimosLancamentos(livro);
		if(livro.getCategoria() instanceof UltimosAtualizados)
			adicionaUltimosAtualizados(livro);
		if(livro.getCategoria() instanceof AcervoNormal)
			adicionaTodosOsLivros(livro);
		adicionaTodosOsLivros(livro);
	}

	public void imprimeDestaques() {
		this.destaques.forEach(livro -> {
			System.out.println(livro);
		});
	}
	
	public void imprimeUltimosLancamentos() {
		this.ultimosLancamentos.forEach(livro -> {
			System.out.println(livro);
		});
	}
	
	public void imprimeUltimosAtualizados() {
		this.ultimosAtualizados.forEach(livro -> {
			System.out.println(livro);
		});
	}
	
	public void imprimeAcervoInteiro() {
		System.out.println("Livros em destaque\n=========\n");
		
		this.destaques.forEach(livro -> {
			System.out.println(livro);
		});
		
		System.out.println("Últimos lançamentos\n=========\n");
		
		this.ultimosLancamentos.forEach(livro -> {
			System.out.println(livro);
		});
		
		System.out.println("Últimos livros atualizados\n=========\n");
		
		this.ultimosAtualizados.forEach(livro -> {
			System.out.println(livro);
		});
		
		System.out.println("Todos os livros do acervo\n===========\n");
		
		this.todosOsLivros.forEach(livro -> {
			System.out.println(livro);
		});
	}
}
