package br.com.caelum.projetocdc;

import br.com.caelum.projetocdc.dao.EstoqueBDDao;

public class AtualizadorDeEstoque {

	EstoqueBDDao estoqueDao;

	public AtualizadorDeEstoque(EstoqueBDDao estoqueDao) {
		this.estoqueDao = estoqueDao;
	}

	public void atualizaEstoque(Compra compra){
		for(Item item: compra.getItens()){
			if(item.getLivro().getTipo().equals(Tipo.IMPRESSO)){
				ItemNoEstoque itemNoEstoque = estoqueDao.getItemNoEstoqueIdLivro(item.getLivro().getId());
				if(itemNoEstoque != null){
					estoqueDao.diminuiQuantidade(itemNoEstoque, item.getQuantidade());
				}
			}
		}
	}
	
}
