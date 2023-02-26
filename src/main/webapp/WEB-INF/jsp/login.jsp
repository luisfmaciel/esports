<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<title>E-sports</title>
</head>
<body class="text-center vh-100" style="background-color: #f5f5f5;">
	<header>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</header>
	<main class="form-signin w-25 m-auto mt-4">
		<form class="mt-4" action="/login" method="post">
			<!-- <img class="mb-4" src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

			<c:if test="${not empty mensagem}">
				<div class="alert alert-danger" role="alert">
					<strong>Atenção</strong> ${mensagem}
				</div>
			</c:if>

			<div class="form-floating">
				<input type="email" name="email" class="form-control"
					id="floatingInput" placeholder="name@example.com"> <label
					for="floatingInput">Email address</label>
			</div>
			<div class="form-floating">
				<input type="password" name="senha" class="form-control"
					id="floatingPassword" placeholder="Password"> <label
					for="floatingPassword">Password</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				in</button>
			<p class="mt-5 mb-3 text-muted">© 2023</p>
		</form>
	</main>
</body>
</html>