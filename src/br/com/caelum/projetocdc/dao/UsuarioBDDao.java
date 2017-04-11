package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.projetocdc.Usuario;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class UsuarioBDDao {

	private Connection connection;
	
	public UsuarioBDDao(Connection connection){
		this.connection = connection;
	}
	
	public void adiciona(Usuario usuario){
		
		try{
			
			String sql = "insert into usuario (nome,email) values (?,?);";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Usuario usuario) {
		
		try{
			
			String sql = "update usuario set nome=?, email=? where id=?;";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setInt(3, usuario.getId());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario getUsuario(int id){
		
		try{
			
			String sql = "select * from usuario where id=?;";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				int idUsuario = rs.getInt("id");
				
				Usuario usuario = new Usuario(nome, email);
				usuario.setId(idUsuario);
				
				return usuario;
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(int id){
		
		try{
			
			String sql = "delete from usuario where id=?;";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
