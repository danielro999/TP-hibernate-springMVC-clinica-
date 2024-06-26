<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Alta de Paciente</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<h2>Formulario Alta de Paciente</h2>
	<%@ include file="encabezado.jsp"%>

	<form action="altaPaciente.html" method="post">

		<label for="nombre">Nombre:</label> <input type="text" id="nombre"
			name="nombre" required><br>
		<br>
		<c:if test="${not empty errors['nombre']}">
			<div style="color: red">${errors['nombre'].defaultMessage}</div>
		</c:if>

		<label for="apellido">Apellido:</label> <input type="text"
			id="apellido" name="apellido" required><br>
		<br>
		<c:if test="${not empty errors['apellido']}">
			<div style="color: red">${errors['apellido'].defaultMessage}</div>
		</c:if>

		<label for="dni">DNI:</label> <input type="text" id="dni" name="dni"
			required pattern="\d{7,8}">
		<c:if test="${not empty errors['dni']}">
			<div style="color: red">${errors['dni'].defaultMessage}</div>
		</c:if>
		<br>
		<br> <label for="telefono">Teléfono:</label> <input type="text"
			id="telefono" name="telefono" pattern="\d*">
		<c:if test="${not empty errors['telefono']}">
			<div style="color: red">${errors['telefono'].defaultMessage}</div>
		</c:if>
		<br>
		<br> <label for="direccion">Dirección:</label> <input type="text"
			id="direccion" name="direccion"><br>
		<br> <label for="localidad">Localidad:</label> <input type="text"
			id="localidad" name="localidad"><br>
		<br> <label for="provincia">Provincia:</label> <input type="text"
			id="provincia" name="provincia"><br>
		<br> <label for="fechaNacimiento">Fecha de Nacimiento
			(DD/MM/YYYY):</label> <input type="text" id="fechaNacimiento"
			name="fechaNacimiento" pattern="\d{2}/\d{2}/\d{4}">
		<c:if test="${not empty errors['fechaNacimiento']}">
			<div style="color: red">${errors['fechaNacimiento'].defaultMessage}</div>
		</c:if>
		<br>
		<br> <label for="correoElectronico">Correo Electrónico:</label> <input
			type="email" id="correoElectronico" name="correoElectronico">
		<c:if test="${not empty errors['correoElectronico']}">
			<div style="color: red">${errors['correoElectronico'].defaultMessage}</div>
		</c:if>
		<br>
		<br> <label for="estado">Estado:</label> <select id="estado"
			name="estado">
			<option value="true">Activo</option>
			<option value="false">Inactivo</option>
		</select><br>
		<br> <input type="submit" value="Guardar">



	</form>

</body>
</html>