<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <title>Log in with your account</title>
	    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	    <link href="${contextPath}/resources/css/login.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
		<h2 style="color:#FF6347;position: relative;left: 60px;top: 180px;
			font-size:40px;"><b>^_^Welcome to diary~</b></h2>
		    <form method="POST" action="${contextPath}/login" class="form-signin" >
		        <span class="form-heading"><b>Log-in Please</b></span>
		        <div class="form-group ${error != null ? 'has-error' : ''}">
		            <span>${message}</span>
		            <input name="username" type="text" class="form-control" placeholder="Username"
		                   autofocus="true"/>
		            <i class="fa fa-user"></i>
		            <input name="password" type="password" class="form-control" placeholder="Password"/>
		            <i class="fa fa-lock"></i>
		            <span>${error}</span>
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		            <button class="btn btn-lg btn-primary btn-block" type="submit" >Log In</button>
		            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
		        </div>
		    </form>
		</div>
		<!-- /container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>