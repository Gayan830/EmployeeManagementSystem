<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	margin: 2% 25%;
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
			<h2 class="display-8" align="center">Registration</h2>
			<form action="RegistrationServlet" method="post">
				<div class="form-row">
					<div class="col-md-6 mb-3">
						<label for="validationDefault01">First name</label>
						 <input
							type="text" class="form-control" id="validationDefault01"
							placeholder="First name" name="firstName" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="validationDefault02">Last name</label> 
						<input
							type="text" class="form-control" id="validationDefault02"
							placeholder="Last name" name="lastName" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="validationDefaultUsername">Username</label> 
						<input
							type="text" class="form-control" id="validationDefaultUsername"
							placeholder="Username" aria-describedby="inputGroupPrepend2"
							required name="userName">
					</div>
					<div class="col-md-6 mb-3">
						<label for="password">Password</label> 
						<input
							type="Password" class="form-control"
							id="validationDefaultUsername" placeholder="Password"
							aria-describedby="inputGroupPrepend2" name="password" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="confirm password">Confirm Password</label> <input
							type="Password" class="form-control"
							id="validationDefaultUsername" placeholder="Confirm Password"
							aria-describedby="inputGroupPrepend2" name="confirmPassword" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="email">Email</label> 
						<input
							type="email" class="form-control" id="validationDefaultUsername"
							placeholder="Email" aria-describedby="inputGroupPrepend2" name="email"
							required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="telephone">Telephone</label> <input
							type="text" class="form-control" id="validationDefaultUsername"
							placeholder="Telephone" aria-describedby="inputGroupPrepend2" name="telephone"
							required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="address">Address</label>
						<textarea class="form-control" aria-label="With textarea"
							placeholder="Address" name="address"></textarea>
					</div>

					<div class="col-md-6 mb-3">
						<label for="Role">Role</label> <input type="text"
							class="form-control" id="validationDefault03" placeholder="Role" name="role"
							required>
					</div>

					<div class="col-md-6 mb-3">
						<label for="position">Position</label> 
						<input
							type="text" class="form-control" id="validationDefault03" name="position"
							placeholder="Position" required>
					</div>

					<div class="col-md-6 mb-3">
						<label for="department">Department</label> <input
							type="text" class="form-control" id="validationDefault03" name="department"
							placeholder="Department" required>
					</div>
				</div>

				<div align="center">
					<button class="btn btn-primary" type="submit">Register</button>
				</div>
			</form>
		</div>


	</div>
	
	
	</body>
	</html>