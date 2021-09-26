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
		<form:form action="/producto/crear" method="post" modelAttribute="producto">
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
			
			
			<input type="submit" value="crear producto">
		</form:form>
		<br>
		<hr>
		<h1>Lista de productos</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Tipo</th>
					<th>NombreProducto</th>
					<th>Descripcion</th>
					<th>Codigo</th>
					<th>Inventario</th> 
					<th>Precio</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${lista_productos}" >
				<tr>
					<td><c:out value="${producto.id}" /> </td>
					<td><c:out value="${producto.tipo}" /> </td>
					<td><c:out value="${producto.nombreProducto}" /> </td>
					
					<td><c:out value="${producto.descripcion}" /> </td> 
					<td><c:out value="${producto.codigo}" /> </td>
					<td><c:out value="${producto.inventario}" /> </td>
					<td><c:out value="${producto.precio}" /> </td>
					
					
					
					<td>
						<a href="/producto/actualizar/${producto.id}">EDITAR</a>
						
					
						 
						<form action="/producto/eliminar2/${producto.id}" method="POST">
							<input type="hidden" name="_method" value="delete" >
							<input type="submit" value="Eliminar">
						</form>
						
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>