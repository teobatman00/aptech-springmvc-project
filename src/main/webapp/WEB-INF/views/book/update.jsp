<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>Update book</title>
</head>
<body>
    <header>
        <%@include file="../include/navbar.jsp"%>
        <h1 class="text-center">Update book</h1>
    </header>
    <main class="container">
        <div class="card-body p-sm-5">
            <form:form method="post" action="${pageContext.request.contextPath}/book/update" modelAttribute="bookUpdate">
                <div class="mb-3">
                    <form:input id="name-2" cssClass="form-control" type="text" name="name" placeholder="Name"  path="name" />
                </div>
                <div class="mb-3">
                    <form:textarea cssClass="form-control" name="description" placeholder="Description" path="description" />
                </div>
                <div class="mb-3">
                    <form:input cssClass="form-control" type="text" placeholder="Author"  path="author"/>
                </div>
                <div class="mb3">
                    <img src="data:image/**;base64, ${bookUpdate.oldAvatar}" alt="Image" width="200px">
                </div>
                <div class="mb-3">
                    <form:label cssClass="form-label" path="avatar">Avatar</form:label><br>
                    <form:input type="file" cssClass="form-control"  path="avatar"/>
                </div>
                <div class="mb-3">
                    <form:label path="published" cssClass="form-label">Is Published</form:label>
                    <form:select path="published" cssClass="form-control">
                        <form:option value="false">No</form:option>
                        <form:option value="true">Yes</form:option>
                    </form:select>
                </div>
                <div class="mb-3">
                    <form:label path="publishedDate" cssClass="form-label">Published Date</form:label>
                    <form:input path="publishedDate" cssClass="form-control" id="publishedDate"/>
                </div>
                <div class="mb-3">
                    <form:label path="categoryId" cssClass="form-label">Category</form:label>
                    <form:select path="categoryId" title="Category Select" cssClass="form-control">
                        <form:option value="NONE">--Select--</form:option>
                        <form:options items="${categories}" itemValue="id" itemLabel="name" />
                    </form:select>
                </div>
                <button class="btn btn-primary d-block w-100" type="submit">Create</button>
            </form:form>
        </div>
    </main>
</body>
<script type="text/javascript">
    $(function () {
        $("#publishedDate").datepicker();
    });
</script>
</html>
