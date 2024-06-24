<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>aca va el titulo</title>
</head>

<body style="background-color: White; ">
	<h1>pagina de prueba clinica web</h1>

	<form action="listarMedicos.html" method="get">
	<button >listar Medicos</button>
	</form>
	<form action="cargaMedico.html" method="get">
	<button >alta Medicos</button>
	</form>
	
	<form action="redireccionar_pag3.html" method="get">
		<div>
		ingrese su usuario: 
			<input type="text" name="txtUsuario"> 
			
		</div>
		<div>
			ingrese clave: 
			<input type="text" name="txtPass"> 
		</div>
		<div>
			<input type="submit" value="redireccion a pagina 3" name="btnRedirigirUsuario">
		</div>
		
	</form>
</body>
</html>