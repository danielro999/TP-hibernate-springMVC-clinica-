<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="encabezado.jsp" %>
	<div class="container">
        <div class="row justify-content-center">
        	<h2>${usuario}</h2>
            <div class="col-md-6">
                <h2 class="text-center mt-5">Login</h2>
                <form action="redireccionar_pag3.html" method="get">
                    <div class="form-group">
                        <label for="username">Nombre Usuario:</label>
                        <input type="text" class="form-control" id="username" name="txtUsuario" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="txtPass" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block" value="redireccion a pagina 3" name="btnRedirigirUsuario">Login</button>
                </form>
                <div class="text-center mt-3">
                    <span id="error-message" class="text-danger"></span>
                </div>
            </div>
        </div>
    </div>
	
</body>
</html>