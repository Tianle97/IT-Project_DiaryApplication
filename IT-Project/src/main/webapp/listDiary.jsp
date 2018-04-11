<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<style>
		table, th, td {
			border: 1px solid black;
		}
	</style>
</head>

<body>
	<h1><b>List Diary</b></h1>
	<br>
	<table>
		<tr>
			<th>Title</th>
			<th>Date</th>
		</tr>
		<tr>
			<c:forEach items="${diary}" var="d">
				<tr>
					<td><a href='editDiary?title=<c:out value="${d.title}"/>'/>${d.title}</td>
					<td>${d.date}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<input class="btn btn-lg btn-primary btn-block" type="button" value="back" onclick = "window.location.href = 'diary'"/>
</body>
</html>