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
			<form action="/game/fifa/incluir" method="post">
				<h3>Fifa - Cadastro de estat�sticas</h3>

				<c:if test="${not empty mensagemError}">
					<div class="alert alert-danger my-2" role="alert">
						<strong>Aten��o</strong> ${mensagemError}
					</div>
				</c:if>

				<c:import url="/WEB-INF/jsp/game/cadastro.jsp" />
				
				<div class="form-floating mb-3">
					<input type="number" name="finalizacao" class="form-control"
						id="floatingInput" placeholder="Finaliza��o" value="2"> <label
						for="floatingInput">Finaliza��o</label>
				</div>
				<div class="form-floating mb-3">
					<input type="number" name="marcacao" class="form-control"
						id="floatingInput" placeholder="Marca��o" value="2"> <label
						for="floatingInput">Marca��o</label>
				</div>
				<div class="form-floating mb-3">
					<input type="number" name="passe" class="form-control"
						id="floatingInput" placeholder="Passe" value="2"> <label
						for="floatingInput">Passe</label>
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