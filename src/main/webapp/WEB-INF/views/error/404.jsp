<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/19/2022
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>404 Error</title>
</head>
<body>
    <h1 class="text-center">Page not found</h1>
    <c:if test="${errorMessage}">
        <p>${errorMessage}</p>
    </c:if>
</body>
</html>
