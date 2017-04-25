package br.com.caelum.projetocdc;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class VerificadorDeEstoqueMock extends VerificadorDeEstoque {

	public VerificadorDeEstoqueMock(EstoqueBDDao estoqueBDdao) {
		super(estoqueBDdao);
	}

	@Override
	public boolean verificaTemNoEstoque(Item item){
		if(item.getLivro().getTipo().equals(Tipo.EBOOK)){
			return true;
		}
		if(item.getQuantidade() <= 4){
			return true;
		}
		if(item.getQuantidade() > 4){
			throw new QuantidadeInsuficienteNoEstoqueException();
		}
		return true;
	}
}
