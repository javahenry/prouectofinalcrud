<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Peliculas</title>

<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/Personas/create" var="urlCreate"></spring:url>
<spring:url value="/Personas/delete" var="urlDelete"></spring:url>
<spring:url value="/Personas/edit" var="urlEdit"></spring:url>
<spring:url value="/Personas/buscar" var="urlBuscar"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	<div class="container theme-showcase" role="main">

		<h3>Listado del persona</h3>
		<c:if test="${mensaje!= null }">
			<div class="alert alert-success" role="alert">${mensaje}</div>
		</c:if>

		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva ">Nueva</a><br> <br>
			
	<form action="#"  class="form-inline my-2 my-lg-0" >
      <input class="form-control mr-sm-2" path="nombre" placeholder="Search" aria-label="Search" />
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				</thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>fecha</th>
					<th>direccion</th>
					<th>telefon</th>
					<th>sexo</th>
				</tr>
				</thead>
				<tbody>


					<c:forEach items="${persona}" var="per">
						<tr>
							<td>${per.id}</td>
							<td>${per.nombres}</td>
							<td>${per.apellidos}</td>
							<td>${per.fecha}</td>
							<td>${per.direccion}</td>
							<td>${per.telefono}</td>
							<td>${per.sexo}</td>
							
							
							 
                <td>
                    <a href="${urlEdit}/${per.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlDelete}/${per.id}"onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
						</tr>


					</c:forEach>

				</tbody>
			</table>
		</div>


	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
