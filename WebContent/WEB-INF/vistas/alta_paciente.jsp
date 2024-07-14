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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="encabezado.jsp"%>
	<div class="container" style="width: 500px;">
		<h2 class="mt-5">Formulario Alta de Paciente</h2>

		<form action="altaPaciente.html" method="post">

			<div class="form-group">
				<label for="nombre">Nombre</label> <input type="text"
					class="form-control" id="nombre" name="nombre" required>
			</div>
			<div class="form-group">
				<label for="apellido">Apellido</label> <input type="text"
					class="form-control" id="apellido" name="apellido" required>
			</div>
			<div class="form-group">
				<label for="dni">DNI</label> <input type="text" class="form-control"
					id="dni" name="dni" required pattern="\d{7,8}">
			</div>
			<div class="form-group">
				<label for="telefono">Teléfono</label> <input type="text"
					class="form-control" id="telefono" name="telefono" required
					pattern="\d*">
			</div>
			<div class="form-group">
				<label for="direccion">Dirección</label> <input type="text"
					class="form-control" id="direccion" name="direccion" required>
			</div>
		    <div class="form-group">
                <label for="provincia">Provincia</label>
                <select class="form-control" id="provincia" name="provincia" required>
                    <option value="">Seleccione una provincia</option>
                    <option value="Buenos Aires">Buenos Aires</option>
                    <option value="Cordoba">Córdoba</option>
                    <option value="Santa Fe">Santa Fe</option>
                </select>
            </div>
            <div class="form-group">
                <label for="localidad">Localidad</label>
                <select class="form-control" id="localidad" name="localidad" required>
                    <option value="">Seleccione una localidad</option>
                </select>
            </div>	
			<div class="form-group">
				<label for="fechaNacimiento">Fecha de Nacimiento</label> <input
					type="date" class="form-control" id="fechaNacimiento"
					name="fechaNacimiento" required>
			</div>
			<div class="form-group">
				<label for="correoElectronico">Correo Electrónico</label> <input
					type="email" class="form-control" id="correoElectronico"
					name="correoElectronico" required>
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
	  <!-- Mensaje de éxito -->
    <div id="successMessage" class="alert alert-success" style="display:none;" role="alert">
        El paciente fue cargado con éxito
    </div>

    <!-- Modal de confirmación de alta -->
    <div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="successModalLabel">Confirmación</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    El paciente fue cargado con éxito
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            // Localidades por provincia
            const localidadesPorProvincia = {
                "Buenos Aires": ["La Plata", "Mar del Plata", "Bahía Blanca"],
                "Cordoba": ["Córdoba", "Villa Carlos Paz", "Río Cuarto"],
                "Santa Fe": ["Rosario", "Santa Fe", "Rafaela"]
            };

            // Cambiar localidades según la provincia seleccionada
            $('#provincia').change(function(){
                const provincia = $(this).val();
                const localidades = localidadesPorProvincia[provincia] || [];
                const localidadSelect = $('#localidad');
                localidadSelect.empty().append('<option value="">Seleccione una localidad</option>');
                localidades.forEach(localidad => {
                    localidadSelect.append(new Option(localidad, localidad));
                });
            });

            // Mostrar mensaje de éxito al enviar el formulario
            $('#altaPacienteForm').submit(function(event){
                event.preventDefault(); // Evita el envío real del formulario
                $('#successModal').modal('show');
                setTimeout(() => {
                    this.submit(); // Enviar el formulario después de mostrar el mensaje
                }, 1000);
            });
        });
    </script>
</body>
</html>