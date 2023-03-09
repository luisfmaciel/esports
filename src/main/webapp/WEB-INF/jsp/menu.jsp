<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/">Home</a></li>
				<c:if test="${not empty user}">
					<li class="nav-item"><a class="nav-link" href="/usuario/lista">Usuários</a></li>
					<li class="nav-item"><a class="nav-link" href="/gamer/lista">Gamers</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="/game" role="button" aria-expanded="false">Jogos</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/game">Todos Games</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/game/csgo/lista">CS:GO</a></li>
							<li><a class="dropdown-item" href="/game/fifa/lista">FIFA 23</a></li>
							<li><a class="dropdown-item" href="/game/dungeons/lista">DUNGEONS</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link" href="/equipe/lista">Equipes</a></li>
				</c:if>

			</ul>
			<ul class="navbar-nav my-2 my-lg-0 navbar-nav-scroll text-end">
				<c:if test="${empty user}">
					<li class="nav-item"><a href="/usuario" class="nav-link"><i
							class="bi bi-person-circle"></i> Sign Up</a></li>
					<li class="nav-item"><a href="/login" class="nav-link"><i
							class="bi bi-box-arrow-in-right"></i> Login</a></li>

				</c:if>
				<c:if test="${not empty user}">
					<li class="nav-item"><a href="/logout" class="nav-link"><i
							class="bi bi-box-arrow-left"></i> Logout, @${user.username}</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
