<jsp:useBean id="ex" scope="request" type="java.lang.Exception"/>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/19/2022
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>500 Error</title>
</head>
<body>
    <h1 class="text-center">Server internal error</h1>
    <p>Failed URL: ${url}</p>
    <p>Exception: ${cause} ${ex.message}</p>
    <c:forEach items="${ex.stackTrace}" var="ste">
        <p>${ste}</p>
    </c:forEach>
</body>
</html>
