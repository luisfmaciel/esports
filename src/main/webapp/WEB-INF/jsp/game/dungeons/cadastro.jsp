<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>E-sports</title>
</head>
<body style="background-color: #f5f5f5;">
	<header>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</header>
	<main>
		<div class="container mt-3">
			<form action="/game/dungeons/incluir" method="post">
				<h3>Dungeons - Cadastro de estatísticas</h3>

				<c:if test="${not empty mensagemError}">
					<div class="alert alert-danger my-2" role="alert">
						<strong>Atenção</strong> ${mensagemError}
					</div>
				</c:if>

				<div class="w-25 mb-3">
					<label class="mb-1">Plataforma:</label> <select class="form-select"
						name="plataforma" aria-label="Default select example">
						<option value="PS5">PS5</option>
						<option value="Xbox One">Xbox One</option>
						<option value="PC">PC</option>
					</select>
				</div>
				<div class="form-floating mb-3">
					<input type="number" name="titulos" class="form-control"
						id="floatingInput" placeholder="Títulos"> <label
						for="floatingInput">Títulos</label>
				</div>
				<div class="form-floating mb-3">
					<input type="number" name="dano" class="form-control"
						id="floatingInput" placeholder="Dano"> <label
						for="floatingInput">Dano</label>
				</div>
				<div class="form-floating mb-3">
					<input type="number" name="sabedoria" class="form-control"
						id="floatingInput" placeholder="Sabedoria"> <label
						for="floatingInput">Sabedoria</label>
				</div>
				<div class="form-floating mb-3">
					<input type="number" name="velocidade" class="form-control"
						id="floatingInput" placeholder="Velocidade"> <label
						for="floatingInput">Velocidade</label>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</main>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"
		integrity="sha512-OvBgP9A2JBgiRad/mM36mkzXSXaJE9BEIENnVEmeZdITvwT09xnxLtT4twkCa8m/loMbPHsvPl0T8lRGVBwjlQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>