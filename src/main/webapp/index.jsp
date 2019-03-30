<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Strona główna</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
<div class="container" style="margin-top: 200px; text-align: center">
    <div class="card">
        <div class="card-header"><strong>Strona główna</strong></div>
        <div class="card-body">

            <form action="" method="post">
                <input class="btn btn-primary btn-lg" type="submit"
                       formaction="premium" value="Strona premium"> <input
                    class="btn btn-primary btn-lg" type="submit"
                    value="Panel administratora" formaction="adminPanel"> <input
                    class="btn btn-primary btn-lg" type="submit" value="Zaloguj"
                    formaction="login"> <input class="btn btn-primary  btn-lg"
                                               type="submit" value="Zarejestruj" formaction="registration">
                <input class="btn btn-primary btn-lg" type="submit"
                       value="Dane użytkownika" formaction="userData">
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