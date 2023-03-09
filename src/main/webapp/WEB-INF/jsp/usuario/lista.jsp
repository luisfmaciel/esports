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
		<div class="container mt-4">

			<h3>Listagem de Usuarios</h3>

			<%-- <c:if test="${not empty mensagem}">
				<div class="alert alert-success my-2" role="alert">
					<strong>Atenção</strong> ${mensagem}
				</div>
			</c:if> --%>

			<c:if test="${empty usuarios}">
				<h5>Não existem usuários cadastrados!</h5>
			</c:if>

			<c:if test="${not empty usuarios}">
				<h5>Quantidade de usuários cadastrados: ${usuarios.size()}</h5>

				<table class="table table-striped mt-4">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nome</th>
							<th scope="col">Senha</th>
							<th scope="col">E-mail</th>
							<th scope="col">Username</th>
							<th scope="col">Perfil</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${usuarios}">
							<tr>
								<th scope="row">${u.id}</th>
								<td>${u.nome}</td>
								<td>${u.senha}</td>
								<td>${u.email}</td>
								<td>${u.username}</td>
								<td>${u.perfil}</td>
								<td><a href="/usuario/${u.id}/excluir">excluir</a></td>
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