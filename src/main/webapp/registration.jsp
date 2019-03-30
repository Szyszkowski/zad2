<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<div class="container" style="margin-top: 50px">
    <div class="card" style="width:50%;margin:auto;">
        <div class="card-header"><strong>
            Rejestracja</strong>
        </div>
        <div class="card-body">
            <form action="registration" method="post">
                <div class="form-group">
                    <label>Name:</label> <input class="form-control" type="text"
                                                id="name" name="name"/>
                </div>
                <div class="form-group">
                    <label>Login:</label><input class="form-control" type="text"
                                                id="login" name="login"/>
                </div>
                <div class="form-group">
                    <label>Email:</label><input class="form-control" type="text"
                                                id="email" name="email"/>
                </div>
                <div class="form-group">
                    <label>Hasło:</label><input class="form-control" type="password"
                                                id="password" name="password"/></label>
                </div>
                <div class="form-group">
                    <label>Potwierdz hasło:</label><input class="form-control"
                                                          type="password" id="passwordConfirm" name="passwordConfirm"/>
                </div>
                <input type="submit" class="btn btn-primary btn-block"
                       name="registerButton" value="Wyslij">
            </form>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger" style=margin-top:30px>
                    <strong>${errorMessage}</strong>
                </div>
            </c:if>
        </div>

    </div>
</div>
</body>
</html>