<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Spring Boot Web JSP Example</h1>
			<h2>Message: ${message}</h2>
			<h2>API</h2>
			<ul>
				<li> <a href="/time" target="_blank">/time</a> </li>
				<li> <a href="/employee" target="_blank">/employee</a> </li>
				<li> <a href="/categories" target="_blank">/categories</a> </li>
				<li> <a href="/products" target="_blank">/products</a> </li>
				<li> <a href="/tables" target="_blank">/tables</a> </li>
				<li> <a href="/orders" target="_blank">/orders</a> </li>
				<li> <a href="/orders/15b60f42-2b4a-4a2d-97fc-bfd9f386c1c3" target="_blank">Order Example</a> </li>
				<li> <a href="/receipts/15b60f42-2b4a-4a2d-97fc-bfd9f386c1c3" target="_blank">Receipt Example</a> </li>
				
			</ul>
		</div>

	</div>
	
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>