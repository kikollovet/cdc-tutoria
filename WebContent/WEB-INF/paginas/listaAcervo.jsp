<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<body>
		<h1>Lista de livros</h1>
		<table border="1px">
		<c:forEach items="${lista}" var="livro">
			<tr>
				<td>Título: <c:out value="${livro.titulo}"/></td>
				<td><a href="http://localhost:8080/cdc-tutoria/mostraLivro?id=${livro.id}">Ver detalhes</a></td>
			</tr>
		</c:forEach>
		</table>
		<br>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar a tela inicial</a>
	</body>
</html>