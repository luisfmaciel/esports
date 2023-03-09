<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<title>Cadastro de Usu�rio</title>
</head>
<body style="background-color: #f5f5f5;">
	<header>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</header>
	<main>
		<div class="container mt-3">
			<form action="/usuario/incluir" method="post">
				<h3>Cadastro de Usu�rio</h3>

				<div class="form-floating mb-3">
					<input type="text" name="nome" class="form-control"
						id="floatingInput" placeholder="your name"> <label
						for="floatingInput">Name</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" name="email" class="form-control"
						id="floatingInput" placeholder="name@example.com"> <label
						for="floatingInput">Email address</label>
				</div>
				<div class="form-floating mb-3">
					<input type="password" name="senha" class="form-control"
						id="floatingInput" placeholder="your password"> <label
						for="floatingInput">Passwrod</label>
				</div>
				<div class="w-25 mb-3">
					<label class="mb-1">Perfil:</label> <select class="form-select"
						name="perfil" aria-label="Default select example">
						<option value="gamer">Gamer</option>
					</select>
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