<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<body>
		<h1>Detalhes do Livro</h1>
		<h4>Título: <c:out value="${livro.titulo}"/></h4>
		<h4>Título: <c:out value="${livro.subTitulo}"/></h4>
		<h4>Autor: <c:out value="${livro.autor.nome}"/></h4>
		<h4>Data da ultima atualização: <c:out value="${livro.dataUltimaAtualizacaoString}"/></h4>
		<h4>Data lancamento: <c:out value="${livro.dataLancamentoString}"/></h4>
		<h4>Preço: <c:out value="${livro.preco}"/></h4>
		<h4>Tipo: <c:out value="${livro.tipo}"/></h4>
	</body>
</html>