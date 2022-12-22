<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="../include/head.jsp"%>
    <title>Category Detail ${category.id}</title>
</head>
<body>
    <header>
        <%@include file="../include/navbar.jsp"%>
        <h1 class="text-center">Category Detail ${category.id}</h1>
    </header>
    <main class="container">
        <div class="mb-2">
            <a href="${pageContext.request.contextPath}/category/list" class="btn btn-primary">Go back</a>
        </div>
        <div class="row">
            <div class="col-2">Name</div>
            <div class="col-10">${category.name}</div>
        </div>
        <div class="row">
            <div class="col-2">Description</div>
            <div class="col-10">${category.description}</div>
        </div>
        <div class="mt-2">
            <a href="${pageContext.request.contextPath}/category/load/${category.id}" class="btn btn-warning">Update</a>
            <button type="button" class="btn btn-danger" onclick="deleteCategory(${category.id})">Delete</button>
        </div>
    </main>
</body>
<script type="text/javascript">
    function deleteCategory(categoryId) {
        let confirmed = confirm("Would you like to delete category " + categoryId)
        if (confirmed) {
            $.ajax({
                url: "${pageContext.request.contextPath}/category/delete/" + categoryId,
                method: 'POST',
                success: function () {
                    alert("Delete category " + categoryId + " success")
                }
            })
        }
    }
</script>
</html>
