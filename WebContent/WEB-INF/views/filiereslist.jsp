<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Filieres List</title>
</head>
<body>
	<jsp:include page="TheNavBar.jsp"/>
	<div style="width: 90%; margin: auto; margin-top: 3%">
		<div style="width:200px">
			<form action="filiere/create" method="get">
				<input class="success" type="submit" value="Create">
			</form>
		</div>
		<div style="margin-top: 20px;">
			<c:if test="${Filieres.size()==0}">
				<c:out value="NO Filieres to show" />
			</c:if>
			<c:if test="${Filieres.size()>0}">
				<table id="mytb">
					<tr>
						<th>nom</th>
						<th>description</th>
						<th>List</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
					<c:forEach items="${Filieres}" var="filiere">
						<tr>
							<td>${filiere.getName()}</td>
							<td>${filiere.getDescription()}</td>
							<td>
								<form action="filiere/list">
									<input type="hidden" name="id" id="id"
										value="${filiere.getId()}"> <input class="update"
										type="submit" value="List">
								</form>
							</td>
							<td>
								<form action="filiere/update">
									<input type="hidden" name="id" id="id"
										value="${filiere.getId()}"> <input class="update"
										type="submit" value="Update">
								</form>
							</td>
							<td>
								<form action="filiere/delete" method="post">
									<input type="hidden" name="id" id="id"
										value="${filiere.getId()}"> <input class="delete"
										type="submit" value="Delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>