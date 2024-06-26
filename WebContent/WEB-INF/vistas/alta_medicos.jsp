<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alta de Médico</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body style="background-color: White;">
	<%@ include file="encabezado.jsp"%>
	<div class="container">
		<h2 class="mt-5">Alta de Médico</h2>
		<form action="altaMedico.html" method="post">
			<!-- <div class="form-group">
                <label for="legajo">Legajo</label>
                <input type="text" class="form-control" id="legajo" name="legajo" required>
            </div> -->
			<div class="form-group">
				<label for="apellido">Apellido</label> <input type="text"
					class="form-control" id="apellido" name="apellido" required>
			</div>
			<div class="form-group">
				<label for="nombre">Nombre</label> <input type="text"
					class="form-control" id="nombre" name="nombre" required>
			</div>
			<div class="form-group">
				<label>Sexo</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="sexo"
						id="sexoMasculino" value="M" required> <label
						class="form-check-label" for="sexoMasculino">Masculino</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="sexo"
						id="sexoFemenino" value="F" required> <label
						class="form-check-label" for="sexoFemenino">Femenino</label>
				</div>
			</div>
			<div class="form-group">
				<label for="correoElectronico">Correo Electrónico</label> <input
					type="email" class="form-control" id="correoElectronico"
					name="correoElectronico" required>
			</div>
			<div class="form-group">
				<label for="direccion">Dirección</label> <input type="text"
					class="form-control" id="direccion" name="direccion" required>
			</div>
			<div class="form-group">
				<label for="fechaNacimiento">Fecha de Nacimiento</label> <input
					type="date" class="form-control" id="fechaNacimiento"
					name="fechaNacimiento" required>
			</div>
			<div class="form-group">
				<label for="localidad">Localidad</label> <input type="text"
					class="form-control" id="localidad" name="localidad" required>
			</div>

			<div class="form-group">
				<label for="telefono">Teléfono</label> <input type="text"
					class="form-control" id="telefono" name="telefono" required>
			</div>
			<div class="form-group">
				<label for="especialidad">Especialidad</label> <select
					class="form-control" id="especialidad" name="especialidad" required>
					<c:forEach var="especialidad" items="${especialidades}">
						<option value="${especialidad.nombre}">${especialidad.nombre}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label>Estado</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="estado"
						id="estadoActivo" value="1" required> <label
						class="form-check-label" for="estadoActivo">Activo</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="estado"
						id="estadoInactivo" value="0" required> <label
						class="form-check-label" for="estadoInactivo">Inactivo</label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Dar de Alta</button>
		</form>
	</div>
</body>
</html>
