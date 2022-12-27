<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>List Role</title>
</head>
<body>
    <header>
        <%@include file="../include/navbar.jsp"%>
        <h1 class="text-center">List Role</h1>
    </header>
    <main class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <th scope="row">
                        <a href="${pageContext.request.contextPath}/category/detail/${role.id}">${role.id}</a>
                    </th>
                    <td>${role.name}</td>
                    <td>${role.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>
