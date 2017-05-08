package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.exception.NaoPodeAdicionarEbookNoEstoqueException;

public class EstoqueBDDao {

	Connection connection;
	EntityManager manager;
	
	public EstoqueBDDao(Connection connection){
		this.connection = connection;
	}
	
	public EstoqueBDDao(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(ItemNoEstoque itemNoEstoque) throws NaoPodeAdicionarEbookNoEstoqueException{
		manager.persist(itemNoEstoque);
	}
	
	public void diminuiQuantidade(ItemNoEstoque itemNoEstoque, int quantidade){
		itemNoEstoque.setQuantidadeNoEstoque(itemNoEstoque.getQuantidadeNoEstoque() - quantidade);
		manager.merge(itemNoEstoque);
	}
	
	public void aumentaQuantidade(ItemNoEstoque itemNoEstoque, int quantidade){
		itemNoEstoque.setQuantidadeNoEstoque(itemNoEstoque.getQuantidadeNoEstoque() + quantidade);
		manager.merge(itemNoEstoque);
	}
	
	public ItemNoEstoque getItemNoEstoque(int id) throws NaoPodeAdicionarEbookNoEstoqueException{
		return manager.find(ItemNoEstoque.class, id);
	}
	
	public ItemNoEstoque getItemNoEstoqueIdLivro(int id) throws NaoPodeAdicionarEbookNoEstoqueException{
		Query query = manager.createQuery("from estoque as e where e.id_livro = ?");
		query.setParameter(1, id);
		List<ItemNoEstoque> lista = query.getResultList();
		return lista.get(0);
	}
	
	public void fechaConexao() throws SQLException{
		this.connection.close();
	}
}
