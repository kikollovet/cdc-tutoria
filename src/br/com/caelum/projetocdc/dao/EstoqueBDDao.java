package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.projetocdc.ItemNoEstoque;

public class EstoqueBDDao {

	Connection connection;
	
	public EstoqueBDDao(Connection connection){
		this.connection = connection;
	}
	
	public void adiciona(ItemNoEstoque itemNoEstoque){
		try{
			String sql = "insert into estoque (id_livro, quantidade) values (?,?);";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, itemNoEstoque.getLivro().getId());
			stmt.setInt(2, itemNoEstoque.getQuantidadeNoEstoque());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void diminuiQuantidade(ItemNoEstoque itemNoEstoque, int quantidade){
		try{
			String sql = "update estoque set quantidade = quantidade - ? where id = ?;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, quantidade);
			stmt.setInt(2, itemNoEstoque.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void aumentaQuantidade(ItemNoEstoque itemNoEstoque, int quantidade){
		try{
			String sql = "update estoque set quantidade = quantidade + ? where id = ?;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, quantidade);
			stmt.setInt(2, itemNoEstoque.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
