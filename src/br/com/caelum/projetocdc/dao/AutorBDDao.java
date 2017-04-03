package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void altera(Autor autor) {
		Connection con = null;
		
		try{
			con = new ConnectionFactory().getConnection();
			
			String sql = "update autores set nome=? where id=?";
			
			try{
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, autor.getNome());
				stmt.setInt(2, autor.getId());
				
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
	
	public Autor getAutor(int id){
		
		
		try(Connection c = new ConnectionFactory().getConnection()) {
			
			String sql = "select * from autores where id=?;";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				String nome = rs.getString("nome");
			
				Autor autor = new Autor(nome);
				autor.setId(id);
				
				return autor;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(int id){
		
		try(Connection c = new ConnectionFactory().getConnection()){
			
			String sql = "delete from autores where id=?;";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
