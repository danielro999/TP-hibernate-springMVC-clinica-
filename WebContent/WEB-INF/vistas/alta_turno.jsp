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
                <label for="fecha">Dia:  <b id="dia"></b></label>
                <input type="date" class="form-control" id="fecha" name="fecha" onchange="handler(event);" required/>
            </div>
           <!--  <div class="form-group">
                <label for="hora">Hora: de 09 a 22 hs</label>
                <input type="number"  min="09" max="22" class="form-control" id="hora" name="hora" required/>
            </div> -->
            <select class="form-control" id="hora" name="hora">
	            <c:forEach var="horarioMedico" items="${medicos.get(0).listaHorarioTrabajo}">
					<option value="">${horarioMedico.lunes}</option>
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
    <script>
	  // obtener dia actual y formatrarlo para que sea el minimo dia en el input
	  const date  = new Date();
	  let day = date.getDate();
	  let month = date.getMonth()+1;
	  let year = date.getFullYear();
	  const formattedDate = year +"-"+ String(month).padStart(2, '0')+"-"+ String(day).padStart(2, '0'); 

	  //console.log(formattedDate); // "17-06-2022"
	  document.getElementById("fecha").setAttribute("min", formattedDate);
	  
	  
	  // para imprimir tag de la fecha el dia seleccionado
	  const days = [ "lunes", "martes", "miercoles", "jueves", "viernes", "sabado","domingo"];
	//  const days = ["domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"];
	  var diaSemanaNegrita= document.getElementById("dia"); 
	  function handler(e){
		 // alert(e.target.value);
		  const dateStr = e.target.value;
		  const date = new Date(dateStr);
		  let diaSemana = days[date.getDay()];
	  	  diaSemanaNegrita.innerText = diaSemana;
	  	  console.log(document.getElementById("Legajo").value);
	      console.log(diaSemana);
	  	  
		}
		  
	  
	  
	</script>
    
</body>
</html>
