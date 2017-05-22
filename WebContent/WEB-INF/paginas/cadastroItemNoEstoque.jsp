<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro item no estoque</title>
</head>
	<body>
		<h1>Cadastro de Item no Estoque</h1>
		<h1>----------------------------------</h1>
		<form action="inserirItemNoEstoque" method="post">
			<select name="livro">
				<c:forEach items="${lista}" var="livro">
					<option value="${livro.id}">${livro.titulo}</option>
				</c:forEach>
			</select>
			<input type="text" name="quantidade"/>
			<input type="submit" value="Cadastrar"/>
		</form>
		<br>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar ao inicio</a>
	</body>
</html>