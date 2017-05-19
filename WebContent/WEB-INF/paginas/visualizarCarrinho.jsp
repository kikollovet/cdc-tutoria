<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
	<body>
		<h1>Itens no carrinho</h1>
		<h1>-----------------</h1>
		<table border="1px">
			<tr>
				<th>Livro</th>
				<th>Quantidade</th>
				<th>Preço unitário</th>
				<th>Preço Total</th>
			</tr>
			<c:forEach items="${carrinho.itens}" var="item">
				<tr>
					<td>${item.livro.titulo}</td>
					<td>${item.quantidade}</td>
					<td>${item.precoUnitario}</td>
					<td>${item.precoTotal}</td>
				</tr>
			</c:forEach>
		</table>
		<h3>O preço total do carrinho é R$ ${total}</h3>
		<br>
		<br>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar a tela inicial</a><br>
		<a href="http://localhost:8080/cdc-tutoria/listaAcervo">Todo o acervo com a opção de ver detalhes do livro</a><br>
		<a href="http://localhost:8080/cdc-tutoria/paginaConfirmacaoCompra">Finalizar pedido</a>
	</body>
</html>