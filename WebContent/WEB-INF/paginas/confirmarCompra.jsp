<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmar Pedido</title>
</head>
	<body>
		<h1>Quer confirmar o pedido?</h1>
		<h1>---------------------------</h1>
		<form action="inicio" method="get">
			<input type="submit" value="Não"/>
		</form>
		<form action="finalizarCompra" method="post">
			<input type="submit" value="Sim"/>
		</form>
	</body>
</html>