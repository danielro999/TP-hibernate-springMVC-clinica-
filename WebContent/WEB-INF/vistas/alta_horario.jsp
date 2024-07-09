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
                 		
             <c:forEach var="hour" begin="9" end="22">
                    <tr>
                        <td>${hour}:00</td>
                        <td><input type="checkbox" name="lunes_${hour}" <c:if test="${not empty horarios['lunes_' + hour]}">checked</c:if><c:if test="${empty horarios['lunes_' + hour]}">checked</c:if>></td>
                        <td><input type="checkbox" name="martes_${hour}" <c:if test="${not empty horarios['martes_' + hour]}">checked</c:if> <c:if test="${empty horarios['martes_' + hour]}">checked</c:if>></td>
                        <td><input type="checkbox" name="miercoles_${hour}" <c:if test="${not empty horarios['miercoles_' + hour]}">checked</c:if> <c:if test="${empty horarios['miercoles_' + hour]}">checked</c:if>></td>
                        <td><input type="checkbox" name="jueves_${hour}" <c:if test="${not empty horarios['jueves_' + hour]}">checked</c:if> <c:if test="${empty horarios['jueves_' + hour]}">checked</c:if>></td>
                        <td><input type="checkbox" name="viernes_${hour}" <c:if test="${not empty horarios['viernes_' + hour]}">checked</c:if> <c:if test="${empty horarios['viernes_' + hour]}">checked</c:if>></td>
                        <td><input type="checkbox" name="sabado_${hour}" <c:if test="${not empty horarios['sabado_' + hour]}">checked</c:if> <c:if test="${empty horarios['sabado_' + hour]}">checked</c:if>></td>
                        <td><input type="checkbox" name="domingo_${hour}" <c:if test="${not empty horarios['domingo_' + hour]}">checked</c:if> <c:if test="${empty horarios['domingo_' + hour]}">checked</c:if>></td>
                    </tr>
                </c:forEach>
		               
            </tbody>
        </table>
        <br>
        <input type="submit" value="Guardar Horario">
    </form>
</body>
</html>
