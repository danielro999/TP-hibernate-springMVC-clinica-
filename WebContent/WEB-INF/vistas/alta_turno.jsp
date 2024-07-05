<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Alta de Turno</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: white;">
    <div class="container mt-5">
        <h2 class="mb-4">Alta de Turno</h2>
        <form action="altaTurno.html" method="post">
            <div class="form-group">
                <label for="Legajo">Médico:</label>
                <select class="form-control" id="Legajo" name="Legajo" required>
                    <c:forEach var="medico" items="${medicos}">
                        <option value="${medico.legajo}">${medico.nombre} ${medico.apellido}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="pacienteId">Paciente:</label>
                <select class="form-control" id="pacienteId" name="pacienteId" required>
                    <c:forEach var="paciente" items="${pacientes}">
                        <option value="${paciente.id}">${paciente.nombre} ${paciente.apellido}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="fecha">Fecha:</label>
                <input type="date" class="form-control" id="fecha" name="fecha" required/>
            </div>
            <div class="form-group">
                <label for="hora">Hora:</label>
                <input type="time" class="form-control" id="hora" name="hora"/>
            </div>
            <div class="form-group">
                <label for="observacion">Observación:</label>
                <input type="text" class="form-control" id="observacion" name="observacion"/>
            </div>
             <div class="form-group">
                <label for="estado">Estado:</label>
                <select class="form-control" id="estado" name="estado">
                    <option value="pendiente">Pendiente</option>
                    <option value="presente">Presente</option>
                    <option value="ausente">Ausente</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
