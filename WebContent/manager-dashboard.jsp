<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header-manager.jsp" />
	<div class="center">
		<div class="jumbotron">
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<div class="nav flex-column nav-pills" id="v-pills-tab"
						role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="v-pills-home-tab"
							data-toggle="pill" href="#v-pills-home" role="tab"
							aria-controls="v-pills-home" aria-selected="true">Calculate
							Salaries</a> <a class="nav-link" id="v-pills-profile-tab"
							data-toggle="pill" href="#v-pills-profile" role="tab"
							aria-controls="v-pills-profile" aria-selected="false">Promotion
							Requests </a><a class="nav-link" id="v-pills-profile-tab"
							data-toggle="pill" href="#v-pills-profile" role="tab"
							aria-controls="v-pills-profile" aria-selected="false">Loan
							Requests </a>
					</div>
				</div>
				<div class="col-md-9 mb-3">
					<div class="tab-content" id="v-pills-tabContent">
						<div class="tab-pane fade show active" id="v-pills-home"
							role="tabpanel" aria-labelledby="v-pills-home-tab">
							<h2 class="display-8" align="center">Edit Details</h2>
							
						</div>
					</div>
					<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
						aria-labelledby="v-pills-profile-tab">...</div>
				</div>
			</div>
		</div>




	</div>


</body>
</html>