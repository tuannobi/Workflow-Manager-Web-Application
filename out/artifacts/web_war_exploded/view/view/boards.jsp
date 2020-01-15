<%--
  Created by IntelliJ IDEA.
  User: Tuan
  Date: 1/13/2020
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Boards</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/bootstrap/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/view/static/css/login.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/view/static/css/boards.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/icon/fontawesome-pro-5.12.0-web/css/all.css">
</head>
<body>

<!-- Create Popup -->
<div id="background-popup" class="hide d-flex align-items-center justify-content-center">
    <form method="post" id="form">
    <div id="board-popup-create">
        <div id="board-popup-create-header">
            <div class="form-group p-3">
                <label for="board-popup-create-title">Title</label>
                <input type="text" name="board-popup-create-title" id="board-popup-create-title">
            </div>
        </div>
        <div id="board-popup-create-body" class="container">
            <div class="form-group row">
                <label class="col-3" for="board-popup-create-body-start">Start Date</label>
                <div class="col-9">
                <input type="datetime-local" name="board-popup-create-body-start" id="board-popup-create-body-start">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-3" for="board-popup-create-body-end">End date</label>
                <div class="col-9">
                <input type="datetime-local" name="board-popup-create-body-end" id="board-popup-create-body-end">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-3" for="board-popup-create-body-description">Description</label>
                <div class="col-9">
                <textarea cols="32" rows="5" name="board-popup-create-body-description" id="board-popup-create-body-description"></textarea>
                </div>
                </div>
        </div>
        <div id="board-popup-create-button" class="container">
            <input class="m-3 btn btn-primary" value="Create" type="submit" name="board-popup-create-body-submit">
            <input class="m-3 btn btn-danger" value="Cancel" type="button" name="board-popup-create-body-cancel">
        </div>
    </div>
    </form>
</div>
<!-- /Create Popup -->


    <div class="container-fluid">
        <!-- HEADER-->
        <div class="row header-top">
            <div class="col">
                <i class="far fa-home fa-2x"></i>
            </div>
            <div class="col align-content-center header-top">
                Tuno-Workflow-Managerment
            </div>
            <div class="col header-top">
                <div class="float-right">
                    <div class="h-100 justify-content-center d-inline-block h-100"><a href="#" >Welcome ${sessionScope.user.displayName}</a></div>
                    <a href="${pageContext.request.contextPath}/logout"><i class="far fa-info-circle fa-2x"></i></a>
                </div>
            </div>
        </div>
        <!-- /HEADER-->

        <!--BODY-->
        <div class="row">
            <!--Left bar here -->
            <jsp:include page="nav-left.jsp"/>
            <div class="col-9">
                <div id="recentlyBoard-container">
                    <h2>Recently Board</h2>
                    <a href="#">
                        <div>
                            Create
                        </div>
                    </a>
                </div>

                <div id="personalBoards-container">
                    <h2>Personal Boards</h2>
                    <c:if test="${not empty boardList}">
                        <c:forEach var="board" items="${boardList}">
                            <a href="#" class="float-left p-2 m-2">
                                <div id="" class="board-display-group ">
                                    <h5>${board.tile}</h5>
                                    <c:if test="${not empty board.modifiedLastestDate}">
                                        <h6>${board.modifiedLastestDate}</h6>
                                    </c:if>
                                </div>
                            </a>
                        </c:forEach>
                    </c:if>
                    <a id="board-display-create-a" href="#" class="float-left p-2 m-2">
                        <div id="board-display-create" class="align-items-center justify-content-center">
                            Create new board
                        </div>
                    </a>
                </div>

            </div>
        </div>
        <!--/BODY-->
    </div>
<script src="${pageContext.request.contextPath}/view/static/jquery/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/static/js/boards.js"></script>
</body>
</html>
