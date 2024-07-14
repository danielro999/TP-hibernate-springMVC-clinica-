<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Alta de Horario de Trabajo</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<script>
	function gatherCheckboxes() {
		var horarios = [];

		for (var hour = 9; hour <= 22; hour++) {
			horarios
					.push(document.getElementsByName("lunes" + hour)[0].checked ? "1"
							: "0");
			horarios
					.push(document.getElementsByName("martes" + hour)[0].checked ? "1"
							: "0");
			horarios
					.push(document.getElementsByName("miercoles" + hour)[0].checked ? "1"
							: "o");
			horarios
					.push(document.getElementsByName("jueves" + hour)[0].checked ? "1"
							: "0");
			horarios
					.push(document.getElementsByName("viernes" + hour)[0].checked ? "1"
							: "0");
			horarios
					.push(document.getElementsByName("sabado" + hour)[0].checked ? "1"
							: "0");
			horarios
					.push(document.getElementsByName("domingo" + hour)[0].checked ? "1"
							: "0");
		}

		document.getElementById("horarios").value = horarios.join(",");
		//window.alert(document.getElementById("horarios").value);

		return true;
	}
</script>
</head>
<body>
	<%@ include file="encabezado.jsp"%>
	<div class="container" style="width: 700px;">
	<p class="h3">Alta de Horario de Trabajo</p>
	<p class="h5">Legajo: ${medico.legajo}</p>
	<p class="h5">Nombre: ${medico.nombre} ${medico.apellido}</p>
	<form id="horarioForm"  class="table table-striped" action="altaHorarios.html" method="post"
		onsubmit="return gatherCheckboxes();">
		<table>
			<thead>
				<tr>
					<th scope="col">Hora</th>
					<th scope="col">Lunes</th>
					<th scope="col">Martes</th>
					<th scope="col">Miércoles</th>
					<th scope="col">Jueves</th>
					<th scope="col">Viernes</th>
					<th scope="col">Sábado</th>
					<th scope="col">Domingo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hour" begin="9" end="22" varStatus="status">
					<tr>
						<td>${hour}:00</td>
						<td>
							<input type="checkbox" class="form-control" 
							name="lunes${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isLunes()}">checked</c:if>>
						</td>
						<td>
							<input type="checkbox" class="form-control" 
							name="martes${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isMartes()}">checked</c:if>>
						</td>
						<td>
							<input type="checkbox" class="form-control"  name="miercoles${String.valueOf(hour)}"
							value="1"
							<c:if test="${horarios.get(status.count-1).isMiercoles()}">checked</c:if>>
						</td>
						<td>
							<input type="checkbox" class="form-control" 
							name="jueves${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isJueves()}">checked</c:if>>
						</td>
						<td>
							<input type="checkbox" class="form-control" 
							name="viernes${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isViernes()}">checked</c:if>>
						</td>
						<td>
							<input type="checkbox" class="form-control" 
							name="sabado${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isSabado()}">checked</c:if>>
						</td>
						<td>
							<input type="checkbox" class="form-control" 
							name="domingo${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isDomingo()}">checked</c:if>>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <input type="submit" class="btn btn-primary" value="Guardar Horario"> <input
			type="hidden" id="legajo" name="legajo" value="${medico.legajo}">
		<input type="hidden"  name="horarios" id="horarios" />
	</form>
	</div>
</body>
</html>
