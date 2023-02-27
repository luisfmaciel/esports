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
		<div class="container mt-4">
			<h3>Estat�sticas Dungeons</h3>


			<c:if test="${empty dungeonsEstatisticas}">
				<h5>N�o existem estat�sticas cadastradas!</h5>
			</c:if>

			<c:if test="${not empty mensagem}">
				<div class="alert alert-success my-2" role="alert">
					<strong>Aten��o</strong> ${mensagem}
				</div>
			</c:if>

			<a type="button" class="btn btn-primary my-2" href="/game/dungeons">Novo</a>

			<c:if test="${not empty dungeonsEstatisticas}">

				<table class="table table-striped mt-4">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Plataforma</th>
							<th scope="col">Dano</th>
							<th scope="col">Sabedoria</th>
							<th scope="col">Velocidade</th>
							<th scope="col">N�vel</th>
							<th scope="col">M�dia Estat�sticas*</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dungeons" items="${dungeonsEstatisticas}">
							<tr>
								<th scope="row">${dungeons.id}</th>
								<td>${dungeons.plataforma}</td>
								<td>${dungeons.dano}</td>
								<td>${dungeons.sabedoria}</td>
								<td>${dungeons.velocidade}</td>
								<td>${dungeons.nivel}</td>
								<td>${String.format("%.2f", dungeons.mediaEstatistica)}</td>
								<td><a href="/game/dungeons/${dungeons.id}/excluir">excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<small class="text-secondary">* Cada estat�stica possue um
					peso diferente que comp�e a m�dia</small>
			</c:if>
		</div>
	</main>
</body>
</html>