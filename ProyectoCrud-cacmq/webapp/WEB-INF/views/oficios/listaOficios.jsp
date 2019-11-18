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
    <title>Listado de Oficios</title>
    
    <spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/Oficios/create" var="urlCreate"></spring:url>
<spring:url value="/Oficios/delete" var="urlDelete"></spring:url>
<spring:url value="/Oficios/edit" var="urlEdit"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
        
  </head>

  <body>

    
<jsp:include page="../includes/menu.jsp"></jsp:include>
	<div class="container theme-showcase" role="main">

		<h3>oficios</h3>
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
					<th>numero documento</th>
					<th>solicitante</th>
					<th>fecha</th>
					<th>detalles</th>
					
				</tr>
				</thead>
				<tbody>


					<c:forEach items="${oficio}" var="ofic">
						<tr>
							<td>${ofic.id}</td>
							<td>${ofic.numeroDoc}</td>
							<td>${ofic.solicitante}</td>
							<td>${ofic.fecha}</td>
							<td>${ofic.detalle}</td>
							
							 
                <td>
                    <a href="${urlEdit}/${ofic.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlDelete}/${ofic.id}"onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
						</tr>


					</c:forEach>

				</tbody>
			</table>
		</div>


	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
    