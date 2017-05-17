<html>
	<body>
		<h1>Formulario cadastro autor</h1>
		<h1>-------------------------</h1>
		<form action="cadastrarAutor" method="post">
		Nome: <input type="text" name="nome"/> ${erroNome}
		<br>
		<input type="submit" value="Cadastrar"/>
		</form>
		<br>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar a tela inicial</a>
	</body>
</html>