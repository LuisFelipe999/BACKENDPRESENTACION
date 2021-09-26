<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
	<div>
		<form:form action="/venta/modificar" method="post" modelAttribute="venta">
		
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			
			<form:label path="productoenCarro">Producto en carro:</form:label>
			<form:input type="text" path="productoenCarro"/><br>
			
			<form:label path="precioProductoenCarro">Precio Producto en Carro:</form:label>
			<form:input type="text" path="precioProductoenCarro"/><br>
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br> 
			
			
			<input type="submit" value="modificar compra">
		</form:form>
		
	</div>
</body>
</html>

