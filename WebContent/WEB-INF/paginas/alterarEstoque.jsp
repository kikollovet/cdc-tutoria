<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar estoque</title>
</head>
	<body>
		<h1>Estoque</h1>
		<h1>-----------</h1>
		<br>
		<table border="1px">
			<tr>
				<th>Titulo</th>
				<th>Tipo</th>
				<th>Quantidade</th>
				<th>Aumentar quantidade</th>
				<th>Diminuir quantidade</th>
			</tr>
			<c:forEach items="${lista}" var="item">
				<tr>
					<td>${item.livro.titulo}</td>
					<td>${item.livro.tipo}</td>
					<td>${item.quantidadeNoEstoque}</td>
					<td>
						<form action="aumentaQuantidade" method="post">
							<input type="hidden" value="${item.id}" name="id"/>
							<input type="text" name="quantidade"/>
							<input type="submit" value="Aumenta quantidade"/>
						</form>
					</td>
					<td>
						<form action="diminuiQuantidade" method="post">
							<input type="hidden" value="${item.id}" name="id"/>
							<input type="text" name="quantidade"/>
							<input type="submit" value="Diminui quantidade"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar a tela de inicio</a>
	</body>
</html>