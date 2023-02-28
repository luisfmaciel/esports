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
<body class="text-center" style="height= 100vh; background-color: #f5f5f5;">
	<header>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</header>
	<main>
		<div class="container mt-3">
			<h1 class="mt-2">Games</h1>		
			<h2 class="mt-2">Estatísticas<a href="/game/csgo/lista"> CS:GO</a></h2>
			<h2 class="mt-2">Estatísticas<a href="/game/fifa/lista"> FIFA 23</a></h2>
			<h2 class="mt-2">Estatísticas<a href="/game/dungeons/lista"> DUNGEONS</a></h2>
		</div>
	</main>
</body>
</html>