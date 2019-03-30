<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top: 50px;">
		<div class="card" style="width: 50%; margin: auto;">
			<div class="card-body">
				<form action="login" method="get">
					<div class="form-group">
						<label>Login:</label><input class="form-control" type="text"
							id="login" name="login" />
					</div>
					<div class="form-group">
						<label>Hasło:</label><input class="form-control" type="password"
							id="password" name="password" />
					</div>
					<input class="btn btn-primary btn-block" type="submit" name="loginButton"
						value="wyslij">

				</form>
				<div class="alert alert-danger ${errorMessage ? '' : 'collapse'}"
					style="margin-top: 50px">${errorMessage}</div>
			</div>
		</div>
	</div>
</body>
</html>