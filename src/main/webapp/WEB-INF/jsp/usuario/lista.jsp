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
<meta charset="ISO-8859-1">
<title>E-sports</title>
</head>
<body style="background-color: #f5f5f5;">
	<header>
		<nav class="navbar navbar-dark bg-black px-4">
			<span class="navbar-brand text-light mb-0 h1">E-sports</span>
		</nav>
	</header>
	<main>
		<div class="container mt-4">
			<form action="/usuario" method="get">
				
				<h3>Listagem de Usuarios</h3>

				<c:if test="${not empty mensagem}">
					<div class="alert alert-success my-2" role="alert">
						<strong>Atenção</strong> ${mensagem}
					</div>
				</c:if>

				<button class="btn btn-primary" type="submit">Novo</button>
			</form>
			

			<c:if test="${empty usuarios}">
				<h5>Não existem usuários cadastrados!</h5>
			</c:if>

			<c:if test="${not empty usuarios}">
				<h5>Quantidade de usuários cadastrados: ${usuarios.size()}</h5>

				<table class="table table-striped mt-4">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome</th>
							<th scope="col">Senha</th>
							<th scope="col">E-mail</th>
							<th scope="col">Username</th>
							<th scope="col">Perfil</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${usuarios}" varStatus="loop">
							<tr>
								<th scope="row">${loop.index+1}</th>
								<td>${u.nome}</td>
								<td>${u.senha}</td>
								<td>${u.email}</td>
								<td>${u.username}</td>
								<td>${u.perfil}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</main>
</body>
</html>