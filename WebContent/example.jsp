<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.empmanagement.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header-manager.jsp" />
	<%=session.getAttribute("user") %>
	<% User user = (User) session.getAttribute("user"); %>
	 <%=user.getEmployeeId() %>
</body>
</html>