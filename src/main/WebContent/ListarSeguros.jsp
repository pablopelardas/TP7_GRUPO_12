<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.Seguro" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP N° 7 Grupo 12 - Listar Seguro</title>
<style>
	.menu-nav{
	  	width: 100%;
	  	display: flex;
	  	justify-content: center;
	  	gap: 10px;
	  }
	  
	body {
    	font-family: "Inter", Arial, Helvetica, sans-serif;
 	}
  
    p, select, input {
      display: inline-block;
      vertical-align: middle; 
      margin: 5px;
      font-size: 16px;
    }
    
    input[type="submit"]{
    	cursor: pointer;
    	background-color: #6a64f1;
    	color: white;
    	padding: 10px 22px;
    	border: none;
    	border-radius: 8px;
    }
    
    .formbold-form-input {
    width: 50%;
    padding: 12px 24px;
    border-radius: 6px;
    border: 1px solid #e0e0e0;
    background: white;
    font-weight: 500;
    font-size: 16px;
    color: #6b7280;
    outline: none;
    resize: none;
  }
  
    .formbold-form-input:focus {
    border-color: #6a64f1;
    box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
  }
    
    form {
      width: 500px; 
      margin: 50px auto;
      text-align: center;
      padding: 20px;
      border-radius: 10px;
      background-color: #fff;
    }

  table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 50px;
            
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: center;
        }
</style>
</head>
<body>
<nav class="menu-nav">
	<a href="Inicio.jsp">Inicio</a> |
	<a href="ServletAgregarSeguro">Agregar Seguro</a> |
	<a href="ServletListarSeguros?tipo-seguro=todos&txtFiltrar=Filtrar">Listar Seguro</a>
</nav>
<form action="ServletListarSeguros" method="get">	
	<div>	
		<h2>Tipos de seguros de la base de datos</h2>
		<p>Búsqueda por tipo de Seguros:</p>  
		<select
		        name="tipo-seguro"
		        id="tipo-seguro"
		        class="formbold-form-input"
		      >
		        <option value="moto" <%= "moto".equals(request.getParameter("tipo-seguro")) ? "selected" : "" %>>Moto</option>
		        <option value="hogar" <%= "hogar".equals(request.getParameter("tipo-seguro")) ? "selected" : "" %>>Hogar</option>
		        <option value="vida" <%= "vida".equals(request.getParameter("tipo-seguro")) ? "selected" : "" %>>Vida</option>
		      </select>
		 <input type="submit" name="txtFiltrar" value="Filtrar">
		 <table>
        <thead>
            <tr>
                <th>ID Seguro</th>
                <th>Descripción seguro</th>
                <th>Descripción tipo seguro</th>
                <th>Costo contratación</th>
                <th>Costo máximo asegurado</th>
            </tr>
        </thead>
        <tbody>
        	<% 
        	ArrayList<Seguro>listaSeguros;
        	listaSeguros = (ArrayList<Seguro>)request.getAttribute("seguroLista"); 
        	if (listaSeguros != null && !listaSeguros.isEmpty()) {
                for (Seguro seguro : listaSeguros) {
        	%>
        	        <tr>
                        <td><%= seguro.getIdSeguro() %></td>
                        <td><%= seguro.getDescripcion() %></td>
                        <td><%= seguro.getTipoSeguro().getDescripcion() %></td>
                        <td><%= seguro.getCostoContratacion() %></td>
                        <td><%= seguro.getCostoMAsegurado() %></td>
                    </tr>
                            <%
                        }
                    } else {
            %>
                    <tr>
                        <td colspan="5">No se encontraron seguros.</td>
                    </tr>
            <%
                    }
            %>
        
        </tbody>
        </table>
	</div>
    
</form>
</body>
</html>