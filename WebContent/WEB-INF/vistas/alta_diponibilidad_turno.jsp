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
	<%@ include file="encabezado.jsp"%>
    <div class="container mt-5" style="width: 500px;" >
       
       <h5>Medico legajo: ${medico.legajo}</h5> 
       <h5 class="mb-4">Nombre medico: ${medico.nombre} ${medico.apellido}</h5>
        <h5>Paciente numero: ${paciente.id}</h5> 
        <h5 class="mb-4">nombre: ${paciente.nombre} ${paciente.apellido}</h5>
 		<h5 class="mb-4">fecha: ${fecha}</h5> 
       
        <form action="altaTurno.html" method="post">
        
       <input type="hidden" name="Legajo" value="${medico.legajo}" >
        <input type="hidden"  name="pacienteId" value="${paciente.id}" >
 		<input type="hidden"  name="fecha" value="${fecha}" >
                             
            <select class="form-control" id="hora" name="hora">
	            <c:forEach var="hour" begin="9" end="22" varStatus="status">
					
					<c:if test="${ListaHorarios.get(status.count-1)}">
					<option value="${hour}">${hour}hs</option>
					</c:if>
					
				</c:forEach>
            </select> 
            
            <div class="form-group">
                <label for="observacion">Observación:</label>
                <input type="text" class="form-control" id="observacion" name="observacion"/>
            </div>
             <div class="form-group">
                <label for="estado">Estado:</label>
                <select class="form-control" id="estado" name="estado" required>
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