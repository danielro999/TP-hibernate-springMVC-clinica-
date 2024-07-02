
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java"%> --%>
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


	<div class="container mt-5">
		<h1 class="mb-4">Página de Prueba Clínica Web</h1>
		<div class="row">
			<div class="col-md-4 mb-3">
				<a href="cargaMedico.html" class="btn btn-primary btn-block">Alta
					Médicos</a>
			</div>
			<div class="col-md-4 mb-3">
				<a href="CargaPaciente.html" class="btn btn-primary btn-block">Alta
					Pacientes</a>
			</div>
			<div class="col-md-4 mb-3">
				<form action="cargaTurno.html" method="post">
					<button type="submit" class="btn btn-primary btn-block">Alta turno</button>
					<div class="form-group">
						<label for="especialidad">Especialidad:</label> <select
							class="form-control" id="especialidad" name="especialidad">
							<c:forEach var="especialidad" items="${especialidades}">
								<option value="${especialidad.id}">${especialidad.nombre}</option>
							</c:forEach>
						</select>
					</div>
					<!-- Otros campos del formulario -->
				</form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
