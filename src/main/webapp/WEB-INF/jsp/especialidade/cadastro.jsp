<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<style>
	select{
	    height: 35px !important;
    }
</style>

<div class="row">
	<div class="col">
		<label for="nome">Nome:</label> <input type="text" name="nome"
			class="form-control" placeholder="Insira o nome">
	</div>

	<div class="col">
		<label for="codigo">Código:</label> <input type="text" name="codigo"
			class="form-control" placeholder="Insira o codigo">
	</div>

	<div class="col">
		<label for="valorHora">Valor p/ hora:</label> <input type="number"
			name="valorHora" class="form-control"
			placeholder="Insira o valor p/ hora">
	</div>

	<div class="col">
		<label for="status">Status:</label> 
		<select name="status" class="form-control">
			<option selected value="true">Ativo</option>
			<option value="false">Inativo</option>
		</select>
	</div>
</div>
