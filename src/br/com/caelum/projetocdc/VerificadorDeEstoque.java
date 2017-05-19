package br.com.caelum.projetocdc;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class VerificadorDeEstoque {

	private EstoqueBDDao estoqueBDdao;

	public VerificadorDeEstoque(EstoqueBDDao estoqueBDdao) {
		this.estoqueBDdao = estoqueBDdao;
	}

	public boolean verificaTemNoEstoque(Item item) {
		if (isImpresso(item) && temRegistroNoEstoque(item)) {
			ItemNoEstoque itemNoEstoque = estoqueBDdao.getItemNoEstoqueIdLivro(item.getLivro().getId());
			if (isQuantidadeNaoDisponivel(item, itemNoEstoque)) {
				throw new QuantidadeInsuficienteNoEstoqueException("N�o temos essa quantidade de livros"
						+ " dispon�vel no estoque. Temos " + itemNoEstoque.getQuantidadeNoEstoque());
			}
		}
		return true;
	}

	private boolean isQuantidadeNaoDisponivel(Item item, ItemNoEstoque itemNoEstoque) {
		return itemNoEstoque.getQuantidadeNoEstoque() < item.getQuantidade();
	}

	private boolean temRegistroNoEstoque(Item item) {
		try{
			estoqueBDdao.getItemNoEstoqueIdLivro(item.getLivro().getId()).getLivro();
		}catch (NullPointerException e){
			return false;
		}
		return estoqueBDdao.getItemNoEstoqueIdLivro(item.getLivro().getId()).getLivro().equals(item.getLivro());
	}

	private boolean isImpresso(Item item) {
		return item.getLivro().getTipo().equals(Tipo.IMPRESSO);
	}

}
