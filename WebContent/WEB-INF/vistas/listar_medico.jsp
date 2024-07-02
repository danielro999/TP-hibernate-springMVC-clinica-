<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de Médicos</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
	
<script src="https://cdn.datatables.net/v/dt/jqc-1.12.4/datatables.min.js"></script>
<script defer src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
<script defer src="https://cdn.datatables.net/2.0.8/js/dataTables.bootstrap5.js"></script>

</head>
<body>
	<%@ include file="encabezado.jsp"%>
	<div class="container mt-5">
		<h2 class="mt-5">Lista de Médicos</h2>
		<table id="tableMedicos" class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Legajo</th>
					<th scope="col">Apellido</th>
					<th scope="col">Nombre</th>
					<th scope="col">Especialidad</th>
					<th scope="col">Teléfono</th>
					<th scope="col">Correo Electrónico</th>
					<th scope="col">Dirección</th>
					<th scope="col">Localidad</th>
					<th scope="col">Fecha de Nacimiento</th>
					<th scope="col">Sexo</th>
					<th scope="col">Estado</th>
					<th scope="col">Modificar</th>
					<th scope="col">Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="medico" items="${medicos}">
					<tr>
						<td>${medico.legajo}</td>
						<td>${medico.apellido}</td>
						<td>${medico.nombre}</td>
						<td>${medico.especialidad.getNombre()}</td>
						<td>${medico.telefono}</td>
						<td>${medico.correoElectronico}</td>
						<td>${medico.direccion}</td>
						<td>${medico.localidad}</td>
						<td>${medico.fechaNacimiento}</td>
						<td>${medico.sexo}</td>
						<td>${medico.estado}</td>
						<td>
							<ul class="list-inline m-0">
								<c:if test="${usuarioLogin.isEstado() && usuarioLogin.getId() != 0}">
									<li class="list-inline-item"><a
									href="irmodificarMedico.html?id=${medico.legajo}"
									class="btn btn-warning btn-sm">Modificar</a></li>
								</c:if>
							</ul>
						</td>
						<td>
							<ul class="list-inline m-0">
								<c:if test="${usuarioLogin.isEstado() && usuarioLogin.getId() != 0}">
									<li class="list-inline-item"><a
										href="eliminarMedico.html?id=${medico.legajo}"
										class="btn btn-danger btn-sm"
										onclick="return confirm('¿Estás seguro de que deseas eliminar este paciente?');">Eliminar</a>
									</li>
								</c:if>
							</ul>
						</td>
						<%-- <td>
							<ul class="list-inline m-0">
								<li class="list-inline-item"><a
									href="irmodificarMedico.html?id=${medico.legajo}"
									class="btn btn-warning btn-sm">Modificar</a></li>
								<li class="list-inline-item"><a
									href="eliminarMedico.html?id=${medico.legajo}"
									class="btn btn-danger btn-sm"
									onclick="return confirm('¿Estás seguro de que deseas eliminar este paciente?');">Eliminar</a>
								</li>
							</ul> 
						</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	$(document).ready( function () {
$('#tableMedicos').DataTable({
    "language":{
    	"sProcessing":     "Procesando...",
    	"sLengthMenu":     "Mostrar _MENU_ registros",
    	"sZeroRecords":    "No se encontraron resultados",
    	"sEmptyTable":     "Ningún dato disponible en esta tabla",
    	"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
    	"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
    	"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
    	"sInfoPostFix":    "",
    	"sSearch":         "Buscar:",
    	"sUrl":            "",
    	"sInfoThousands":  ",",
    	"sLoadingRecords": "Cargando...",
    	"oPaginate": {
    		"sFirst":    "Primero",
    		"sLast":     "Último",
    		"sNext":     "Siguiente",
    		"sPrevious": "Anterior"
    	},
    	"oAria": {
    		"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
    		"sSortDescending": ": Activar para ordenar la columna de manera descendente"
    	}}
    });
  });
</script>
</body>
</html>
