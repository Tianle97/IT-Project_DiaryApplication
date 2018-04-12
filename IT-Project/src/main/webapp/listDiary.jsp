<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>List Diary Title</title>
		<!-- <style>
			table, th, td {
				border: 1px solid black;
			}
		</style> -->
	</head>

	<body>
		<div class="container">
			<h2 style="color:#FF6347; position: relative; font-size:40px;">Manage your Diary</h2>
			<table class="table table-striped">
				<tr>
				    <th>Title</th>
					<th>Date</th>
					<th>Delete</th>
				</tr>
				<tr>
					<c:forEach items="${diary}" var="d">
						<tr>
							<td><a href='editDiary?title=<c:out value="${d.title}"/>'/>${d.title}</td>
							<td>${d.date}</td>
							<td><a href='deleteDiary?title=<c:out value="${d.title}"/>'/>delete</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
			<input class="btn btn-lg btn-primary btn-block" type="button" value="back" onclick = "window.location.href = 'diary'"/>
		</div>
	</body>
</html>