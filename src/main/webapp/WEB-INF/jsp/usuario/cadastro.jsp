<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de usuario</title>

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
		  <h2>Cadastramento de usuario</h2>
		  <form action="/usuario/incluir" method="POST"> 
		  	<div class="mb-3 mt-3">
		      <label for="nome">Nome:</label>
		      <input type="text" class="form-control" placeholder="Insira seu nome" name="nome">
		    </div>
		  
		    <div class="mb-3 mt-3">
		      <label for="email">Email:</label>
		      <input type="email" class="form-control" placeholder="Insira seu email" name="email">
		    </div>
		    
		    <div class="mb-3">
		      <label for="pwd">Password:</label>
		      <input type="password" class="form-control" placeholder="Insira sua senha" name="senha">
		    </div> 
		    
		    <button type="submit" class="btn btn-primary">Cadastrar</button>
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