<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="form-floating mb-3">
	<input type="text" name="cep" value="${endereco.cep}" class="form-control"
		id="floatingInput" placeholder="CEP"> <label
		for="floatingInput">CEP</label>
</div>
<div class="form-floating mb-3">
	<input type="text" name="logradouro" value="${endereco.logradouro}" class="form-control"
		id="floatingInput" placeholder="Logradouro"> <label
		for="floatingInput">Logradouro</label>
</div>
<div class="form-floating mb-3">
	<input type="text" name="complemento" value="${endereco.complemento}" class="form-control"
		id="floatingInput" placeholder="Complemento"> <label
		for="floatingInput">Complemento</label>
</div>
<div class="form-floating mb-3">
	<input type="text" name="bairro" value="${endereco.bairro}" class="form-control"
		id="floatingInput" placeholder="Bairro"> <label
		for="floatingInput">Bairro</label>
</div>
<div class="form-floating mb-3">
	<input type="text" name="localidade" value="${endereco.localidade}" class="form-control"
		id="floatingInput" placeholder="Localidade"> <label
		for="floatingInput">Localidade</label>
</div>
<div class="form-floating mb-3">
	<input type="text" name="uf" value="${endereco.uf}" class="form-control"
		id="floatingInput" placeholder="UF"> <label
		for="floatingInput">UF</label>
</div>