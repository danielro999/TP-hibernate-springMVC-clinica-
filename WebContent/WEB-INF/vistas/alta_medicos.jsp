<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alta de Médico</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body style="background-color: White; ">
    <div class="container">
        <h2 class="mt-5">Alta de Médico</h2>
        <form action="altaMedico.html" method="post">
            <!-- <div class="form-group">
                <label for="legajo">Legajo</label>
                <input type="text" class="form-control" id="legajo" name="legajo" required>
            </div> -->
            <div class="form-group">
                <label for="apellido">Apellido</label>
                <input type="text" class="form-control" id="apellido" name="apellido" required>
            </div>
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="correoElectronico">Correo Electrónico</label>
                <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" required>
            </div>
            <div class="form-group">
                <label for="direccion">Dirección</label>
                <input type="text" class="form-control" id="direccion" name="direccion" required>
            </div>
            <div class="form-group">
               <!--  <label for="estado">Estado</label> -->
                   <p for="estado">Estado</p>
					  <input class="form-control" type="radio" id="estado" name="estado" value="1">
					  <label for="child">activo</label><br>
					  
					  <input class="form-control" type="radio" id="estado" name="estado" value="0">
					  <label for="adult">desactivo</label><br>
  
               <!--  <input type="number" class="form-control" id="estado" name="estado" required> -->
            </div>
            <div class="form-group">
                <label for="fechaNacimiento">Fecha de Nacimiento</label>
                <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
            </div>
            <div class="form-group">
                <label for="localidad">Localidad</label>
                <input type="text" class="form-control" id="localidad" name="localidad" required>
            </div>
            <div class="form-group">
                <label for="sexo">Sexo</label>
                <input type="text" class="form-control" id="sexo" name="sexo" required>
            </div>
            <div class="form-group">
                <label for="telefono">Teléfono</label>
                <input type="text" class="form-control" id="telefono" name="telefono" required>
            </div>
            <div class="form-group">
                <label for="especialidad">Especialidad</label>
                <input type="text" class="form-control" id="especialidad" name="especialidad" required>
            </div>
            <button type="submit" class="btn btn-primary">Dar de Alta</button>
        </form>
    </div>
</body>
</html>
