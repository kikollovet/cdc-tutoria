<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<h1>Cadastro Livro</h1>
		<h1>--------------</h1>
		<form action="cadastrarLivro" method="post">
		Titulo: <input type="text" name="titulo"/>${erroTitulo}<br>
		SubTitulo: <input type="text" name="subTitulo"/>${erroSubTitulo}<br>
		Autor: <select name="autor">
					<c:forEach items="${lista}" var="autor">
						<option value="${autor.id}">${autor.id}-${autor.nome}</option>
					</c:forEach>
				</select><br>
		Data Ultima Atualização: <input type="text" name="dataUltimaAtualizacao"/>${erroDataUltimaAtualizacao} <br>
		Data Lançamento: <input type="text" name="dataLancamento"/>${erroDataLancamento} <br>
		Preço: <input type="text" name="preco" />${erroPreco}<br>
		Tipo: <select name="tipo">
					<option value="EBOOK">EBOOK</option>
					<option value="IMPRESSO">IMPRESSO</option>
				</select><br>
		<input type="submit" value="Cadastrar"/>
		</form>
	</body>
</html>