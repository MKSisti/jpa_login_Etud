<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles.css">
<title>Home</title>
</head>
<body>
	<div style="width: 90%; margin: auto; margin-top: 3%">
		<div style="width:200px">
			<form action="create" method="get">
				<input class="primary" type="submit" value="Create">
			</form>
		</div>
		<div style="margin-top: 20px;">
			<c:if test="${Articles.size()==0}">
				<c:out value="NO articles to show" />
			</c:if>
			<c:if test="${Articles.size()>0}">
				<table id="mytb">
					<tr>
						<th>Code</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Count</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
					<c:forEach items="${Articles}" var="article">
						<tr>
							<td>${article.code}</td>
							<td>${article.name}</td>
							<td>${article.description}</td>
							<td>$ ${article.price}</td>
							<td>${article.count}</td>
							<td>
								<form action="update">
									<input type="hidden" name="code" id="code"
										value="${article.code}"> <input class="update"
										type="submit" value="Update">
								</form>
							</td>
							<td>
								<form action="remove" method="post">
									<input type="hidden" name="code" id="code"
										value="${article.code}"> <input class="delete"
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