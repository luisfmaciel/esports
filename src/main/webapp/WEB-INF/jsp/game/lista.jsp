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
			<h1 class="mt-2">Games</h1>

			<c:if test="${empty gamesEstatisticas}">
				<h5>Não existem estatísticas cadastradas!</h5>
			</c:if>

			<c:if test="${not empty mensagem}">
				<div class="alert alert-success my-2" role="alert">
					<strong>Atenção</strong> ${mensagem}
				</div>
			</c:if>

			<c:if test="${not empty gamesEstatisticas}">
				<table class="table table-striped mt-4">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Game</th>
							<th scope="col">Plataforma</th>
							<th scope="col">Títulos</th>
							<th scope="col">Nível</th>
							<th scope="col">Média Estatísticas*</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="game" items="${gamesEstatisticas}">
							<tr>
								<th scope="row">${game.id}</th>
								<td>${game.nome.toUpperCase()}</td>
								<td>${game.plataforma}</td>
								<td>${game.titulos}</td>
								<td>${game.nivel}</td>
								<td>${String.format("%.2f", game.mediaEstatistica)}</td>
								<td><a
									href="/game/${game.id}/excluir">excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<small class="text-secondary">* Cada estatística possue um
					peso diferente que compõe a média</small>
			</c:if>
		</div>
	</main>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"
		integrity="sha512-OvBgP9A2JBgiRad/mM36mkzXSXaJE9BEIENnVEmeZdITvwT09xnxLtT4twkCa8m/loMbPHsvPl0T8lRGVBwjlQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>