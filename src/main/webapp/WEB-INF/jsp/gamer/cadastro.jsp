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
			<form action="/gamer/incluir" method="post">
				<h3>Cadastro Gamers</h3>

				<c:if test="${not empty mensagemError}">
					<div class="alert alert-danger my-2" role="alert">
						<strong>Atenção</strong> ${mensagemError}
					</div>
				</c:if>
				
				<div class="form-floating mb-3">
					<input type="text" name="nome" class="form-control"
						id="floatingInput" placeholder="your name"> <label
						for="floatingInput">Nome</label>
				</div>
				
				<div class="form-floating mb-3">
					<input type="text" name="email" class="form-control"
						id="floatingInput" placeholder="name@example.com"> <label
						for="floatingInput">E-mail</label>
				</div>

				<div class="w-25 mb-3">
					<label class="mb-1">Perfil:</label> 
					<select class="form-select"
						name="perfil" aria-label="Default select example">
						<option value="gamer" selected>Gamer</option>
					</select>
				</div>

				<div class="mb-3 form-check">
					<span>Meus Jogos:</span>
					<c:forEach var="g" items="${games}">
						<div>
							<input type="checkbox" name="gameId" value="${g.id}"
								class="form-check-input" id="${g.id}"> <label
								class="form-check-label" for="${g.id}">${g.nome} -
								${g.plataforma} - ${g.nivel} - ${String.format("%.2f", g.mediaEstatistica)}</label>
						</div>
					</c:forEach>
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