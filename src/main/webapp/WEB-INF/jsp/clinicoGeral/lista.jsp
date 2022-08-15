<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seu Hospital</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>


	<jsp:include page="../menu.jsp" />


	<div class="container mb-5">
	
		<h2 class="mt-4">Infinet - Seu Hospital</h2>
 
		
		<div class="container-fluid pt-5 w-100 dentista">
		
			<h4>Classe: Clinico Geral</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">C�digo</th>
						<th scope="col">Nome</th>
						<th scope="col">Status</th>
						<th scope="col">ValorHora</th>
						<th scope="col">Turno</th>
						<th scope="col">Descri��o</th>
						<th scope="col">Diarista</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mateus</td>
						<td>Ativo</td>
						<td>28.0</td>
						<td>Di�rno</td>
						<td>Especialista em geral</td>
						<td>N�o</td>
					</tr>
					<tr>
						<th scope="row">1</th>
						<td>Jos�</td>
						<td>Inativo</td>
						<td>27.0</td>
						<td>Di�rno</td>
						<td>Especialista em geral familiar</td>
						<td>Sim</td> 
					</tr>
					<tr>
						<th scope="row">1</th>
						<td>Fernanda</td>
						<td>Ativo</td>
						<td>30.0</td>
						<td>Noturno</td>
						<td>Especialista em geral</td>
						<td>N�o</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		 
		
	</div>




	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
		
	<script> 
		$('.nav-item.clinicoGeral').addClass('active'); 
	</script>
</body>
</html>