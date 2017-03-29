package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class AutorDAO {

	public void adiciona(Autor autor) throws SQLException{
		Connection con = null;
		
		try{
			con = new ConnectionFactory().getConnection();
			
			String sql = "insert into autores (nome) values (?)";
			
			try{
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, autor.getNome());
				
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		} finally {
			con.close();
		}
	}
}
