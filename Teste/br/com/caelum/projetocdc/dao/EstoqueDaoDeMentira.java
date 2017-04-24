package br.com.caelum.projetocdc.dao;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.exception.NaoPodeAdicionarEbookNoEstoqueException;
import br.com.caelum.projetocdc.exception.QuantidadeInsuficienteNoEstoqueException;

public class EstoqueDaoDeMentira extends EstoqueBDDao {

	

	private Livro livro = new Livro("1", "", new Autor("Fernando"), Tipo.IMPRESSO, 10.0);


	public EstoqueDaoDeMentira() {
		super(null);
	}
	
	
	@Override
	public ItemNoEstoque getItemNoEstoqueIdLivro(int id) throws NaoPodeAdicionarEbookNoEstoqueException {
		if(id == 2){
			throw new QuantidadeInsuficienteNoEstoqueException();
		}
		return new ItemNoEstoque(livro, 4);
	}
	

}
