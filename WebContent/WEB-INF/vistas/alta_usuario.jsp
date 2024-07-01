<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Alta de Usuario</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: white;">
    <div class="container mt-5">
        <h2 class="mb-4">Alta de Usuario ${medico.nombre} ${medico.apellido}</h2>
        <form action="altaUsuario.html" method="post">
            <div class="form-group">
                <label for="nombre_usuario">Nombre de Usuario:</label>
                <input type="text" class="form-control" id="nombre_usuario" name="nombre_usuario" required>
            </div>
            <div class="form-group">
                <label for="contrasenia">Contraseña:</label>
                <input type="password" class="form-control" id="contrasenia" name="contrasenia" required>
            </div>
            <div class="form-group">
                <label>Estado:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="estado" id="estado1" value="1" required>
                    <label class="form-check-label" for="estado1">Activo</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="estado" id="estado0" value="0" required>
                    <label class="form-check-label" for="estado0">Inactivo</label>
                </div>
            </div>
            <div class="form-group">
                <label>Admin:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="admin" id="admin1" value="1" required>
                    <label class="form-check-label" for="admin1">Sí</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="admin" id="admin0" value="0" required>
                    <label class="form-check-label" for="admin0">No</label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
