<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modificar Paciente</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="encabezado.jsp"%>
	<div class="container mt-5">
		<h2>Modificar Paciente</h2>
		<form action="modificarPaciente.html" method="post">
			<input type="hidden" name="id" value="${paciente.id}">

			<div class="form-group">
				<label for="apellido">Apellido:</label> <input type="text"
					class="form-control" id="apellido" name="apellido"
					value="${paciente.apellido}" required>
			</div>
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" id="nombre" name="nombre"
					value="${paciente.nombre}" required>
			</div>
			<div class="form-group">
				<label for="correoElectronico">Correo Electrónico:</label> <input
					type="email" class="form-control" id="correoElectronico"
					name="correoElectronico" value="${paciente.correoElectronico}"
					required>
			</div>
			<div class="form-group">
				<label for="direccion">Dirección:</label> <input type="text"
					class="form-control" id="direccion" name="direccion"
					value="${paciente.direccion}" required>
			</div>
			<div class="form-group">
				<label for="fechaNacimiento">Fecha de Nacimiento:</label> <input
					type="date" class="form-control" id="fechaNacimiento"
					name="fechaNacimiento" value="${paciente.fechaNacimiento}" required>
			</div>
			<div class="form-group">
				<label for="localidad">Localidad:</label> <input type="text"
					class="form-control" id="localidad" name="localidad"
					value="${paciente.localidad}" required>
			</div>
			<div class="form-group">
				<label for="provincia">Provincia:</label> <input type="text"
					class="form-control" id="provincia" name="provincia"
					value="${paciente.provincia}" required>
			</div>
			<div class="form-group">
				<label for="telefono">Teléfono:</label> <input type="text"
					class="form-control" id="telefono" name="telefono"
					value="${paciente.telefono}" required>
			</div>
			<div class="form-group">
				<label for="dni">DNI:</label> <input type="text"
					class="form-control" id="dni" name="dni" value="${paciente.dni}"
					required>
			</div>
			<div class="form-group">
				<label for="estado">Estado:</label> <input type="text"
					class="form-control" id="estado" name="estado" value="true"
					readonly>
			</div>
			<button type="submit" class="btn btn-primary">Guardar
				Cambios</button>
		</form>
	</div>
</body>
</html>