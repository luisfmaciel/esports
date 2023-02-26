<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<title>Cadastro de Usuário</title>
	
</head>
<body style="background-color: #f5f5f5;">
	<header>
		<nav class="navbar navbar-dark bg-black px-4">
		  <span class="navbar-brand text-light mb-0 h1">E-sports</span>
		</nav>
	</header>
	<main>
		<div class="container mt-3">
			<form action="/gamer/incluir" method="post">
				<h3>Cadastro</h3>
				
				<div class="form-floating mb-3">
				  	<input type="text" name="nome" class="form-control" id="floatingInput" placeholder="your name">
				  	<label for="floatingInput">Name</label>
				</div>
				<div class="form-floating mb-3">
				  	<input type="text" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
				  	<label for="floatingInput">Email address</label>
				</div>
				<div class="form-floating mb-3">
				  	<input type="password" name="senha" class="form-control" id="floatingInput" placeholder="your password">
				  	<label for="floatingInput">Passwrod</label>
				</div>
				<span>Meus jogos:</span>
				
				<div class="d-flex mt-3" style="gap: 50px;">
					<div class="mb-3 form-check">
						<span class="fw-bold">PC</span>
						<br>
						<div>
					    	<input type="checkbox" name="PC" value="Csgo" class="form-check-input" id="exampleCheck7">
						    <label class="form-check-label" for="exampleCheck7">CS:GO</label>
						</div>
						<div>
					    	<input type="checkbox" name="PC" value="Fifa" class="form-check-input" id="exampleCheck8">
						    <label class="form-check-label" for="exampleCheck8">FIFA</label>
						</div>
						<div>
					    	<input type="checkbox" name="PC" value="Dungeons" class="form-check-input" id="exampleCheck9">
						    <label class="form-check-label" for="exampleCheck9">DUNGEONS</label>
						</div>
			  		</div>
				
					<div class="mb-3 form-check">
						<span class="fw-bold">PS5</span>
						<br>
						<div>
					    	<input type="checkbox" name="PS5" value="Fifa" class="form-check-input" id="exampleCheck2">
						    <label class="form-check-label" for="exampleCheck2">FIFA</label>
						</div>
						<div>
					    	<input type="checkbox" name="PS5" value="Dungeons" class="form-check-input" id="exampleCheck3">
						    <label class="form-check-label" for="exampleCheck3">DUNGEOS</label>
						</div>
			  		</div>
			  		
					<div class="mb-3 form-check">
						<span class="fw-bold">Xbox One</span>
						<br>
						<div>
					    	<input type="checkbox" name="Xbox" value="Fifa" class="form-check-input" id="exampleCheck5">
						    <label class="form-check-label" for="exampleCheck5">FIFA</label>
						</div>
						<div>
					    	<input type="checkbox" name="Xbox" value="Dungeons" class="form-check-input" id="exampleCheck6">
						    <label class="form-check-label" for="exampleCheck6">DUNGEONS</label>
						</div>
			  		</div>
					
				</div>
			  	<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</main>
</body>
</html>