<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP N° 7 Grupo 12- Inicio</title>
<style>
  body {
    font-family: "Inter", Arial, Helvetica, sans-serif;
  }
  
  .menu-nav{
  	width: 100%;
  	display: flex;
  	justify-content: center;
  	gap: 10px;
  }
</style>

</head>
<body>

<nav class="menu-nav">
	<a href="Inicio.jsp">Inicio</a> |
	<a href="AgregarSeguro.jsp">Agregar Seguro</a> |
	<a href="ServletListarSeguros?tipo-seguro=todos&txtFiltrar=Filtrar">Listar Seguro</a>
</nav>

<h2> Soy la página inicio</h2>
</body>
</html>