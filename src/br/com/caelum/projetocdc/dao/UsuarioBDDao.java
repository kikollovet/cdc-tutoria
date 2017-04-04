package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class UsuarioBDDao {

	public void adiciona(Usuario usuario){
		
		try(Connection c = new ConnectionFactory().getConnection()) {
			
			String sql = "insert into usuario (nome,email) values (?,?);";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Usuario usuario) {
		
		try(Connection c = new ConnectionFactory().getConnection()){
			
			String sql = "update usuario set nome=?, email=? where id=?;";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setInt(3, usuario.getId());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
