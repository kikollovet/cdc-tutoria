package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.projetocdc.Livro;
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
}
