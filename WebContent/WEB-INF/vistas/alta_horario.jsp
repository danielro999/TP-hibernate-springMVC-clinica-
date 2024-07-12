<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Alta de Horario de Trabajo</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

.checkbox-container {
	display: flex;
	flex-direction: column;
}
</style>
  <script>
        function gatherCheckboxes() {
            var horarios = [];
          /*   var dias = ["lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"];
            for (var i = 0; i < dias.length; i++) {
                for (var hour = 9; hour <= 22; hour++) {
                    var checkbox = document.getElementsByName(dias[i] + hour)[0];
                    horarios.push(checkbox.checked ? "0" : "1");
                }
             } */
             for (var hour = 9; hour <= 22; hour++) {
            	 horarios.push(document.getElementsByName("lunes" + hour)[0].checked ? "0" : "1");
            	 horarios.push(document.getElementsByName("martes" + hour)[0].checked ? "0" : "1");
            	 horarios.push(document.getElementsByName("miercoles" + hour)[0].checked ? "0" : "1");
            	 horarios.push(document.getElementsByName("jueves" + hour)[0].checked ? "0" : "1");
            	 horarios.push(document.getElementsByName("viernes" + hour)[0].checked ? "0" : "1");
            	 horarios.push(document.getElementsByName("sabado" + hour)[0].checked ? "0" : "1");
            	 horarios.push(document.getElementsByName("domingo" + hour)[0].checked ? "0" : "1");
             }
             
            document.getElementById("horarios").value = horarios.join(",");
      		console.log( document.getElementById("horarios").value);

            return true;
        }
    </script>
</head>
<body>
	<h3>Legajo numero: ${medico.legajo}</h3>
	<h2>Alta de Horario de Trabajo</h2>


	<form id="horarioForm" action="altaHorarios.html" method="post" onsubmit="return gatherCheckboxes();">
		<table>
			<thead>
				<tr>
					<th>Hora</th>
					<th>Lunes</th>
					<th>Martes</th>
					<th>Miércoles</th>
					<th>Jueves</th>
					<th>Viernes</th>
					<th>Sábado</th>
					<th>Domingo</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="hour" begin="9" end="22" varStatus="status">
					<tr>
						<td>${hour}:00</td>
						<td><input type="radio" name="lunes${String.valueOf(hour)}"
							value="0" checked> <input type="radio"
							name="lunes${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isLunes()}">checked</c:if>>
						</td>
						<td><input type="radio" name="martes${String.valueOf(hour)}"
							value="0" checked> <input type="radio"
							name="martes${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isMartes()}">checked</c:if>>
						</td>
						<td><input type="radio"
							name="miercoles${String.valueOf(hour)}" value="0" checked>
							<input type="radio" name="miercoles${String.valueOf(hour)}"
							value="1"
							<c:if test="${horarios.get(status.count-1).isMiercoles()}">checked</c:if>>
						</td>
						<td><input type="radio" name="jueves${String.valueOf(hour)}"
							value="0" checked> <input type="radio"
							name="jueves${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isJueves()}">checked</c:if>>
						</td>
						<td><input type="radio" name="viernes${String.valueOf(hour)}"
							value="0" checked> <input type="radio"
							name="viernes${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isViernes()}">checked</c:if>>
						</td>
						<td><input type="radio" name="sabado${String.valueOf(hour)}"
							value="0" checked> <input type="radio"
							name="sabado${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isSabado()}">checked</c:if>>
						</td>
						<td><input type="radio" name="domingo${String.valueOf(hour)}"
							value="0" checked> <input type="radio"
							name="domingo${String.valueOf(hour)}" value="1"
							<c:if test="${horarios.get(status.count-1).isDomingo()}">checked</c:if>>
						</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		<br>
		<input type="submit" value="Guardar Horario">
		<input type="hidden" id="legajo" name="legajo" value="${medico.legajo}">
		<input type="hidden" name="horarios" id="horarios"/> 
	</form>
<%-- 					<%
	
		List<String> listaHorasTrabajo = new ArrayList<String>();
		for (int i = 9; i < 23; i++) {
			listaHorasTrabajo.add(request.getParameter("lunes" + i));
			listaHorasTrabajo.add(request.getParameter("martes" + i));
			listaHorasTrabajo.add(request.getParameter("miercoles" + i));
			listaHorasTrabajo.add(request.getParameter("jueves" + i));
			listaHorasTrabajo.add(request.getParameter("viernes" + i));
			listaHorasTrabajo.add(request.getParameter("sabado" + i));
			listaHorasTrabajo.add(request.getParameter("domingo" + i));
		}
		
		//request.setAttribute("horarios", listaHorasTrabajo);
		System.out.println(listaHorasTrabajo );

	 	StringBuilder horariosStr = new StringBuilder();
		for (String horario : listaHorasTrabajo) {
			horariosStr.append(horario + ",");
		}
		// Remove the last comma
		if (horariosStr.length() > 0) {
			horariosStr.setLength(horariosStr.length() - 1);
		}
		 out.println(horariosStr); 
		  
	%>
		<script>

   		document.getElementById("horarios").value = "<%=horariosStr.toString()%>";
   		console.log(document.getElementById("horarios").value)
	//	document.getElementById("horarioForm").submit();	
	</script> --%>
</body>


</html>
