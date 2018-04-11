<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="java">
	<head>
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
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Welcome to MyDiary</title>
	
	    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	<div class="container">
		<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">ListDiary</button>
		  <div id="demo" class="collapse">
		  	<ol>
				<c:forEach items="${title}" var="t">
					<li>${title}</li>
				</c:forEach>
		 	</ol>
		  </div>
	  <div class="dropdown">
		   <c:if test="${pageContext.request.userPrincipal.name != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>
		        <form id="new" method="GET" action="${contextPath}/diary">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>
	            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Explore <span class="caret"></span></button>
			    <ul class="dropdown-menu">
		    	  <li><a onclick="document.forms['new'].submit()">New</a></li>
			      <li><a href="listDiary">my diary</a></li>
			      <li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li>
			    </ul>
		    </c:if>
	  	</div>
	  	<form method="POST" modelAttribute="diaryForm" action="${contextPath}/diary">
		  	<input name="title" type="text" class="form-control" placeholder="title" path="title" />
		  	<textarea name="note" class="form-control" rows="20" path="note"></textarea>
		  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  	<input class="btn btn-lg btn-primary btn-block" type="submit" value="Save"/>
		</form>
	</div>
	<!-- /container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>