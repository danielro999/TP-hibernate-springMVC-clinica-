<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Pacientes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container" style="background-color: white; width: 662px">
        <h2 class="mt-5">Lista de Pacientes</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Correo Electrónico</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Fecha de Nacimiento</th>
                    <th scope="col">Localidad</th>
                    <th scope="col">Provincia</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">DNI</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="paciente" items="${pacientes}">
                    <tr>
                        <td>${paciente.id}</td>
                        <td>${paciente.apellido}</td>
                        <td>${paciente.nombre}</td>
                        <td>${paciente.correoElectronico}</td>
                        <td>${paciente.direccion}</td>
                        <td>${paciente.estado}</td>
                        <td>${paciente.fechaNacimiento}</td>
                        <td>${paciente.localidad}</td>
                        <td>${paciente.provincia}</td>
                        <td>${paciente.telefono}</td>
                        <td>${paciente.dni}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>