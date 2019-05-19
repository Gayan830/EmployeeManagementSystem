<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Promotion Request</title>
</head>
<body>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">No</th>
				<th scope="col">Name</th>
				<th scope="col">Current Position</th>
				<th scope="col">Years worked</th>
				<th scope="col">Department</th>
				<th scope="col">Approval</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="promotion" items="${sessionScope.promotions}" varStatus="loop">


				<tr>
					<td>${loop.count}</td>
					<td>${promotion.firstName} ${promotion.lastName}</td>
					<td>${promotion.currentPosition}</td>
					<td>${promotion.yearsWorked}</td>
					<td>${promotion.department}</td>
					<c:choose>
						<c:when test="${promotion.managerApproval == 'yes'}">
							<td>Approved</td>
						</c:when>
						<c:otherwise>
							
							<td align="center">
								<form action="ListEmployees" method="get">
									<select name="pos" class="custom-select">
										<c:forEach items="${positions}" var="position">
											<option value="${position}">${position}</option>
										</c:forEach>
									</select>
									<input type="hidden" value="APPROVE" name="command"/>
									<input type="hidden" value="${promotion.employeeId}" name="id"/>
									<input type="submit" class="btn btn-primary" value="Approve" />	
								</form> 
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>