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


	<%@ include file="menu.jsp"%>


	<div class="container mb-5">
		<h1 class="kcerl8-0 sc-1ji2fn-0 kVdZZm title mt-5">${projeto.nome}</h1>
		<h6 class="mb-5">${projeto.descricao}</h6>

		<c:forEach var="c" items="${projeto.classes}">
			<h4>Classe: ${c.nome}</h4>
			<table class="table table-hover mt-0">
				<thead>
					<tr>
						<th scope="col">Atributo</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descrição</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="a" items="${c.atributos}">
						<tr> 
							<td>${a.nome}</td>
							<td>${a.tipo}</td>
							<td>${a.descricao}</td>
						</tr>
					</c:forEach> 
				</tbody>

			</table>
		</c:forEach>

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
		$('.nav-item.home').addClass('active');
	</script>

</body>
</html>