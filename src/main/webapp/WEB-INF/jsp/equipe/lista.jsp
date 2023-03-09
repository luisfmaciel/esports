<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h2>Lista de Equipes</h2>

			<c:if test="${empty equipes}">
				<h5>Não existem equipes cadastradas!</h5>
			</c:if>

			<c:if test="${not empty mensagem}">
				<div class="alert alert-success my-2" role="alert">
					<strong>Atenção</strong> ${mensagem}
				</div>
			</c:if>

			<a type="button" class="btn btn-primary my-2" href="/equipe">Novo</a>

			<c:if test="${not empty equipes}">
				<table class="table table-striped mt-4">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nome</th>
							<th scope="col">Game</th>
							<th scope="col">Nível</th>
							<th scope="col">Limite de Participantes</th>
							<th scope="col">Multiplaforma</th>
							<th scope="col">Gamers</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${equipes}">
							<tr>
								<th scope="row">${e.id}</th>
								<td>${e.nome}</td>
								<td>${e.game.nome}</td>
								<td>${e.nivel}</td>
								<td>${e.limiteParticipantes}</td>
								<td>${e.multiPlataforma}</td>
								<td>
									<div class="d-flex flex-column">
										<c:forEach var="g" items="${e.gamers}">
											<span class="ms-2">@${g.username}</span>
										</c:forEach>
									</div>
								</td>
								<td><a href="/equipe/${e.id}/excluir">excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</main>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"
		integrity="sha512-OvBgP9A2JBgiRad/mM36mkzXSXaJE9BEIENnVEmeZdITvwT09xnxLtT4twkCa8m/loMbPHsvPl0T8lRGVBwjlQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>