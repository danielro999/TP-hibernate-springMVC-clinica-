<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modificar Turno</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body style="background-color: White;">
    <%@ include file="encabezado.jsp"%>
    <div class="container">
        <h2 class="mt-5">Modificar Turno</h2>
        <h3>Turno ID: ${turno.id}</h3>
        <form:form method="post" action="modificarTurno.html">
            <input type="hidden" name="id" value="${turno.id}"/>
            <div class="form-group">
                <label for="medico">Médico:</label>
                <select class="form-control" id="Legajo" name="Legajo" required>
                    <c:forEach var="medico" items="${medicos}">
                        <option value="${medico.legajo}" ${turno.medico.legajo == medico.legajo ? 'selected' : ''}>${medico.apellido}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="paciente">Paciente:</label>
                <select class="form-control" id="pacienteId" name="pacienteId" required>
                    <c:forEach var="paciente" items="${pacientes}">
                        <option value="${paciente.id}" ${turno.paciente.id == paciente.id ? 'selected' : ''}>${paciente.apellido}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="fecha">Fecha:</label>
                <input type="date" class="form-control" id="fecha" name="fecha" value="${turno.fecha}" required/>
            </div>
           <div class="form-group">
                <label for="hora">Hora: de 09 a 22 hs</label>
                <input type="number"  min="09" max="22" class="form-control" id="hora" name="hora" required/>
            </div>
            <div class="form-group">
                <label for="observacion">Observación:</label>
                <input type="text" class="form-control" id="observacion" name="observacion" value="${turno.observacion}" required/>
            </div>
            <div class="form-group">
                <label for="estado">Estado:</label>
                <select class="form-control" id="estado" name="estado" required>
                    <option value="Pendiente" ${turno.estado == 'Pendiente' ? 'selected' : ''}>Pendiente</option>
                    <option value="Presente" ${turno.estado == 'Presente' ? 'selected' : ''}>Presente</option>
                    <option value="Ausente" ${turno.estado == 'Ausente' ? 'selected' : ''}>Ausente</option>
                    <option value="Cancelado" ${turno.estado == 'Cancelado' ? 'selected' : ''}>Cancelado</option>
                    <option value="Eliminado" ${turno.estado == 'Eliminado' ? 'selected' : ''}>Eliminado</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Guardar cambios</button>
        </form:form>
    </div>
</body>
</html>