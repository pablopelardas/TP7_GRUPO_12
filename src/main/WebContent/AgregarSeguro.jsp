<%@page import="dominio.TipoSeguro"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP N° 7 Grupo 12 - Agregar Seguro</title>

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
  .formbold-mb-5 {
    margin-bottom: 20px;
  }
  .formbold-pt-3 {
    padding-top: 12px;
  }
  .formbold-main-wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 48px;
  }

  .formbold-form-wrapper {
    margin: 0 auto;
    max-width: 550px;
    width: 100%;
    background: white;
  }
  .formbold-form-label {
    display: block;
    font-weight: 500;
    font-size: 16px;
    color: #07074d;
    margin-bottom: 12px;
  }
  .formbold-form-label-2 {
    font-weight: 600;
    font-size: 20px;
    margin-bottom: 20px;
  }

  .formbold-form-input {
    width: 100%;
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
  
  .formbold-form-id-display {
    background-color: #f3f4f6;
    border: 1px solid #d1d5db;
    border-radius: 5px;
    padding: 10px;
    font-size: 16px;
    font-weight: bold;
    color: #374151;
    text-align: center;
  }
  
  .formbold-form-input:focus {
    border-color: #6a64f1;
    box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
  }

  .formbold-btn {
    text-align: center;
    font-size: 16px;
    border-radius: 6px;
    padding: 14px 32px;
    border: none;
    font-weight: 600;
    background-color: #6a64f1;
    color: white;
    width: 100%;
    cursor: pointer;
  }
  .formbold-btn:hover {
    box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
  }

  .formbold--mx-3 {
    margin-left: -12px;
    margin-right: -12px;
  }
  .formbold-px-3 {
    padding-left: 12px;
    padding-right: 12px;
  }
  .flex {
    display: flex;
  }
  .flex-wrap {
    flex-wrap: wrap;
  }
  .w-full {
    width: 100%;
  }
  
  .row{
  	display: flex;
  	justify-content: space-between;
  }
  @media (min-width: 540px) {
    .sm\:w-half {
      width: 50%;
    }
  }
</style>
</head>
<body>
<%
    Integer nuevoId = (Integer) request.getAttribute("nuevoId");
	List<TipoSeguro> tiposSeguros = (List<TipoSeguro>) request.getAttribute("tiposSeguros");

%>
<nav class="menu-nav">
	<a href="Inicio.jsp">Inicio</a> |
	<a href="ServletAgregarSeguro">Agregar Seguro</a> |
	<a href="ServletListarSeguros?tipo-seguro=todos&txtFiltrar=Filtrar">Listar Seguro</a>
</nav>

<div class="formbold-main-wrapper">
  <!-- Author: FormBold Team -->
  <!-- Learn More: https://formbold.com -->
	<div class="formbold-form-wrapper">
	  <form action="ServletAgregarSeguro" method="POST">
    	<!-- Display of Id Seguro -->
	    <div class="formbold-mb-5">
	      <label for="id-seguro" class="formbold-form-label"> Id Seguro </label>
	      <div id="id-seguro" class="formbold-form-id-display"> <%=nuevoId %> </div>
	    </div>
	    <div class="formbold-mb-5">
	      <label for="descripcion" class="formbold-form-label"> Descripción </label>
	      <input
	        type="text"
	        name="descripcion"
	        id="descripcion"
	        placeholder="Descripción"
	        class="formbold-form-input"
	      />
	    </div>
	
	    <div class="formbold-mb-5">
	      <label for="tipo-seguro" class="formbold-form-label"> Tipo de Seguro </label>
	      <select
	        name="tipo-seguro"
	        id="tipo-seguro"
	        class="formbold-form-input"
	      >
                    <%
	                    if (tiposSeguros == null) {
	                        tiposSeguros = new ArrayList<>();
	                    }
                        for (TipoSeguro tipo : tiposSeguros) {
                    %>
                        <option value="<%=tipo.getId()%>"><%=tipo.getDescripcion()%></option>
                    <%
                        }
                    %>
	        <!-- Add other options as needed -->
	      </select>
	    </div>
	
		<div class="row">
		    <div class="formbold-mb-5">
		      <label for="costo-contratacion" class="formbold-form-label"> Costo de Contratación </label>
		      <input
		        type="number"
		        step="0.01"
		        name="costo-contratacion"
		        id="costo-contratacion"
		        placeholder="Costo de contratación"
		        class="formbold-form-input"
		      />
		    </div>
		
		    <div class="formbold-mb-5">
		      <label for="costo-maximo" class="formbold-form-label"> Costo Máximo Asegurado </label>
		      <input
		        type="number"
		        step="0.01"
		        name="costo-maximo"
		        id="costo-maximo"
		        placeholder="Costo máximo asegurado"
		        class="formbold-form-input"
		      />
		    </div>		
		</div>
	    <div>
	      <button type="submit" class="formbold-btn">Guardar Seguro</button>
	    </div>
	  </form>
	</div>
</div>


</body>
</html>