package br.com.caelum.projetocdc;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class VerificadorDeEstoqueMock extends VerificadorDeEstoque {

	private int quantidade;
	
	public VerificadorDeEstoqueMock(EstoqueBDDao estoqueBDdao, int quantidade) {
		super(estoqueBDdao);
		this.quantidade = quantidade;
	}

	@Override
	public boolean verificaTemNoEstoque(Item item){
		if(item.getLivro().getTipo().equals(Tipo.EBOOK)){
			return true;
		} else if(item.getQuantidade() <= this.quantidade){
			return true;
		}else if(item.getQuantidade() > this.quantidade){
			throw new QuantidadeInsuficienteNoEstoqueException();
		}
		return true;
	}
}
