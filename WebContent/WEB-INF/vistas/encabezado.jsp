<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="paginaIndex.html">Clinica</a> <a
		class="navbar-brand" href="listarMedicos.html">Medicos</a> <a
		class="navbar-brand" href="listarPaciente.html">Pacientes</a> <a
		class="navbar-brand" href="ListarTurnos.html">Turnos</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<c:if test="${usuarioLogin.isAdmin() || usuarioLogin.isEstado()}">
				<li class="nav-item"><a class="nav-link"
					href="paginaLoginSalir.html">Salir</a>
			</c:if>
			<c:if test="${!usuarioLogin.isEstado()}">
				<li class="nav-item"><a class="nav-link"
					href="paginaLogin.html">Login</a>
			</c:if>
			<li class="nav-item"><span class="nav-link"><strong>${usuarioLogin.getNombreUsuario()}</strong></span>
			</li>
			<c:if test="${usuarioLogin.isAdmin()}">
				<li class="nav-item"><span class="nav-link"><strong>ADMIN</strong></span>
			</c:if>
			<c:if test="${usuarioLogin.isEstado() && !usuarioLogin.isAdmin() }">
				<li class="nav-item"><span class="nav-link"><strong>Usuario</strong></span>
			</c:if>
			<c:if test="${!usuarioLogin.isEstado()}">
				<li class="nav-item"><span class="nav-link"><strong>Loguearse</strong></span>
			</c:if>
		</ul>
	</div>
</nav>