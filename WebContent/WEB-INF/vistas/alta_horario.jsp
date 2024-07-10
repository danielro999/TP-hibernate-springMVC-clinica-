<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>
	<h3>Legajo numero: ${medico.legajo}</h3>
    <h2>Alta de Horario de Trabajo</h2>

    <form action="altaHorarios.html" method="post">
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
                        <td><input type="checkbox" name="lunes_${hour}" <c:if test="${horarios.get(status.count-1).isLunes()}">checked</c:if>></td>
                        <td><input type="checkbox" name="martes_${hour}" <c:if test="${horarios.get(status.count-1).isMartes()}">checked</c:if>></td>
                        <td><input type="checkbox" name="miercoles_${hour}" <c:if test="${horarios.get(status.count-1).isMiercoles()}">checked</c:if>></td>
                        <td><input type="checkbox" name="jueves_${hour}" <c:if test="${horarios.get(status.count-1).isJueves()}">checked</c:if>></td>
                        <td><input type="checkbox" name="viernes_${hour}" <c:if test="${horarios.get(status.count-1).isViernes()}">checked</c:if>></td>
                        <td><input type="checkbox" name="sabado_${hour}" <c:if test="${horarios.get(status.count-1).isSabado()}">checked</c:if>></td>
                        <td><input type="checkbox" name="domingo_${hour}" <c:if test="${horarios.get(status.count-1).isDomingo()}">checked</c:if>></td>
                    </tr>
          	   </c:forEach>
		               
            </tbody>
        </table>
        <br>
        <input type="submit" value="Guardar Horario">
    </form>
</body>
</html>
