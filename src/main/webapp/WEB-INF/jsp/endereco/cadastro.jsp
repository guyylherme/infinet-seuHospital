<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de endereço</title>

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
			<h2 class="mb-3">Cadastramento de endereço</h2>
			<form action="/endereco/incluir" method="POST">

				<div class="row">
					<div class="col">
						<label for="rua">Rua:</label>
						<input type="text" name="rua" required="required" class="form-control" placeholder="Insira a rua">
					</div>
					<div class="col">
						<label for="numero">Número:</label>
						<input type="number" name="numero" required="required" class="form-control" placeholder="Insira o número">
					</div>
				</div>
				
				<div class="row mt-2">
					<div class="col">
						<label for="estado">Estado:</label>
						<input type="text" name="estado" required="required" class="form-control" placeholder="Insira o estado">
					</div>
					<div class="col">
						<label for="pais">País:</label>
						<input type="text" name="pais" required="required" class="form-control" placeholder="Insira o País">
					</div>
					<div class="col">
						<label for="cep">CEP:</label>
						<input type="text" name="cep" required="required" class="form-control" placeholder="Insira o CEP">
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