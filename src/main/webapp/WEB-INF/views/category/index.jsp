<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>Category List</title>
</head>
<body>
<header>
    <%@include file="../include/navbar.jsp"%>
    <h1 class="text-center">Category List</h1>
</header>
<main class="container">
    <div class="py-2">
        <a href="${pageContext.request.contextPath}/category/new" class="btn btn-success">Add</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <th scope="row">
                    <a href="${pageContext.request.contextPath}/category/detail/${category.id}">${category.id}</a>
                </th>
                <td>${category.name}</td>
                <td>${category.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>
