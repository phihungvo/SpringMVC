<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="tieuDe"/></title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<header>
	<tiles:insertAttribute name="dauTrang"/>
</header>
<main>
	<nav>
		<tiles:insertAttribute name="thucDon"/>
	</nav>
	<article>
		<tiles:insertAttribute name="noiDung"/>
	</article>
</main>
<footer>
	<tiles:insertAttribute name="cuoiTrang"/>
</footer>
</body>
</html>