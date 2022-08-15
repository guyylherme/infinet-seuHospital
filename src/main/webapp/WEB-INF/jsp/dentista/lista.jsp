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
		
			<h4>Classe: Dentista</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">C�digo</th>
						<th scope="col">Nome</th>
						<th scope="col">Status</th>
						<th scope="col">ValorHora</th>
						<th scope="col">Turno</th>
						<th scope="col">AtendeCrian�a</th>
						<th scope="col">Cirurgia</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Marcio</td>
						<td>Ativo</td>
						<td>25.0</td>
						<td>Di�rno</td>
						<td>Sim</td>
						<td>N�o</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Daniele</td>
						<td>Inativo</td>
						<td>28.0</td>
						<td>Noturno</td>
						<td>N�o</td>
						<td>Sim</td> 
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Janaina</td>
						<td>Ativo</td>
						<td>31.0</td>
						<td>Noturno</td>
						<td>Sim</td>
						<td>Sim</td> 
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
		$('.nav-item.dentista').addClass('active'); 
	</script>
</body>
</html>