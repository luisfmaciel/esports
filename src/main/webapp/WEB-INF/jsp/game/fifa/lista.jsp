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
			<h3>Estatísticas FIFA 23</h3>


			<c:if test="${empty fifaEstatisticas}">
				<h5>Não existem estatísticas cadastradas!</h5>
			</c:if>

			<c:if test="${not empty mensagem}">
				<div class="alert alert-success my-2" role="alert">
					<strong>Atenção</strong> ${mensagem}
				</div>
			</c:if>

			<a type="button" class="btn btn-primary my-2" href="/game/fifa">Novo</a>

			<c:if test="${not empty fifaEstatisticas}">
				<table class="table table-striped mt-4">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Plataforma</th>
							<th scope="col">Finalização</th>
							<th scope="col">Marcação</th>
							<th scope="col">Passe</th>
							<th scope="col">Nível</th>
							<th scope="col">Média Estatísticas*</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fifa" items="${fifaEstatisticas}">
							<tr>
								<th scope="row">${fifa.id}</th>
								<td>${fifa.plataforma}</td>
								<td>${fifa.finalizacao}</td>
								<td>${fifa.marcacao}</td>
								<td>${fifa.passe}</td>
								<td>${fifa.nivel}</td>
								<td>${String.format("%.2f", fifa.mediaEstatistica)}</td>
								<td><a href="/game/fifa/${fifa.id}/excluir">excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<small class="text-secondary">* Cada estatística possue um
					peso diferente que compõe a média</small>
			</c:if>
		</div>
	</main>
</body>
</html>