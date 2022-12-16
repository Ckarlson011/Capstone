<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

		<!DOCTYPE html>
		<html>

		<head lang="en">
			<meta charset="UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<link href="../pub/style.css" rel="stylesheet">
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
				crossorigin="anonymous">
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
				crossorigin="anonymous"></script>
		</head>

		<body style="background-color:burlywood">
			<nav class="navbar" style="background-color: green">
				<div class="container">
					<a href="index" class="col-1 navbar-brand text-center" style="color:black" id="a1">Home</a>
					<a href="signin" class="col-1 navbar-brand text-center" style="color:black" id="a2">Signin</a>
					<a href="signup" class="col-1 navbar-brand text-center" style="color:black" id="a3">Signup</a>
					<sec:authorize access="isAuthenticated()">
						<a href="myVisits" class="col-1 navbar-brand text-center" style="color:black" id="a4">My Visits</a>
						<a href="natparks" class="col-2 navbar-brand text-center" style="color:black" id="a5">National Parks</a>
						<a href="logout" class="col-1 navbar-brand text-center" style="color:black" id="a6">Logout</a>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<div class="text-center"style="color:black">Please log in or create user</diV>
					</sec:authorize>
				</div>
			</nav>
			<script>
				document.getElementById("a1").addEventListener("mouseover", function(){
					document.getElementById("a1").style.backgroundColor = "darkgreen";
				});
				document.getElementById("a1").addEventListener("mouseout", function(){
					document.getElementById("a1").style.backgroundColor = "green";
				});
				document.getElementById("a2").addEventListener("mouseover", function(){
					document.getElementById("a2").style.backgroundColor = "darkgreen";
				});
				document.getElementById("a2").addEventListener("mouseout", function(){
					document.getElementById("a2").style.backgroundColor = "green";
				});
				document.getElementById("a3").addEventListener("mouseover", function(){
					document.getElementById("a3").style.backgroundColor = "darkgreen";
				});
				document.getElementById("a3").addEventListener("mouseout", function(){
					document.getElementById("a3").style.backgroundColor = "green";
				});
				document.getElementById("a4").addEventListener("mouseover", function(){
					document.getElementById("a4").style.backgroundColor = "darkgreen";
				});
				document.getElementById("a4").addEventListener("mouseout", function(){
					document.getElementById("a4").style.backgroundColor = "green";
				});
				document.getElementById("a5").addEventListener("mouseover", function(){
					document.getElementById("a5").style.backgroundColor = "darkgreen";
				});
				document.getElementById("a5").addEventListener("mouseout", function(){
					document.getElementById("a5").style.backgroundColor = "green";
				});
				document.getElementById("a6").addEventListener("mouseover", function(){
					document.getElementById("a6").style.backgroundColor = "darkgreen";
				});
				document.getElementById("a6").addEventListener("mouseout", function(){
					document.getElementById("a6").style.backgroundColor = "green";
				});
			</script>