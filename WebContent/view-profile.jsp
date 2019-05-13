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


</head>
<body>
	<div>
		<div>
			<h2 class="display-8" align="center">Your Profile</h2>
			<table class="table table-bordered table-striped">
				<tbody>
					<tr>
						<th scope="row">First Name</th>
						<td>${user.firstName}</td>
					</tr>
					<tr>
						<th scope="row">Last Name</th>
						<td>${user.lastName}</td>
					</tr>
					<tr>
						<th scope="row">Email</th>
						<td>${user.email}</td>
					</tr>
					<tr>
						<th scope="row">Telephone</th>
						<td>${user.telephone}</td>

					</tr>
					<tr>
						<th scope="row">Address</th>
						<td>${user.address}</td>
					</tr>
					<tr>
						<th scope="row">Username</th>
						<td colspan="2">${user.userName}</td>
					</tr>
					<tr>
						<th scope="row">role</th>
						<td>${user.role}</td>
					</tr>
					<tr>
						<th scope="row">Position</th>
						<td>${user.position}</td>
					</tr>
					<tr>
						<th scope="row">Department</th>
						<td colspan="2">${user.department}</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>