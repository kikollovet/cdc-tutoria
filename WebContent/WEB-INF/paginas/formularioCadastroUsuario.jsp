<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro Usuario</title>
</head>
	<body>
		<h1>Cadastro Usuário</h1>
		<h1>----------------</h1>
		<form action="cadastrarUsuario" method="post">
		Nome: <input type="text" name="nome"/> ${erroNome}
		<br>
		email: <input type="text" name="email" /> ${erroEmail}
		<br>
		<input type="submit" value="Cadastrar"/>		
		</form>
		<br>
		<a href="http://localhost:8080/cdc-tutoria/inicio">Voltar a tela inicial</a>
	</body>
</html>