package br.com.caelum.projetocdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import br.com.caelum.projetocdc.Autor;
import br.com.caelum.projetocdc.Compra;
import br.com.caelum.projetocdc.Item;
import br.com.caelum.projetocdc.Livro;
import br.com.caelum.projetocdc.Tipo;
import br.com.caelum.projetocdc.Usuario;
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
	
	public Compra getCompra(int id) {
		
		try(Connection c = new ConnectionFactory().getConnection()){
			
			Compra compra = new Compra();
			
			String sql = "select * from usuario u join compra c on u.id = c.id_usuario where c.id = ?;";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				int idUsuario = rs.getInt("u.id");
				String nomeUsuario = rs.getString("u.nome");
				String emailUsuario = rs.getString("u.email");
				
				Usuario usuario = new Usuario(nomeUsuario, emailUsuario);
				usuario.setId(idUsuario);
				
				Calendar dataCompra = Calendar.getInstance();
				dataCompra.setTime(rs.getDate("c.data"));
				
				compra = new Compra(usuario, dataCompra);
				compra.setId(id);
			}
			
			String sql2 = "select * from itens i join livros l on i.id_livro = l.id join autores a on l.autor = a.id where i.id_compra = ?;";
			
			PreparedStatement stmt2 = c.prepareStatement(sql2);
			stmt2.setInt(1, id);
			
			ResultSet rs2 = stmt2.executeQuery();
			
			while(rs2.next()) {
				String nomeAutor = rs2.getString("a.nome");
				int idAutor = rs2.getInt("a.id");
				
				Autor autor = new Autor(nomeAutor);
				autor.setId(idAutor);
				
				String titulo = rs2.getString("l.titulo");
				String subTitulo = rs2.getString("l.subtitulo");
				
				Calendar dataUltimaAtualizacao = Calendar.getInstance();
				dataUltimaAtualizacao.setTime(rs2.getDate("l.dataultimaatualizacao"));
				
				Calendar dataLancamento = Calendar.getInstance();
				dataLancamento.setTime(rs2.getDate("l.datalancamento"));
				
				double preco = rs2.getDouble("l.preco");
				String tipo = rs2.getString("l.tipo");
				
				Livro livro = new Livro(titulo, subTitulo, autor, Tipo.valueOf(tipo), preco, dataUltimaAtualizacao, dataLancamento);
				
				
				int quantidade = rs2.getInt("i.quantidade");
				double precoItenCompra = rs2.getDouble("i.preco");
				
				Item item = new Item(livro, quantidade);
				item.setPrecoUnitario(precoItenCompra);
				
				compra.getItens().add(item);
			}
			
			return compra;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
