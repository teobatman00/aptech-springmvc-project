<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>Title</title>
</head>
<body>
    <header>
        <%@include file="../include/navbar.jsp"%>
        <h1 class="text-center">This is book list</h1>
    </header>
    <main class="container">
        <a href="${pageContext.request.contextPath}/book/new" class="btn btn-success my-3">Add</a>
        <div class="row gy-4 row-cols-1 row-cols-md-2 row-cols-xl-3">
            <c:forEach items="${books}" var="book">
                <div class="col">
                    <div class="card">
                        <img class="card-img-top w-100 d-block fit-cover" style="height: 200px;"
                             src="data:image/**;base64, ${book.avatar}"  alt="Image"/>
                        <div class="card-body p-4">
                            <h4 class="card-title">${book.name}</h4>
                            <p class="card-text">${book.description}</p>
                            <div class="d-flex justify-content-evenly">
                                <a href="${pageContext.request.contextPath}/book/detail/${book.id}" class="btn btn-primary">Detail</a>
                                <a href="${pageContext.request.contextPath}/book/load/${book.id}" class="btn btn-warning" >Update</a>
                                <a href="${pageContext.request.contextPath}/book/delete/${book.id}" class="btn btn-danger">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>
</body>
</html>
