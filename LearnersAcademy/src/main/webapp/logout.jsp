<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learners Academy</title>
</head>
<body>
	<%
		session.removeAttribute("id");
		session.invalidate();
		response.sendRedirect("index.jsp");
	%>
</body>
</html>