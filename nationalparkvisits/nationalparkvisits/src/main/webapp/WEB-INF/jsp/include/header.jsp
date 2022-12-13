<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

		<!DOCTYPE html>
		<html>

		<head lang="en">
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link href="../../css/style.css" rel="stylesheet" type="text/css">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
				crossorigin="anonymous">
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>
		</head>

		<body>
			<nav class="navbar" style="background-color: green">
				<div class="row">
					<a href="index" class="col-2 navbar-brand" style="color:black">Home</a>
					<a href="signin" class="col-2 navbar-brand" style="color:black">Signin</a>
					<a href="signup" class="col-2 navbar-brand" style="color:black">Signup</a>
					<sec:authorize access="isAuthenticated()">
						<a href="myVisits" class="col-2 navbar-brand" style="color:black">My Visits</a>
						<a href="natparks" class="col-2 navbar-brand" style="color:black">National Parks</a>
						<a href="logout" class="col-2 navbar-brand" style="color:black">Logout</a>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<div style="color:black">Please log in or create user</diV>
					</sec:authorize>
				</div>
			</nav>