<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles.css">
<title>Students List</title>
</head>
<body>
	<jsp:include page="TheNavBar.jsp"/>
	<div style="width: 90%; margin: auto; margin-top: 3%">
		<div style="width:200px">
			<form action="etudiant/create" method="get">
				<input class="success" type="submit" value="Create">
			</form>
		</div>
		<div style="margin-top: 20px;">
			<c:if test="${Etudiants.size()==0}">
				<c:out value="NO Students to show" />
			</c:if>
			<c:if test="${Etudiants.size()>0}">
				<table id="mytb">
					<tr>
						<th>prenom</th>
						<th>nom</th>
						<th>email</th>
						<th>tel</th>
						<th>filiere</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
					<c:forEach items="${Etudiants}" var="etudiant">
						<tr>
							<td>${etudiant.getPrenom()}</td>
							<td>${etudiant.getNom()}</td>
							<td>${etudiant.getEmail()}</td>
							<td>${etudiant.getTel()}</td>
							<td>${etudiant.getFiliere().getName()}</td>
							<td>
								<form action="etudiant/update">
									<input type="hidden" name="id" id="id"
										value="${etudiant.getId()}"> <input class="update"
										type="submit" value="Update">
								</form>
							</td>
							<td>
								<form action="etudiant/delete" method="post">
									<input type="hidden" name="id" id="id"
										value="${etudiant.getId()}"> <input class="delete"
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