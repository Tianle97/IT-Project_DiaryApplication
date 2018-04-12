<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit Diary</title>
	<style>
		.container{
			width:auto;
			height:auto;
			clear: both;
		}
	</style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form modelAttribute="diary" method="POST" action="${contextPath}/editDiary">
	  	<input name="title" type="text" class="form-control" path="title" value="${diary.title}" readOnly/>
	  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	  	<textarea name="note" class="form-control" rows="20"  path="note">${diary.note}</textarea>
	  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	  	<input class="btn btn-lg btn-primary btn-block" type="submit" value="Save"/>
	</form>
</body>
</html>