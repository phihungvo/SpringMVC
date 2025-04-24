<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authors</title>
</head>
<body>
<a href="add-author">Add</a>
<form action="delete" method="post">
<table border="1">
	<tr>
		<th><input type="submit" name="delete" value="Delete"></th>
		<th>Id</th>
		<th>Name</th>
		<th>Edit</th>
		<th>Del</th>
	</tr>
	<c:forEach items="${authors}" var="at">
		<tr>
			<td><input type="checkbox" name="idXoa" value="${at.id}"></td>
			<td>${at.id}</td>
			<td>${at.name }</td>
			<td><a href="edit-author?id=${at.id}"><img src="img/edit.png"></a></td>
			<td><a href="#"><img src="img/trash.png"></a></td>
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>