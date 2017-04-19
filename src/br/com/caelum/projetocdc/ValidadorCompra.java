package br.com.caelum.projetocdc;

import java.sql.Connection;

import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class ValidadorCompra {

	public void validaCompra(Compra compra, ItemNoEstoque itemNoEstoque) {
		for (Item item : compra.getItens()) {
			if(item.getLivro().equals(itemNoEstoque.getLivro())){
				if(item.getLivro().getTipo().equals(Tipo.IMPRESSO)){
					if(itemNoEstoque.getQuantidadeNoEstoque() < item.getQuantidade()){
						throw new QuantidadeInsuficienteNoEstoqueException("N�o tem quantidade suficiente deste livro no estoque, "
								+ "s� temos " + itemNoEstoque.getQuantidadeNoEstoque());
					}
				}
			}
		}
	}
}