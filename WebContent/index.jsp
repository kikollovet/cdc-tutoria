<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<h1>Bem vindo a casa do C�digo</h1>
		<h1>--------------------------</h1>
		<h4>Fa�a seu login</h4>
		<h4>--------------</h4>
		${erroLogin}
		<form action="autentificar" method="post">
		Nome: <input type="text" name="nome"/><br>
		senha: <input type="password" name="senha" /><br>
		<input type="submit" value="Efetuar login!"/>
		</form>
		
	</body>
</html>