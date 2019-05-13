<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body class="color-background">

	<div class="center">
			<h2 class="display-8" align="center">Edit Details</h2>
			<form action="profileServlet" method="post">
				<div class="form-row">
					<div class="col-md-6 mb-3">
						<label ">First name</label>
						 <input
							type="text" class="form-control" 
							placeholder="First name" name="firstName" value="${user.firstName}"  required>
					</div>
					<div class="col-md-6 mb-3">
						<label>Last name</label> 
						<input
							type="text" class="form-control"
							placeholder="Last name" name="lastName" value="${user.lastName}" required>
					</div>
					<div class="col-md-6 mb-3">
						<label>Username</label> 
						<input
							type="text" class="form-control" 
							placeholder="Username" aria-describedby="inputGroupPrepend2"
							required name="userName" value="${user.userName}">
					</div>
					<div class="col-md-6 mb-3">
						<label for="password">Password</label> 
						<input
							type="Password" class="form-control"
							 placeholder="Enter new pSassword"
							aria-describedby="inputGroupPrepend2" name="password" required>
					</div>
					<div class="col-md-6 mb-3">
						<label >Confirm Password</label> <input
							type="Password" class="form-control"
							 placeholder="Confirm Password"
							aria-describedby="inputGroupPrepend2" name="confirmPassword" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="email">Email</label> 
						<input
							type="email" class="form-control" 
							placeholder="Email" aria-describedby="inputGroupPrepend2" name="email"
							 value="${user.email}" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="telephone">Telephone</label> <input
							type="text" class="form-control" 
							placeholder="Telephone" aria-describedby="inputGroupPrepend2" name="telephone"
							value="${user.telephone}" required >
					</div>
					<div class="col-md-6 mb-3">
						<label for="address">Address</label>
						<textarea class="form-control" aria-label="With textarea"
							placeholder="Address" name="address" >${user.address}</textarea>
					</div>

					<div class="col-md-6 mb-3">
						<label for="Role">Role</label> <input type="text"
							class="form-control" placeholder="Role" name="role" value="${user.role}"
							required>
					</div>

					<div class="col-md-6 mb-3">
						<label for="position">Position</label> 
						<input
							type="text" class="form-control" id="validationDefault03" name="position"
							placeholder="Position" value="${user.position}" required>
					</div>

					<div class="col-md-6 mb-3">
						<label for="department">Department</label> <input
							type="text" class="form-control" name="department"
							placeholder="Department" value="${user.department}" required>
					</div>
				</div>

				<div align="center">
					<button class="btn btn-primary" type="submit">Submit</button>
				</div>
			</form>
	</div>
</body>
</html>