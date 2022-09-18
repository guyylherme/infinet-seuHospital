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
				<div class="col-6 text-left"><h4>Clínicos gerais</h4></div>
				<div class="col-6 text-right"><h4><a href="/clinicoGeral/incluir">Novo clínico geral</a></h4></div>
			</div>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th> 
						<th scope="col">Nome</th>
						<th scope="col">Status</th>
						<th scope="col">Valor Hora</th>
						<th scope="col">Turno</th>
						<th scope="col">Descrição</th>
						<th scope="col">Diarista</th>
						<th scope="col"></th>
					</tr>
				</thead>
				
				<tbody>
				
					<c:forEach var="clinicoGeral" items="${ listagem }">
				
						<tr>
							<th>#${clinicoGeral.id}</th> 
							<td>${clinicoGeral.nome}</td>
							<td>${clinicoGeral.status}</td>
							<td>R$ ${clinicoGeral.valorHora}</td>
							<td>${clinicoGeral.turno}</td>
							<td>${clinicoGeral.descricao}</td>
							<td>${clinicoGeral.diarista}</td>
							<td><a href="/clinicoGeral/${clinicoGeral.id}/excluir">excluir</a></td>
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
		$('.nav-item.clinicoGeral').addClass('active'); 
	</script>
</body>
</html>