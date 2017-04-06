package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.jdbc.ConnectionFactory;

public class CompraBDDao {

	public void adiciona(Compra compra) {
		
		try(Connection c = new ConnectionFactory().getConnection()) {
			int idCompra = 0;
			
			String sql = "insert into compra (id_usuario, data) values (?,?);";
			
			PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, compra.getUsuario().getId());
			stmt.setDate(2, new Date(compra.getData().getTimeInMillis()));
			
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				idCompra = rs.getInt(1);
			}
			
			String sql2 = "insert into itens (id_compra, id_livro, quantidade, preco) values (?,?,?,?);";
			
			PreparedStatement stmt2 = c.prepareStatement(sql2);
			
			for (Item item : compra.getItens()) {
				
				stmt2.setInt(1, idCompra);
				stmt2.setInt(2, item.getLivro().getId());
				stmt2.setInt(3, item.getQuantidade());
				stmt2.setDouble(4, item.getPrecoUnitario());
				stmt2.execute();
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
