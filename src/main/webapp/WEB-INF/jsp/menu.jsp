<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">

		<a class="navbar-brand" href="/">Seu Hospital</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="  navbar-nav">
				<li class="nav-item home"><a class="nav-link" href="/">Home</a></li>
				
				<c:if test="${not empty user}">				
					<li class="nav-item cliente"><a class="nav-link" href="/cliente/lista">Cliente</a></li>	
					<li class="nav-item hospital"><a class="nav-link" href="/hospital/lista">Hospital</a></li>				
					<li class="nav-item endereco"><a class="nav-link" href="/endereco/lista">Endereço</a></li>				
					<li class="nav-item especialidade"><a class="nav-link" href="/especialidade/lista">Especialidade</a></li>
					<li class="nav-item dentista"><a class="nav-link" href="/dentista/lista">Dentista</a></li>
					<li class="nav-item clinicoGeral"><a class="nav-link" href="/clinicoGeral/lista">Clinico Geral</a></li>
					<li class="nav-item pediatria"><a class="nav-link" href="/pediatra/lista">Pediatria</a></li>							
				</c:if>				
			</ul>
			
			<ul class="navbar-nav navbar-right">
				
				<c:if test="${empty user}"> 
					<li class="nav-item signup"><a class="nav-link" href="/cliente"><span class="glyphicon glyphicon-user"></span> Sign up</a></li>
					<li class="nav-item login"><a class="nav-link" href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>	
				
				<c:if test="${not empty user}"> 
					<li class="nav-item logout"><a class="nav-link" href="/logout">Logout, ${user.nome}</a></li>
				</c:if>	
			</ul>
		</div>

	</div>
</nav>