<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Médicos</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%@ include file="encabezado.jsp" %>
    <div class="container">
        <h2 class="mt-5">Lista de Médicos</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Legajo</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Correo Electrónico</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Fecha de Nacimiento</th>
                    <th scope="col">Localidad</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">Especialidad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="medico" items="${medicos}">
                    <tr>
                        <td>${medico.legajo}</td>
                        <td>${medico.apellido}</td>
                        <td>${medico.nombre}</td>
                        <td>${medico.correoElectronico}</td>
                        <td>${medico.direccion}</td>
                        <td>${medico.estado}</td>
                        <td>${medico.fechaNacimiento}</td>
                        <td>${medico.localidad}</td>
                        <td>${medico.sexo}</td>
                        <td>${medico.telefono}</td>
                        <td>${medico.especialidad.getNombre()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
