package br.com.caelum.projetocdc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class ValidadorCompra {

	public void validaCompra(Compra compra, ItemNoEstoque itemNoEstoque) {
		for (Item item : compra.getItens()) {
			if(item.getLivro().equals(itemNoEstoque.getLivro())){
				if(item.getLivro().getTipo().equals(Tipo.IMPRESSO)){
					if(itemNoEstoque.getQuantidadeNoEstoque() < item.getQuantidade()){
						throw new QuantidadeInsuficienteNoEstoqueException("Não tem quantidade suficiente deste livro no estoque, "
								+ "só temos " + itemNoEstoque.getQuantidadeNoEstoque());
					}
				}
			}
		}
	}
	
	private List<ItemNoEstoque> geraUmaListaDeItensNoEstoqueAPartirDaCompra(Compra compra, Connection connection){
		List<ItemNoEstoque> lista = new ArrayList<>();
		EstoqueBDDao eDao = new EstoqueBDDao(connection);
		for (Item item : compra.getItens()) {
			ItemNoEstoque ine = eDao.getItemNoEstoqueIdLivro(item.getLivro().getId());
			lista.add(ine);
		}
		return lista;
	}
	
	public void validaCompraDois(Compra compra, Connection connection){
		List<ItemNoEstoque> lista = geraUmaListaDeItensNoEstoqueAPartirDaCompra(compra, connection);
		for(Item item : compra.getItens()){
			for(ItemNoEstoque itemNoEstoque : lista){
				if(item.getLivro().equals(itemNoEstoque.getLivro())){
					if(item.getLivro().getTipo().equals(Tipo.IMPRESSO)){
						if(itemNoEstoque.getQuantidadeNoEstoque() < item.getQuantidade()){
							throw new QuantidadeInsuficienteNoEstoqueException("Não tem quantidade suficiente deste livro no estoque, "
									+ "só temos " + itemNoEstoque.getQuantidadeNoEstoque());
						}
					}
				}
			}
		}
	}
}