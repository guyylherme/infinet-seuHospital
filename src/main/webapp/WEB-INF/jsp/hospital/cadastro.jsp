<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de hospital</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>


	<jsp:include page="../menu.jsp" />


	<div class="container mb-5">

		<div class="container mt-3">
			<h2 class="mb-3">Cadastramento de hospital</h2>
			<form action="/hospital/incluir" method="POST">

				<div class="row">
					<div class="col">
						<label for="nome">Nome:</label>
						<input type="text" name="nome" class="form-control" placeholder="Insira o nome">
					</div>
					<div class="col">
						<label for="cnpj">CNPJ:</label>
						<input type="text" name="cnpj" class="form-control" placeholder="Insira o cnpj">
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col">
						<label for="endereco">Endereço:</label>
						<input type="text" name="pais" class="form-control" placeholder="Insira o endereço">
					</div>
					<div class="col">
						<label for="especialidades">Especialidades:</label>
						<input type="text" name="cep" class="form-control" placeholder="Insira as especialidades">
					</div>
				</div>
				
				<div class="row mt-2">
					<div class="col">
						<label for="descricao">Descricao:</label>
						<textarea name="descricao" class="form-control" placeholder="Insira a descrição"></textarea>
					</div>
 				</div>

				<button type="submit" class="btn btn-primary mt-4">Cadastrar</button>
			</form>
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
		$('.nav-item.home').addClass('active');
	</script>

</body>
</html>