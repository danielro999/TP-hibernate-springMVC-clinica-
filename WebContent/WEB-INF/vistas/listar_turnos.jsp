<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Clinica</title>
</head>
<body>
	<%@ include file="encabezado.jsp"%>
	<div class="container" style="background-color: white; width: 662px">
		<h2 class="mt-5">Lista de Turnos</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Estado</th>
					<th scope="col">Fecha</th>
					<th scope="col">Hora</th>
					<th scope="col">Observacion</th>
					<th scope="col">Medico</th>
					<th scope="col">Paciente</th>
					<th scope="col">Modificar</th>
					<th scope="col">Eliminar</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="turno" items="${turnos}">
					<tr>
						<td>${turno.id}</td>
						<td>${turno.estado}</td>
						<td>${turno.fecha}</td>
						<td>${turno.hora}hs</td>
						<td>${turno.observacion}</td>
						<td>${turno.medico.getApellido()}</td>
						<td>${turno.paciente.getApellido()}</td>
						<td><a href="irmodificarTurno.html?id=${turno.id}"
							class="btn btn-warning btn-sm">Modificar</a></td>
						<td><a href="eliminarTurno.html?id=${turno.id}"
							class="btn btn-danger btn-sm"
							onclick="return confirm('¿Estás seguro de que deseas eliminar este paciente?');">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
