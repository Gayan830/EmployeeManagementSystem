<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style type="text/css">
.center {
	margin: 7% 35%;
}

.color-background {
	background-color: #0091EA;
}
</style>
</head>
<body class="color-background">
	<jsp:include page="header-home.jsp" />

	<div class="center">
		<div class="jumbotron">
			<h1 class="display-6" align="center">Login</h1>
			<% if(request.getAttribute("error") != null){ %>
			<div class="alert alert-danger" role="alert">
				<%=request.getAttribute("error") %>
			</div>
			<%} %>
			<form method="post" action="LoginServlet">
				<div class="form-group">
					<label for="exampleInputEmail1">Username</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="userName"
						aria-describedby="emailHelp" placeholder="Enter Username">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						name="password" type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Password">
				</div>
				<div align="center">
					<button type="submit" class="btn btn-lg btn-primary">Login</button>
				</div>
			</form>
		</div>


	</div>














	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>