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
	margin: 2% 12%;
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
		<c:otherwise>
			<jsp:include page="header-employee.jsp" />
		</c:otherwise>
	</c:choose>

	<div class="center">
		<div class="jumbotron">
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<div class="nav flex-column nav-pills" id="v-pills-tab"
						role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="v-pills-home-tab"
							data-toggle="pill" href="#v-pills-home" role="tab"
							aria-controls="v-pills-home" aria-selected="true"> View
							Profile </a> <a class="nav-link" id="v-pills-profile-tab"
							data-toggle="pill" href="#v-pills-profile" role="tab"
							aria-controls="v-pills-profile" aria-selected="false"> Edit
							Profile </a>
					</div>
				</div>
				<div class="col-md-9 mb-3">
					<div class="tab-content" id="v-pills-tabContent">
						<div class="tab-pane fade show active" id="v-pills-home"
							role="tabpanel" aria-labelledby="v-pills-home-tab">
							<jsp:include page="view-profile.jsp" />
						</div>

						<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
							aria-labelledby="v-pills-profile-tab">
							<jsp:include page="edit-profile.jsp" />
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>
	<jsp:include page="footer.jsp" />
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