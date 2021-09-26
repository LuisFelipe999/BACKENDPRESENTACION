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
		<form:form action="/usuario/crear" method="post" modelAttribute="usuario">
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br> 
			
			<form:label path="edad">edad:</form:label>
			<form:input type="text" path="edad"/><br>
			
			<form:label path="email">email:</form:label>
			<form:input type="text" path="email"/><br>
			
			<form:label path="cargo">cargo:</form:label>
			<form:input type="text" path="cargo"/><br> 
			<br>
			
			
			<input type="submit" value="crear usuario">
		</form:form>
		<br>
		<hr>
		<h1>Lista de usarios</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Edad</th>
					<th>email</th> 
					<th>Cargo</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${lista_usuarios}" >
				<tr>
					<td><c:out value="${usario.id}" /> </td>
					<td><c:out value="${usuario.rut}" /> </td>
					<td><c:out value="${usuario.nombre}" /> </td>
					
					<td><c:out value="${usuario.apellido}" /> </td> 
					<td><c:out value="${usuario.edad}" /> </td>
					<td><c:out value="${usuario.email}" /> </td>
					<td><c:out value="${usuario.cargo}" /> </td>
					
					
					
					<td>
						<a href="/usuario/actualizar/${usuario.id}">EDITAR</a>
						
					
						 
						<form action="/usuario/eliminar2/${usuario.id}" method="POST">
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