package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class LivroBDDao {

	public void adiciona(Livro livro){
		
		try(Connection c = new ConnectionFactory().getConnection()){
			
			String sql = "insert into livros (titulo, subtitulo, autor, dataultimaatualizacao, "
					+ "datalancamento, preco, tipo) values(?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getSubTitulo());
			stmt.setInt(3, livro.getAutor().getId());
			stmt.setDate(4, new Date(livro.getDataUltimaAtualizacao().getTimeInMillis()));
			stmt.setDate(5, new Date(livro.getDataLancamento().getTimeInMillis()));
			stmt.setDouble(6, livro.getPreco());
			stmt.setString(7, livro.getTipo().name());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Livro livro){
		
		try(Connection c = new ConnectionFactory().getConnection()){
			
			String sql = "update livros set titulo=?, subtitulo=?, autor=?, dataultimaatualizacao=?, "
					+ "datalancamento=?, preco=?, tipo=? where id=?;";
					
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getSubTitulo());
			stmt.setInt(3, livro.getAutor().getId());
			stmt.setDate(4, new Date(livro.getDataUltimaAtualizacao().getTimeInMillis()));
			stmt.setDate(5, new Date(livro.getDataLancamento().getTimeInMillis()));
			stmt.setDouble(6, livro.getPreco());
			stmt.setString(7, livro.getTipo().name());
			stmt.setInt(8, livro.getId());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Livro getLivro(int id){
		
		try(Connection c = new ConnectionFactory().getConnection()){
			
			String sql = "select * from livros l join autores a on l.autor = a.id where l.id=?;";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				String titulo = rs.getString("titulo");
				String subTitulo = rs.getString("subtitulo");
				
				Calendar dataUltimaAtualizacao = Calendar.getInstance();
				dataUltimaAtualizacao.setTime(rs.getDate("dataultimaatualizacao"));
				
				Calendar dataLancamento = Calendar.getInstance();
				dataLancamento.setTime(rs.getDate("datalancamento"));
				
				double preco = rs.getDouble("preco");
				String tipo = rs.getString("tipo");
				
				String nomeAutor = rs.getString("a.nome");
				int idAutor = rs.getInt("l.autor");
				
				
				Autor autor = new Autor(nomeAutor);
				autor.setId(idAutor);
				
				Livro livro = new Livro(titulo, subTitulo, 
						autor, Tipo.valueOf(tipo), preco, dataUltimaAtualizacao, dataLancamento);
				livro.setId(id);
				
				return livro;
			}
			
			return null;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void remove(int id){
		
		try(Connection c = new ConnectionFactory().getConnection()){
			
			String sql = "delete from livros where id=?;";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
