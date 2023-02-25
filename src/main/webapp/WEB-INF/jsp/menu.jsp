<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">E-sports</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarScroll" aria-controls="navbarScroll"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
				style="-bs-scroll-height: 100px;">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/usuario/lista">Usu�rios</a></li>
				<li class="nav-item"><a class="nav-link" href="/gamer/lista">Gamers</a></li>
				<li class="nav-item"><a class="nav-link" href="/game">Jogos</a></li>
				<li class="nav-item"><a class="nav-link" href="/equipe/lista">Equipes</a></li>
			</ul>
			<div class="text-end">
				<a href="/login" type="button" class="btn btn-outline-light me-2">Login</a>
				<a href="/usuario" type="button" class="btn btn-warning">Sign-up</a>
				<a href="#" type="button" class="btn btn-outline-success me-2">Logout</a>
			</div>
		</div>
	</div>
</nav>