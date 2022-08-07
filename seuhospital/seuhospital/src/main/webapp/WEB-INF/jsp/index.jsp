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

	<div class="container mb-5">
	
		<h2 class="mt-4">Infinet - Seu Hospital</h2>

		
		<div class="container-fluid pt-5 w-100 hospital">
		
			<h4>Classe: Hospital</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Attribute</th>
						<th scope="col">Type</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>nome</td>
						<td>String</td>
						<td>Estabelecimento de saúde destinado a prestar assistência médico-sanitária a uma população.</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>cnpj</td>
						<td>String</td>
						<td>Cadastro Nacional da Pessoa Jurídica</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>descricao</td>
						<td>String</td>
						<td>Descrição do Hospital</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="container-fluid pt-5 w-100 endereco">
		
			<h4>Classe: Endereço</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Attribute</th>
						<th scope="col">Type</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>rua</td>
						<td>String</td>
						<td>Rua do endereço</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>numero</td>
						<td>int</td>
						<td>Número do endereço</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>estado</td>
						<td>String</td>
						<td>Estado do endereço</td>
					</tr>
					<tr>
						<th scope="row">4</th>
						<td>pais</td>
						<td>String</td>
						<td>Pais do endereço</td>
					</tr>
					<tr>
						<th scope="row">5</th>
						<td>cep</td>
						<td>String</td>
						<td>CEP do endereço</td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<div class="container-fluid pt-5 w-100 especializada">
		
			<h4>Classe: Especialidade</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Attribute</th>
						<th scope="col">Type</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>nome</td>
						<td>String</td>
						<td>Nome do Especialista</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>codigo</td>
						<td>int</td>
						<td>Chave de identificação da especialidade</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>status</td>
						<td>boolean</td>
						<td>Informa se a especialidade está ativa ou não</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="container-fluid pt-5 w-100 clinicoGeral">
		
			<h4>Classe: Clínico Geral</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Attribute</th>
						<th scope="col">Type</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>turno</td>
						<td>String</td>
						<td>Turno de atuação.</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>diarista</td>
						<td>boolean</td>
						<td>Campo onde identificamos se o usuário é prestador ou não</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>descricao</td>
						<td>String</td>
						<td>Descrição da especialidade</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="container-fluid pt-5 w-100 dentista">
		
			<h4>Classe: Dentista</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Attribute</th>
						<th scope="col">Type</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>turno</td>
						<td>String</td>
						<td>Turno de atuação.</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>atendeCrianca</td>
						<td>boolean</td>
						<td>Campo onde identificamos se o usuário atende crianças.</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>cirurgia</td>
						<td>boolean</td>
						<td>Campo onde identificamos se o usuário realiza cirurgia.</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="container-fluid pt-5 w-100 pediatria">
		
			<h4>Classe: Pediatria</h4>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Attribute</th>
						<th scope="col">Type</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>neonatologia</td>
						<td>boolean</td>
						<td>Campo onde identificamos se o usuário atua como neonatologia ou não.</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>cardiologia</td>
						<td>boolean</td>
						<td>Campo onde identificamos se o usuário atua como cardiologista ou não.</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>apenasBebes</td>
						<td>boolean</td>
						<td>Campo onde identificamos se o usuário atua apenas com bebes ou não.</td>
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
</body>
</html>