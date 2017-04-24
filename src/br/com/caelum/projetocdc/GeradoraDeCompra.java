package br.com.caelum.projetocdc;

import java.util.Calendar;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class GeradoraDeCompra {

	private VerificadorDeEstoque verificador;

	public GeradoraDeCompra(VerificadorDeEstoque verificador) {
		this.verificador = verificador;
	}

	public Compra novaCompra(Usuario usuario, Calendar data, CarrinhoDeCompras carrinho) {
		Compra compra = new Compra(usuario, data);
		
		for(Item item: carrinho.getItens()){
			if(verificador.verificaTemNoEstoque(item)){
				compra.adicionaItens(item);
			}
		}
		return compra;
	}

}
