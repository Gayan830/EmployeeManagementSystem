<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.center {
	margin: 2% 35%;
}

.color-background {
	/* 	background-color: #0091EA; */
	background-color: #333333;
}
</style>
</head>
<body class="color-background">
	<jsp:include page="header-employee.jsp"></jsp:include>

	<div class="center">
		<div class="jumbotron">
		<div align="center">
			<h2 class="display-6">Notification</h2>
		</div>
			
			<div class="form-row">
				<div>
					<c:forEach var="notification" items="${sessionScope.notifications}" varStatus="loop">
						<c:if test="${notification.notificationApproval == 'yes'}">
							<div class="alert alert-primary" role="alert">
								<form action="NotificationServlet" method="post">
									<label>${notification.message} </label> 
									<input type=hidden name="notificationId" value="${notification.notificationId}"/>
									<input type="submit"
										value="close" class="btn btn-primary">
								</form>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>