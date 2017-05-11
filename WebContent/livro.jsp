<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<body>
		<h1>Detalhes do Livro</h1>
		<h4>T�tulo: ${livro.titulo}</h4>
		<h4>T�tulo: ${livro.subTitulo}</h4>
		<h4>Autor: ${livro.autor.nome}</h4>
		<h4>Data da ultima atualiza��o: ${livro.dataUltimaAtualizacaoString}</h4>
		<h4>Data lancamento: ${livro.dataLancamentoString}</h4>
		<h4>Pre�o: ${livro.preco}</h4>
		<h4>Tipo: ${livro.tipo}</h4>
	</body>
</html>