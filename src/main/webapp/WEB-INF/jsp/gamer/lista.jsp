<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
			<form action="/gamer" method="get">
				<h3>Listagem de Gamers</h3>
				
				<button class="btn btn-primary" type="submit">Novo</button>
			</form>
			<table class="table table-striped mt-4">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Nome</th>
			      <th scope="col">E-mail</th>
			      <th scope="col">Username</th>
			      <th scope="col">Games</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td>Luis</td>
			      <td>luis@esports.com</td>
			      <td>@luis</td>
			      <td> 
			      	<div class="d-flex flex-column">
				      	<div class="d-flex flex-column">
				      		<span class="fw-bold">PS5</span>
				      		<span class="ms-2">Fifa</span>
				      		<span class="ms-2">Dungeons</span>
				      	</div>
				      	<div class="d-flex flex-column mt-2">
				      		<span class="fw-bold">PC</span>
				      		<span class="ms-2">CS:GO</span>
				      	</div>
				      </div>
			      </td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td>Felipe</td>
			      <td>felipe@esports.com</td>
			      <td>@felipe</td>
			      <td>
				      <div class="d-flex flex-column">
				      	<div class="d-flex flex-column">
				      		<span class="fw-bold">Xbox One</span>
				      		<span class="ms-2">Dungeons</span>
				      		<span class="ms-2">Fifa</span>
				      	</div>
				      	<div class="d-flex flex-column mt-2">
				      		<span class="fw-bold">PC</span>
				      		<span class="ms-2">CS:GO</span>
				      	</div>
				      </div>
			      </td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</main>
</body>
</html>