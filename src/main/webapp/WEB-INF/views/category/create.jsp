<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>Add new category</title>
</head>
<body>
    <header>
        <%@include file="../include/navbar.jsp"%>
        <h1 class="text-center">Add new Category</h1>
    </header>
    <main class="container">
        <form:form method="post" action="${pageContext.request.contextPath}/category/save" modelAttribute="category">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <form:input type="text" cssClass="form-control" id="name" placeholder="Category name" path="name" />
                <form:errors path="name" cssClass="alert alert-danger" />
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <form:textarea cssClass="form-control" id="description" rows="3" path="description" placeholder="Category description" />
                <form:errors path="description" cssClass="alert alert-danger" />
            </div>
            <button type="submit" class="btn btn-primary d-flex m-auto">Create</button>
        </form:form>
    </main>
</body>
</html>
