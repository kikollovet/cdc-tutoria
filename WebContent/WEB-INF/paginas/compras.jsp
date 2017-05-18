<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Compras</title>
</head>
	<body>
		<h3>Lista de compras</h3>
		<h3>---------------------</h3>
		<br>
		<br>
		<table border="1px">
			<tr>
				<th>Id Compra</th>
				<th>Nome do usuario</th>
				<th>Data da Compra</th>
				<th>Livro</th>
				<th>Tipo</th>
				<th>Quantidade</th>
				<th>Preço Unitário</th>
			</tr>
			<c:forEach items="${compras}" var="item">
				<c:forEach items="${item.itens}" var="item2">
				<tr>
					<td>${item2.compra.id}</td>
					<td>${item2.compra.usuario.nome}</td>
					<td>${item2.compra.dataCompraString}</td>
					<td>${item2.livro.titulo}</td>
					<td>${item2.livro.tipo}</td>
					<td>${item2.quantidade}</td>
					<td>${item2.precoUnitario}</td>
				</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<br>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar a tela inicial</a>
		
	</body>
</html>