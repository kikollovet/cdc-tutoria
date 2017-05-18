<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<body>
		<h1>Detalhes do Livro</h1>
		<h4>Título: <c:out value="${livro.titulo}"/></h4>
		<h4>Subtítulo: <c:out value="${livro.subTitulo}"/></h4>
		<h4>Autor: <c:out value="${livro.autor.nome}"/></h4>
		<h4>Data da ultima atualização: <c:out value="${livro.dataUltimaAtualizacaoString}"/></h4>
		<h4>Data lancamento: <c:out value="${livro.dataLancamentoString}"/></h4>
		<h4>Preço: <c:out value="${livro.preco}"/></h4>
		<h4>Tipo: <c:out value="${livro.tipo}"/></h4>
		<br>
		<br>
		<h4>Escolha a quantidade para adicionar no carrinho</h4>
		<form action="adicionarCarrinho" method="post">
		<input hidden="text" name="id" value="${livro.id}"/>
		Quantidade: <input type="text" name="quantidade"/>
		<input type="submit" value="Adicionar no carrinho"/>
		</form>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar a tela inicial</a>
	</body>
</html>