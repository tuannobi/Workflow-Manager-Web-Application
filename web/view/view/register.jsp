<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/bootstrap/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/view/static/css/register.css">
</head>
<body>
<div class="container-fluid d-flex align-items-center justify-content-center">



    <form method="post" action="register/process">
        <c:if test="${not empty sessionScope.alert}">
            <div class="alert alert-danger"><c:out value="${sessionScope.alert}"/> </div>
        </c:if>
        <div class="form-group">
            <label for="displayName">Tên hiển thị</label>
            <input type="text" class="form-control" id="displayName" name="displayName">
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Ghi nhớ đăng nhập</label>
        </div>
        <button type="submit" class="btn btn-primary">Đăng ký</button>
    </form>
</div>

</body>
</html>