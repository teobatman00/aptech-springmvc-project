<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>Book Detail ${book.id}</title>
</head>
<body>
    <header>
        <%@include file="../include/navbar.jsp"%>
        <h1 class="text-center">Book ${book.id}</h1>
    </header>
    <main class="container">
        <div class="row">
            <div class="col-2">Name</div>
            <div class="col-10">${book.name}</div>
        </div>
        <div class="row">
            <div class="col-2">Description</div>
            <div class="col-10">${book.description}</div>
        </div>
        <div class="row">
            <div class="col-2">Author</div>
            <div class="col-10">${book.author}</div>
        </div>
        <div class="row">
            <div class="col-2">Avatar</div>
            <div class="col-10">
                <img src="data:image/**;base64, ${book.avatar}" alt="Image" width="300px">
            </div>
        </div>
    </main>
</body>
</html>
