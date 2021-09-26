<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Venta</title>
</head>
<body>
	<div>
		<form:form action="/venta/crear" method="post" modelAttribute="venta">
			<form:label path="productoenCarro">Producto en Carro:</form:label>
			<form:input type="text" path="ProductoenCarro"/><br>
			
			<form:label path="precioProductoenCarro">Precio Producto en Carro:</form:label>
			<form:input type="text" path="precioProductoenCarro"/><br> 
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br> 
			<h1>Total Compra</h1>
			<div>${tot}</div>

			<input type="submit" value="Comprar"> 

			<br>  
			<div id="container">
				<div id="label">     Lista de Producto con su Precio</div>
		
			<select name="productos" multiple>
				<c:forEach var="producto" items="${lista_productos}" > 
				<option value="< c:out value="${producto.id}" />"> <c:out value="${producto.nombreProducto}" />&nbsp;<c:out value="${producto.precio}" /> </option>  		
			
		
				</c:forEach>
			</select>  
		
			</div>
			<br>
		
		</form:form>
		<br>
		<hr>
		<h1>Lista de compras</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Producto</th>
					<th>Precio</th>
					<th>Cantidad</th> 
					
					
					
				</tr>
			</thead>
			<tbody> 
				<c:forEach var="venta" items="${lista_ventas}" >
				<tr>
					<td><c:out value="${venta.id}" /> </td>
					<td><c:out value="${venta.productoenCarro}" /> </td>
					<td><c:out value="${venta.precioProductoenCarro}" /> </td>
					<td><c:out value="${venta.cantidad}" /> </td>  
					
					<td></td>
					<td>
					
					
						<a href="/venta/actualizar/${venta.id}">EDITAR</a>
						
					
						 
						<form action="/venta/eliminar2/${venta.id}" method="POST">
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