<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Alta de Médico</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: white;">
    <div class="container mt-5">
        <h2 class="mb-4">Alta de Médico</h2>
        <form id="altaMedicoForm" action="altaMedico.html" method="post">
           <div class="form-group">
				<label for="nombre">Nombre</label> <input type="text"
					class="form-control" id="nombre" name="nombre" required>
			</div>
			<div class="form-group">
				<label for="apellido">Apellido</label> <input type="text"
					class="form-control" id="apellido" name="apellido" required>
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
            <button type="button" class="btn btn-primary" onclick="validateForm()">Dar de Alta</button>
        </form>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Confirmar Alta</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    ¿Qué deseas hacer?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="submitForm('altaMedicoForm')">Guardar</button>
                    <button type="button" class="btn btn-success" onclick="submitFormUser('altaMedicoForm')">Crear Usuario</button>
                </div>
            </div>
        </div>
    </div>

    <script>
    function validateForm() {
        var isValid = true;
        var elements = document.getElementById('altaMedicoForm').elements;
        for (var i = 0; i < elements.length; i++) {
            if (elements[i].hasAttribute('required') && !elements[i].value) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            $('#confirmModal').modal('show');
        } else {
            alert('Por favor complete todos los campos requeridos.');
        }
        return false;
    }

    function submitFormUser(formId) {
        form = document.getElementById(formId);
        form.setAttribute('action', 'irAltaUsuario.html');
        form.submit();
    }
    function submitForm(formId) {
        document.getElementById(formId).submit();
    }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
