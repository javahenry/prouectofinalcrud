<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<spring:url value="/" var="urlRoot"></spring:url>


<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<sec:authorize access="isAnonymous()">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Principal</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${urlRoot}">CACMQ</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${urlRoot}">Home</a></li>
					<li><a href="${urlRoot}login">Login</a></li>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>

		<sec:authorize access="hasAnyAuthority('ADMIN')">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Principal</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${urlRoot}admin/index">ADMINISTRADOR</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${urlRoot}">Home</a></li>
					<li><a href="${urlRoot}operativos/index">Operativos</a></li>
					<li><a href="${urlRoot}Oficios/index">Oficios</a></li>
					<li><a href="${urlRoot}Personas/index">Personal</a></li>
					<li><a href="${urlRoot}admin/logout">Logout</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->

		</sec:authorize>
		<sec:authorize access="hasAnyAuthority('AGENTE')">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Principal</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${urlRoot}admin/index">AGENTE</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${urlRoot}">Home</a></li>
				    <li><a href="${urlRoot}Oficios/index">Oficios</a></li>
					<li><a href="${urlRoot}admin/logout">Logout</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</sec:authorize>
	</div>
</nav>