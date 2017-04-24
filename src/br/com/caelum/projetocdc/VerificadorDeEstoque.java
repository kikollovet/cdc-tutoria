package br.com.caelum.projetocdc;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class VerificadorDeEstoque {

	private EstoqueBDDao estoqueBDdao;

	public VerificadorDeEstoque(EstoqueBDDao estoqueBDdao) {
		this.estoqueBDdao = estoqueBDdao;
	}

	public boolean verificaTemNoEstoque(Item item) {
		if (isImpresso(item) && temNoEstoque(item)) {
			ItemNoEstoque itemNoEstoque = estoqueBDdao.getItemNoEstoqueIdLivro(item.getLivro().getId());
			if (isQuantidadeDisponivel(item, itemNoEstoque)) {
				throw new QuantidadeInsuficienteNoEstoqueException("Não temos essa quantidade de livros"
						+ " disponível no estoque. Temos " + itemNoEstoque.getQuantidadeNoEstoque());
			}
		}
		return true;
	}

	private boolean isQuantidadeDisponivel(Item item, ItemNoEstoque itemNoEstoque) {
		return itemNoEstoque.getQuantidadeNoEstoque() < item.getQuantidade();
	}

	private boolean temNoEstoque(Item item) {
		return item.getLivro().equals(estoqueBDdao.getItemNoEstoqueIdLivro(item.getLivro().getId()).getLivro());
	}

	private boolean isImpresso(Item item) {
		return item.getLivro().getTipo().equals(Tipo.IMPRESSO);
	}

}
