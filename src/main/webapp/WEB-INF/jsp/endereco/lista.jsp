<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					 
			<div class="row">
				<div class="col-6 text-left"><h4>Endereços</h4></div>
				<div class="col-6 text-right"><h4><a href="/endereco/incluir">Novo endereço</a></h4></div>
			</div>
		
			<table class="table table-hover">
				<thead>
					<tr> 
						<th scope="col">ID</th>
						<th scope="col">Rua</th>
						<th scope="col">Numero</th>
						<th scope="col">Estado</th>
						<th scope="col">País</th>
						<th scope="col">CEP</th> 
						<th scope="col"></th> 
					</tr>
				</thead>
				
				<tbody>
					
					<c:forEach var="endereco" items="${ listagem }">

						<tr>
							<th>#${endereco.id}</th>
							<td>${endereco.rua}</td>
							<td>${endereco.numero}</td>
							<td>${endereco.estado}</td>
							<td>${endereco.pais}</td>
							<td>${endereco.cep}</td> 
							<td><a href="/endereco/${endereco.id}/excluir">excluir</a></td>
						</tr>

					</c:forEach>

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
		$('.nav-item.endereco').addClass('active'); 
	</script>
</body>
</html>