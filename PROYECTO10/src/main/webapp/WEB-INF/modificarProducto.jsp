<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>
	<div> 
	
		<form:form action="/producto/modificar" method="post" modelAttribute="producto">
		
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			
			<form:label path="tipo">tipo:</form:label>
			<form:input type="text" path="tipo"/><br>
			
			<form:label path="nombreProducto">nombreProducto:</form:label>
			<form:input type="text" path="nombreProducto"/><br>
			
			<form:label path="descripcion">descripcion:</form:label>
			<form:input type="text" path="descripcion"/><br>
			
			<form:label path="codigo">codigo:</form:label>
			<form:input type="text" path="codigo"/><br>
			
			<form:label path="inventario">inventario:</form:label>
			<form:input type="text" path="inventario"/><br>
			
			<form:label path="precio">precio:</form:label>
			<form:input type="text" path="precio"/><br>
			
			<input type="submit" value="modificar producto">
		</form:form>
		
	</div>
</body>
</html>
