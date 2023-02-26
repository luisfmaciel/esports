<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<title>E-sports</title>
</head>
<body class="text-center" style="background-color: #f5f5f5">
	<header>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</header>

	<main>
		<div class="container mt-3">
			<h1 class="mt-2">E-sports</h1>
			
			[usuario: ${user.email}]
		</div>
	</main>
</body>
</html>