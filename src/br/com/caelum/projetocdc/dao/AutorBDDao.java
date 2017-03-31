package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class AutorBDDao implements AutorDAO{

	public void adiciona(Autor autor){
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
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void alteraNome(String nome, int id) {
		Connection con = null;
		
		try{
			con = new ConnectionFactory().getConnection();
			
			String sql = "update autores set nome=? where id=?";
			
			try{
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, nome);
				stmt.setInt(2, id);
				
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
