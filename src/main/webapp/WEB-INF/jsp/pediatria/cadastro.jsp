<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pediatra</title>

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
			<h2 class="mb-3">Cadastramento de Pediatra</h2>
			<form action="/pediatra/incluir" method="POST">

				<jsp:include page="../especialidade/cadastro.jsp" />
				
				<div class="row mt-2">
					<div class="col">
						<label for="apenasBebes" >Apenas Bebês:</label>
						<select name="apenasBebes" class="form-control">
							<option value="true">Sim</option>
							<option selected value="false">Não</option>
						</select>
					</div>
					
					<div class="col">
						<label for="neonatologia" >Neonatalogia:</label>
						<select name="neonatologia" class="form-control">
							<option value="true">Sim</option>
							<option selected value="false">Não</option>
						</select>
					</div>
					
					<div class="col">
						<label for="cardiologia" >Cardiologia:</label>
						<select name="cardiologia" class="form-control">
							<option value="true">Sim</option>
							<option selected value="false">Não</option>
						</select>
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