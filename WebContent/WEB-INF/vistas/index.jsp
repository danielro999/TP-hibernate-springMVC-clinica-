<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<title>Clinica</title>
</head>

<body style="background-color: White; ">
<%@ include file="encabezado.jsp" %>
	<h1>pagina de prueba clinica web</h1>

	<form action="listarMedicos.html" method="get">
	<button >listar Medicos</button>
	</form>
	<form action="cargaMedico.html" method="get">
	<button >alta Medicos</button>
	</form>
	<form action="CargaPaciente.html" method="get">
	<button >alta pacientes</button>
	</form>
	

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>