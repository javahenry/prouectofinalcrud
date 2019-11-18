<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Estadistica</title>

<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/operativos/create" var="urlCreate"></spring:url>
<spring:url value="/operativos/delete" var="urlDelete"></spring:url>
<spring:url value="/operativos/edit" var="urlEdit"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	<div class="container theme-showcase" role="main">

		<h3>Listado de estadisticas</h3>
		<c:if test="${mensaje!= null }">
			<div class="alert alert-success" role="alert">${mensaje}</div>
		</c:if>

		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Operativo">Nueva</a><br> <br>
			
			

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				</thead>
				<tr>
					<th>Id</th>
					<th>Persona que reporta</th>
					<th>Eventos controlados</th>
					<th>Operativo AMC</th>
					<th>Sitios Clausuarados</th>
					<th>Resuamen</th>
					<th>Fecha</th>
				</tr>
				</thead>
				<tbody>


					<c:forEach items="${operativo}" var="opera">
						<tr>
							<td>${opera.id}</td>
							<td>${opera.detalle.responsable}</td>
							<td>${opera.eventosControlados}</td>
							<td>${opera.operAmc}</td>
							<td>${opera.sitioClausurados}</td>
							<td>${opera.detalle.resumen}</td>
							<td>${opera.fecha}</td>
							
							
                <td>
                    <a href="${urlEdit}/${opera.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlDelete}/${opera.id}"onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
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
