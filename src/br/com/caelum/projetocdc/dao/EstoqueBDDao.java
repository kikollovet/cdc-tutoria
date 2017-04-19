package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.ItemNoEstoque;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.exception.NaoPodeAdicionarEbookNoEstoqueException;

public class EstoqueBDDao {

	Connection connection;
	
	public EstoqueBDDao(Connection connection){
		this.connection = connection;
	}
	
	public void adiciona(ItemNoEstoque itemNoEstoque) throws NaoPodeAdicionarEbookNoEstoqueException{
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
	
	public ItemNoEstoque getItemNoEstoque(int id) throws NaoPodeAdicionarEbookNoEstoqueException{
		try{
			ItemNoEstoque itemNoEstoque = null;
			
			String sql = "select * from estoque e join livros l on e.id_livro = l.id join autores a on l.autor = a.id where e.id = ?;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				int idItem = rs.getInt("e.id");
				int quantidade = rs.getInt("e.quantidade");
				int idLivro = rs.getInt("e.id_livro");
				
				String titulo = rs.getString("l.titulo");
				String subTitulo = rs.getString("l.subtitulo");
				
				Calendar dataUltimaAtualizacao = Calendar.getInstance();
				dataUltimaAtualizacao.setTime(rs.getDate("l.dataultimaatualizacao"));
				
				Calendar dataLancamento = Calendar.getInstance();
				dataLancamento.setTime(rs.getDate("l.datalancamento"));
				
				double preco = rs.getDouble("l.preco");
				String tipo = rs.getString("l.tipo");
				
				String nomeAutor = rs.getString("a.nome");
				int idAutor = rs.getInt("l.autor");
				
				
				Autor autor = new Autor(nomeAutor);
				autor.setId(idAutor);
				
				Livro livro = new Livro(titulo, subTitulo, 
						autor, Tipo.valueOf(tipo), preco, dataUltimaAtualizacao, dataLancamento);
				livro.setId(idLivro);
				
				itemNoEstoque = new ItemNoEstoque(livro, quantidade);
				itemNoEstoque.setId(id);
			}
			return itemNoEstoque;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ItemNoEstoque getItemNoEstoqueIdLivro(int id) throws NaoPodeAdicionarEbookNoEstoqueException{
		try{
			ItemNoEstoque itemNoEstoque = null;
			
			String sql = "select * from estoque e join livros l on e.id_livro = l.id join autores a on l.autor = a.id where e.id_livro = ?;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				int idItem = rs.getInt("e.id");
				int quantidade = rs.getInt("e.quantidade");
				int idLivro = rs.getInt("e.id_livro");
				
				String titulo = rs.getString("l.titulo");
				String subTitulo = rs.getString("l.subtitulo");
				
				Calendar dataUltimaAtualizacao = Calendar.getInstance();
				dataUltimaAtualizacao.setTime(rs.getDate("l.dataultimaatualizacao"));
				
				Calendar dataLancamento = Calendar.getInstance();
				dataLancamento.setTime(rs.getDate("l.datalancamento"));
				
				double preco = rs.getDouble("l.preco");
				String tipo = rs.getString("l.tipo");
				
				String nomeAutor = rs.getString("a.nome");
				int idAutor = rs.getInt("l.autor");
				
				
				Autor autor = new Autor(nomeAutor);
				autor.setId(idAutor);
				
				Livro livro = new Livro(titulo, subTitulo, 
						autor, Tipo.valueOf(tipo), preco, dataUltimaAtualizacao, dataLancamento);
				livro.setId(idLivro);
				
				itemNoEstoque = new ItemNoEstoque(livro, quantidade);
				itemNoEstoque.setId(id);
			}
			return itemNoEstoque;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void fechaConexao() throws SQLException{
		this.connection.close();
	}
}
