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
	<div class="container mt-3">
		<form action="/equipe/incluir" method="post">
			<h3>Cadastro de Equipes</h3>

			<c:if test="${not empty mensagemError}">
				<div class="alert alert-danger my-2" role="alert">
					<strong>Atenção</strong> ${mensagemError}
				</div>
			</c:if>

			<div class="form-floating mb-3">
				<input type="text" name="nome" class="form-control"
					id="floatingInput" placeholder="Nome"> <label
					for="floatingInput">Nome</label>
			</div>
			<div class="form-floating mb-3">
				<input type="number" name="limiteParticipantes" class="form-control"
					id="floatingInput" placeholder="Limite Participantes"> <label
					for="floatingInput">Limite Participantes</label>
			</div>
			<div class="w-25 mb-3">
				<label class="mb-1">Nível:</label> <select class="form-select"
					name="nivel" aria-label="Default select example">
					<option value="iniciante">Iniciante</option>
					<option value="semipro">Semipro</option>
					<option value="profissional">Profissional</option>
					<option value="lendario">Lendário</option>
				</select>
			</div>
			<div class="w-25 mb-3">
				<label class="mb-1">Game:</label> <select class="form-select"
					name="game" aria-label="Default select example">
					<option value="CS:GO">CS:GO</option>
					<option value="FIFA">FIFA 23</option>
					<option value="DUNGEONS">DUNGEONS</option>
				</select>
			</div>
			<div class="w-25 mb-3">
				<label class="mb-1">Plataforma principal:</label> <select class="form-select"
					name="plataforma" aria-label="Default select example">
					<option value="PC">PC</option>
					<option value="Xbox One">Xbox One</option>
					<option value="PS5">PS5</option>
				</select>
			</div>

			<div class="w-25 mb-3">
				<span>Multiplataforma: </span>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="multiplataforma"
						id="flexRadioDefault1" value="true" checked> <label
						class="form-check-label" for="flexRadioDefault1"> Sim </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="multiplataforma"
						id="flexRadioDefault2" value="false"> <label
						class="form-check-label" for="flexRadioDefault2"> Não </label>
				</div>
			</div>
			<div class="mb-3 form-check">
				<span>Gamers:</span>
				<c:forEach var="g" items="${gamers}">
					<div>
						<input type="checkbox" name="gamerId" value="${g.id}"
							class="form-check-input" id="${g.id}"> <label
							class="form-check-label" for="${g.id}">@${g.username}</label>
					</div>
				</c:forEach>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"
		integrity="sha512-OvBgP9A2JBgiRad/mM36mkzXSXaJE9BEIENnVEmeZdITvwT09xnxLtT4twkCa8m/loMbPHsvPl0T8lRGVBwjlQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>