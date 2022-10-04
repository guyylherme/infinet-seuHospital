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

 <style>
	select{
	    height: 35px !important;
    }
</style>

<body>

	<jsp:include page="../menu.jsp" />


	<div class="container mb-5">

		<div class="container mt-3">
			<h2 class="mb-3">Cadastramento de hospital</h2>
			<form action="/hospital/incluir" method="POST">

				<div class="row">
					<div class="col">
						<label for="nome">Nome:</label>
						<input type="text" name="nome" class="form-control" required="required" placeholder="Insira o nome">
					</div>
					<div class="col">
						<label for="cnpj">CNPJ:</label>
						<input type="text" name="cnpj" class="form-control" required="required" placeholder="Insira o cnpj">
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col">
						<label for="endereco">Endereço:</label>
						<select name="endereco" required="required" class="form-control">
							<option disabled="disabled" selected value="">Selecione uma opção</option>
							<c:forEach var="endereco" items="${enderecos}">
								<option value="${endereco.id}">${endereco.rua}</option>
							</c:forEach>
						</select>
					</div>
					 
					<div class="col">
						<label for="especialidades">Especialidades:</label> 
						<select name="especialidades[]" required="required" class="selectpicker form-control" multiple >
							<c:forEach var="especialidade" items="${especialidades}">
								${ especialidade }
								<option value="${especialidade.id}">${especialidade.nome}</option>
							</c:forEach>
						</select>
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
		
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta3/dist/css/bootstrap-select.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta3/dist/js/bootstrap-select.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta3/dist/js/i18n/defaults-*.min.js"></script>

	<script>
		function alterarNomeDiv(){ 
			$('.filter-option-inner-inner').text("Selecione as especialidades") 
		}
		
		$(document).ready(function(){
			$('.nav-item.home').addClass('active'); 				
			setTimeout(alterarNomeDiv, 10);			
		}) 
		
		
	</script>

</body>
</html>