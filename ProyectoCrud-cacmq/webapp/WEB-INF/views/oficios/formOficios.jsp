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
<title>Oficios</title>

<spring:url value="/resources" var="urlPublic"></spring:url>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
<spring:url value="/Oficios/save" var="urlForm"></spring:url>

	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Registro Oficios</span>
			</h3>
		</div>

		<spring:hasBindErrors name="oficios"> <!-- es el nombre operativo controller -->
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>



		<form:form action="${urlForm}" method="post" enctype="multipart/form-date" modelAttribute="oficios">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="numeroDoc">Numero Documento</label>
						<form:hidden path="id"/>
						 <form:input type="text"
							class="form-control" path="numeroDoc" id="numeroDoc"
							required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="duracion">Solicitante</label>
						 <form:input type="text"
							class="form-control" path="solicitante" id="duracion"
							required="required" />
					</div>
				</div>
				

			</div>
		

	
        <div class="row">
         <div class="col-sm-3">
					<div class="form-group">
						<label for="fechaEstreno">Fecha </label> <form:input type="text"
							class="form-control" path="fecha" id="fechaEstreno"
							required="required" />
					</div>
				</div>
        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis"> resumen</label>
              <form:textarea class="form-control" rows="5" path="detalle" id="sinopsis"></form:textarea>
            </div> 
          </div> 
        </div>
        </div>

			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>


	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#fechaEstreno").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
