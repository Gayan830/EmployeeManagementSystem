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
			<%
				if (request.getAttribute("message") != null) {
			%>
			<div class="alert alert-danger" role="alert">
				<%=request.getAttribute("message")%>
			</div>
			<%
				}
			%>
			<form action="RegistrationServlet" method="post">
				<div class="form-row">
					<div class="col-md-6 mb-3">
						<label for="validationDefault01">First name</label> <input
							type="text" class="form-control" id="validationDefault01"
							placeholder="First name" name="firstName" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="validationDefault02">Last name</label> <input
							type="text" class="form-control" id="validationDefault02"
							placeholder="Last name" name="lastName" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="validationDefaultUsername">Username</label> <input
							type="text" class="form-control" id="validationDefaultUsername"
							placeholder="Username" aria-describedby="inputGroupPrepend2"
							required name="userName">
					</div>
					<div class="col-md-6 mb-3">
						<label for="password">Password</label> <input type="Password"
							class="form-control" id="validationDefaultUsername"
							placeholder="Password" aria-describedby="inputGroupPrepend2"
							name="password" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="confirm password">Confirm Password</label> <input
							type="Password" class="form-control"
							id="validationDefaultUsername" placeholder="Confirm Password"
							aria-describedby="inputGroupPrepend2" name="confirmPassword"
							required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="validationDefaultUsername"
							placeholder="Email" aria-describedby="inputGroupPrepend2"
							name="email" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="telephone">Telephone</label> <input type="text"
							class="form-control" id="validationDefaultUsername"
							placeholder="Telephone" aria-describedby="inputGroupPrepend2"
							name="telephone" required>
					</div>


					<div class="col-md-6 mb-3">
						<label for="Role">Role</label> <select name="role"
							class="custom-select">
							<option value="employee">Employee</option>
							<option value="admin">Admin</option>
							<option value="manager">Manager</option>
						</select>
					</div>

					<div class="col-md-6 mb-3">
						<label for="position">Position</label> <select name="position"
							class="custom-select">
							<option value="assistant software engineer">assistant
								software engineer</option>
							<option value="software engineer">software engineer</option>
							<option value="senior software engineer">senior software
								engineer</option>
							<option value="assistant accountant">assistant
								accountant</option>
							<option value="accountant">accountant</option>
							<option value="senior accountant">senior accountant</option>
							<option value="elctronic engineer">elctronic engineer</option>
							<option value="assistant electronic engineer">assistant
								electronic engineer</option>
							<option value="senior electronic engineer">senior
								electronic engineer</option>
							<option value="tech lead">tech lead</option>
							<option value="project manager">project manager</option>
							<option value="network engineer">network engineer</option>
							<option value="associate tech lead">associate tech lead</option>
							<option value="manager">manager</option>
						</select>
					</div>

					<div class="col-md-6 mb-3">
						<label for="department">Department</label> <input type="text"
							class="form-control" id="validationDefault03" name="department"
							placeholder="Department" required>
					</div>
				</div>

				<div class="col-md-6 mb-3">
					<label for="address">Address</label>
					<textarea class="form-control" aria-label="With textarea"
						placeholder="Address" name="address"></textarea>
				</div>

				<div align="center">
					<button class="btn btn-primary" type="submit">Register</button>
				</div>
			</form>
		</div>


	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>