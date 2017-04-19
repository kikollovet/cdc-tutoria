package br.com.caelum.projetocdc.exception;

public class QuantidadeInsuficienteNoEstoqueException extends RuntimeException {

	public QuantidadeInsuficienteNoEstoqueException() {
	}

	public QuantidadeInsuficienteNoEstoqueException(String message) {
		super(message);
	}

}
