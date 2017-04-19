package br.com.caelum.projetocdc;

import java.util.Calendar;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class GeradoraDeCompra {

	private EstoqueBDDao estoqueDao;

	public GeradoraDeCompra(EstoqueBDDao estoqueDao) {
		this.estoqueDao = estoqueDao;
	}

	public Compra novaCompra(Usuario usuario, Calendar data, CarrinhoDeCompras carrinho) {
		Compra compra = new Compra(usuario, data);
		for(Item item : carrinho.getItens()){
			if(item.getLivro().equals(estoqueDao.getItemNoEstoqueIdLivro(item.getLivro().getId()).getLivro())){
				if(item.getLivro().getTipo().equals(Tipo.IMPRESSO)){
					ItemNoEstoque itemNoEstoque = estoqueDao.getItemNoEstoqueIdLivro(item.getLivro().getId());
					if(itemNoEstoque.getQuantidadeNoEstoque() < item.getQuantidade()){
						throw new QuantidadeInsuficienteNoEstoqueException("Não temos essa quantidade de livros"
								+ " disponível no estoque. Temos " + itemNoEstoque.getQuantidadeNoEstoque());
					}
				}
			}
		}
		return compra;
	}

}
