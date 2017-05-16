package br.com.caelum.projetocdc;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class ValidadorLivroDoisTest {

	Autor autor;
	ValidadorLivroDois validador;
	
	@Before
	public void setUp(){
		this.autor = new Autor("Jonas");
		this.validador = new ValidadorLivroDois();
	}
	
	@Test
	public void LivroComTodosOsDado(){
		Livro livro = new Livro("Teste", "Teste", autor, Tipo.IMPRESSO, 49, Calendar.getInstance(), Calendar.getInstance());
		boolean livroNaoEhValido = validador.livroNaoEhValido(livro);
		
		assertEquals(0, validador.getErros().size());
		assertFalse(livroNaoEhValido);
	}
	
	@Test
	public void LivroSemTitulo(){
		Livro livro = new Livro("", "Teste", autor, Tipo.IMPRESSO, 49, Calendar.getInstance(), Calendar.getInstance());
		boolean livroNaoEhValido = validador.livroNaoEhValido(livro);
		
		assertEquals(1, validador.getErros().size());
		assertTrue(validador.getErros().containsKey("erroTitulo"));
		assertTrue(livroNaoEhValido);
	}
	
	@Test
	public void LivroSemSubTitulo(){
		Livro livro = new Livro("Teste", "", autor, Tipo.IMPRESSO, 49, Calendar.getInstance(), Calendar.getInstance());
		boolean livroNaoEhValido = validador.livroNaoEhValido(livro);
		
		assertEquals(1, validador.getErros().size());
		assertTrue(validador.getErros().containsKey("erroSubTitulo"));
		assertTrue(livroNaoEhValido);
	}
	
	@Test
	public void LivroPrecoZero(){
		Livro livro = new Livro("Teste", "Teste", autor, Tipo.IMPRESSO, 0, Calendar.getInstance(), Calendar.getInstance());
		boolean livroNaoEhValido = validador.livroNaoEhValido(livro);
		
		assertEquals(1, validador.getErros().size());
		assertTrue(validador.getErros().containsKey("erroPreco"));
		assertTrue(livroNaoEhValido);
	}
	
	@Test
	public void LivroSemDataUltimaAtualizacao(){
		Livro livro = new Livro("Teste", "Teste", autor, Tipo.IMPRESSO, 49, null, Calendar.getInstance());
		boolean livroNaoEhValido = validador.livroNaoEhValido(livro);
		
		assertEquals(1, validador.getErros().size());
		assertTrue(validador.getErros().containsKey("erroDataUltimaAtualizacao"));
		assertTrue(livroNaoEhValido);
	}
	
	@Test
	public void LivroSemDataLancamento(){
		Livro livro = new Livro("Teste", "Teste", autor, Tipo.IMPRESSO, 49, Calendar.getInstance(), null);
		boolean livroNaoEhValido = validador.livroNaoEhValido(livro);
		
		assertEquals(1, validador.getErros().size());
		assertTrue(validador.getErros().containsKey("erroDataLancamento"));
		assertTrue(livroNaoEhValido);
	}
	
	@Test
	public void LivroContemCincoErros(){
		Livro livro = new Livro("", "", autor, Tipo.IMPRESSO, 0, null, null);
		boolean livroNaoEhValido = validador.livroNaoEhValido(livro);
		
		assertEquals(5, validador.getErros().size());
		assertTrue(validador.getErros().containsKey("erroTitulo"));
		assertTrue(validador.getErros().containsKey("erroSubTitulo"));
		assertTrue(validador.getErros().containsKey("erroPreco"));
		assertTrue(validador.getErros().containsKey("erroDataUltimaAtualizacao"));
		assertTrue(validador.getErros().containsKey("erroDataLancamento"));
		assertTrue(livroNaoEhValido);
	}
}
