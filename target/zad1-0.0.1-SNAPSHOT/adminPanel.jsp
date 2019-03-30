<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top: 50px;">
		<div class="card" style="width: 75%; margin: auto;">
			<div class="card-body">
				<form action="adminPanel" method="get">
					<table class="table table-bordered" >
						<tr>
							<th>Imię</th>
							<th>Login</th>
							<th>Email</th>
							<th>Premium</th>
						</tr>
						<c:forEach items="${userList}" var="element">
							<tr>
								<td><input type="text" class="form-control" readonly="readonly"
									value="${element.name}" /></td>
								<td><input class="form-control" type="text" readonly="readonly" name="login"
									value="${element.login}" /></td>
								<td><input class="form-control" type="text" readonly="readonly"
									value="${element.email}" /></td>
								<td><input type="checkbox" name="isPremium"
									<c:if test="${element.isPremium}">checked</c:if>
									value="${element.login}"><br></td>
							</tr>
						</c:forEach>

					</table>
					<input type="submit" class="btn btn-primary btn-block"
						name="saveData" value="Zapisz zmiany">
				</form>
			</div>
		</div>
	</div>
</body>
</html>

