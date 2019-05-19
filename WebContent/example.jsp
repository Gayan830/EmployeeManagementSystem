<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.empmanagement.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link rel="stylesheet" href="css/style.css">
<style type="text/css">
	.center-content {
	margin: 13% 20%;
	text-align:center;
	}
	.color-background {
	background-color: #333333;
}
</style>
</head>
<body class="color-background">

	<c:choose>
		<c:when test="${sessionScope.user.role == 'manager'}">
			<jsp:include page="header-manager.jsp" />
		</c:when>
		<c:when test="${sessionScope.user.role == 'admin'}">
			<jsp:include page="header-admin.jsp" />
		</c:when>
		<c:when test="${sessionScope.user.role == 'employee'}">
			<jsp:include page="header-employee.jsp" />
		</c:when>
	</c:choose>
	<div class="site-wrapper-inner"></div>

	<div class="inner cover center-content">
		<div align="center">
			<img style="width:100px;height:100px;" src="images/des-logo-icon.png"/>
		</div>
		<h1 class="cover-heading text-white">Welcome!</h1>
		<p class="lead text-white">This is a Employee Management System
			and It has various functionalities to manage employees and fulfill
			the Company needs</p>
	</div>


	<jsp:include page="footer.jsp" />
</body>
</html>