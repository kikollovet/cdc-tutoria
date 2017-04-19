package br.com.caelum.projetocdc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class ValidadorCompra {
	
	private Connection connection;
	
	public ValidadorCompra(Connection connection){
		this.connection = connection;
	}

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
	
	public void validaCompraDois(Compra compra){
		List<ItemNoEstoque> lista = geraUmaListaDeItensNoEstoqueAPartirDaCompra(compra, this.connection);
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
	
	public static void validaItem(Item item) throws SQLException{
		EstoqueBDDao eDao = new EstoqueBDDao(new ConnectionFactory().getConnection());
		ItemNoEstoque ine = eDao.getItemNoEstoqueIdLivro(item.getLivro().getId());
		if(item.getLivro().equals(ine.getLivro())){
			if(item.getLivro().getTipo().equals(Tipo.IMPRESSO)){
				if(ine.getQuantidadeNoEstoque() < item.getQuantidade()){
					throw new QuantidadeInsuficienteNoEstoqueException("Não tem quantidade suficiente deste livro no estoque, "
							+ "só temos " + ine.getQuantidadeNoEstoque());
				}
			}
		}
		eDao.fechaConexao();
	}
}