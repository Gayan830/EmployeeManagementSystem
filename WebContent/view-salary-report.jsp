<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.center {
	margin: 2% 35%;
}
tr>td{
	width:10%;
}
.color-background {
	background-color: #333333;
}
</style>
</head>
<body class="color-background">
	<jsp:include page="header-manager.jsp"></jsp:include>

	<div class="center">
		<div class="jumbotron">
			<div align="center">
				<h2 class="display-6">Results</h2>
			</div>
			<div align="center">
				<table>
					<tr>
						<td>Report Date</td>
						<td align="right">${sessionScope.report.date}</td>
					</tr>
					<tr>
						<td>Days Worked</td>
						<td align="right">${sessionScope.report.daysWorked}</td>
					</tr>
					<tr>
						<td></td>
						<td align="right">${sessionScope.report.salary}</td>
					</tr>
					<tr>
						<td>Compensation</td>
						<td align="right">${sessionScope.report.compasanation}</td>
					</tr>
					<tr>
						<td>Deduction</td>
						<td align="right">${sessionScope.report.deduction}</td>
					</tr>
					<tr>
						<td></td>
						<td align="right">--------------------</td>
					</tr>
					<tr>
						<td>Payment</td>
						<td align="right">${sessionScope.report.payment}</td>
					</tr>
					<tr>
						<td></td>
						<td align="right">---------------------</td>
					</tr>
				</table>
				<form action="SalaryReport" method="post">
					<input class="btn btn-primary" type="submit" value="Send Report for Approval" />
				</form>
			</div>
		</div>
	</div>







</body>
</html>