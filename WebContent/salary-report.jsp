<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Dashboard</title>
</head>
<body>
	<form class="form-inline" action="ListEmployees" method="get">
	<input type="hidden" name="command" value="SEARCH"/>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Employee</label>
			</div>
			<select name="employee" class="custom-select">
				<c:forEach items="${userList}" var="user">
					<option value="${user.employeeId}">${user.firstName}
					${user.lastName}</option>
				</c:forEach>
			</select>


			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Month</label>
			</div>
			<select name="month" class="custom-select">
				<c:forEach items="${sessionScope.months}" var="month">
					<option value="${month}">${month}</option>
				</c:forEach>
			</select>

			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Year</label>
			</div>
			<select name="year" class="custom-select">
				<c:forEach items="${sessionScope.years}" var="year">
					<option value="${year}">${year}</option>
				</c:forEach>
			</select>
			<button type="submit">Search</button>

		</div>
	</form>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Year</th>
				<th scope="col">Month</th>
				<th scope="col">Day</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="work" items="${sessionScope.works}">
				<tr>
					<td>${work.year}</td>
					<td>${work.month}</td>
					<td>${work.type}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	
		<a href="SalaryReportServlet" class="btn btn-primary">Calculate Salary</a>


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