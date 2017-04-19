package br.com.caelum.projetocdc.exception;

public class NaoPodeAdicionarEbookNoEstoqueException extends RuntimeException {

	public NaoPodeAdicionarEbookNoEstoqueException() {
	}

	public NaoPodeAdicionarEbookNoEstoqueException(String message) {
		super(message);
	}

}
