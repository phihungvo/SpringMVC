<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Author</title>
</head>
<body>
<h1>Edit Author</h1>
<form action="edit-author" method="post">
	<p><input type="text" name="id" value="${at.id}" hidden="hidden"></p>
	<p><input type="text" name="name" value="${at.name }"></p>
	<p><button type="submit">Save</button>
</form>
</body>
</html>