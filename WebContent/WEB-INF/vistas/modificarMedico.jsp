<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modificar Médico</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body style="background-color: White;">
	<%@ include file="encabezado.jsp"%>
	<div class="container">
		<h2 class="mt-5">Modificar Médico</h2>
		<h3>Legajo numero: ${medico.legajo}</h3>
		<form action="modificarMedico.html" method="post">
        <div class="form-group">
                <input type="hidden" type="text"  id="legajo" name="legajo" value="${medico.legajo}" >
            </div> 
			<div class="form-group">
				<label for="nombre">Nombre</label> <input type="text"
					class="form-control" id="nombre" name="nombre" value="${medico.apellido}" required>
			</div>
			<div class="form-group">
				<label for="apellido">Apellido</label> <input type="text"
					class="form-control" id="apellido" name="apellido" value="${medico.nombre}" required>
			</div>
			<div class="form-group">
				<label>Sexo</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="sexo"
						id="sexoMasculino" value="M" ${medico.sexo == 'M' ? 'checked' : ''}> <label
						class="form-check-label" for="sexoMasculino">Masculino</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="sexo"
						id="sexoFemenino" value="F" ${medico.sexo == 'F' ? 'checked' : ''}> <label
						class="form-check-label" for="sexoFemenino">Femenino</label>
				</div>
			</div>
			<div class="form-group">
				<label for="correoElectronico">Correo Electrónico</label> <input
					type="email" class="form-control" id="correoElectronico"
					name="correoElectronico" value="${medico.correoElectronico}" required>
			</div>
			<div class="form-group">
				<label for="direccion">Dirección</label> <input type="text"
					class="form-control" id="direccion" name="direccion" value="${medico.direccion}" required>
			</div>
			<div class="form-group">
				<label for="localidad">Localidad</label> <input type="text"
					class="form-control" id="localidad" name="localidad" value="${medico.localidad}" required>
			</div>
			<div class="form-group">
				<label for="fechaNacimiento">Fecha de Nacimiento</label> <input
					type="date" class="form-control" id="fechaNacimiento"
					name="fechaNacimiento" value="${medico.fechaNacimiento}" required>
			</div>
			<div class="form-group">
				<label for="telefono">Teléfono</label> <input type="text"
					class="form-control" id="telefono" name="telefono" value="${medico.telefono}" required>
			</div>
			<div class="form-group">
				<label for="especialidad">Especialidad</label> <select
					class="form-control" id="especialidad" name="especialidad" required>
					<c:forEach var="especialidad" items="${especialidades}">
						<option value="${especialidad.nombre}"  ${medico.especialidad.nombre == especialidad.nombre ? 'selected' : ''} >${especialidad.nombre}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label>Estado</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="estado"
						id="estadoActivo" value="1"  ${medico.estado == "true" ? 'checked' : ''} > <label
						class="form-check-label" for="estadoActivo">Activo</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="estado"
						id="estadoInactivo" value="0"  ${medico.estado == "false" ? 'checked' : ''}> <label
						class="form-check-label" for="estadoInactivo">Inactivo</label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Guardar cambios</button>
		</form>
	</div>
</body>
</html>
