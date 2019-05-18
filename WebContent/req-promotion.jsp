<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style type="text/css">
.center {
	margin: 2% 35%;
}

.color-background {
	background-color: #0091EA;
}
</style>
<title>Hello, world!</title>
</head>
<body class="color-background">
	<jsp:include page="header-employee.jsp" />
	<div class="center">
		<div class="jumbotron">
			<h2 class="display-8" align="center">Promotion Form</h2>
			<form action="PromotionRequestServlet" method="post">
				<div class="form-row">
					<div class="col-md-12 mb-3">
						<label for="validationDefault01">First name</label> <input
							type="text" class="form-control" id="validationDefault01"
							placeholder="First name" name="firstName" required>
					</div>
					<div class="col-md-12 mb-3">
						<label for="validationDefault02">Last name</label> <input
							type="text" class="form-control" id="validationDefault02"
							placeholder="Last name" name="lastName" required>
					</div>
					<div class="col-md-12 mb-3">
						<label for="yearsWorked">Years Worked</label> <select
							class="form-control" id="exampleFormControlSelect1"
							name="yearsWorked">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select>
					</div>
					<div class="col-md-12 mb-3">
						<label for="Role">Department</label> <select class="form-control"
							id="exampleFormControlSelect1" name="department">
							<option>Accounting</option>
							<option>Engineering</option>
							<option>Information Technology</option>
							<option>Finance</option>
						</select>
					</div>

					<div class="col-md-12 mb-3">
						<label for="Role">Current Positon</label> 
						<select
							class="form-control" id="exampleFormControlSelect1"
							name="position">
							<option>assistant software engineer</option>
							<option>software engineer</option>
							<option>senior software engineer</option>
							<option>assistant accountant</option>
							<option>accountant</option>
							<option>senior accountant</option>
							<option>elctronic engineer</option>
							<option>assistant electronic engineer</option>
							<option>senior electronic engineer</option>
							<option>tech lead</option>
							<option>project manager</option>
							<option>network engineer</option>
							<option>associate tech lead</option>
						</select>
					</div>

					<div align="center">
						<button class="btn btn-primary" type="submit">Submit</button>
					</div>
				</div>
			</form>
		</div>


	</div>
	<jsp:include page="footer.jsp" />
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