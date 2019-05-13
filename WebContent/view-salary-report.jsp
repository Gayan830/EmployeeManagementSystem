<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("report") %>
 ${sessionScope.report.daysWorked}<br>
 ${sessionScope.report.compasanation}<br>
 ${sessionScope.report.date}<br>
 ${sessionScope.report.payment}<br>
 ${sessionScope.report.deduction}<br>
 ${sessionScope.report.salary}<br>
</body>
</html>