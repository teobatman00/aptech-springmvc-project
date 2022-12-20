<%--
  Created by IntelliJ IDEA.
  User: Son Thai
  Date: 12/18/2022
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="col">
                <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png" />
                    <div class="card-body p-4">
                        <h4 class="card-title">Lorem libero donec</h4>
                        <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                        <div class="d-flex justify-content-evenly">
                            <button class="btn btn-primary" type="button">Detail</button>
                            <button class="btn btn-primary" type="button">Update</button>
                            <button class="btn btn-primary" type="button">Delete</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png" />
                    <div class="card-body p-4">
                        <h4 class="card-title">Lorem libero donec</h4>
                        <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                        <div class="d-flex justify-content-evenly">
                            <button class="btn btn-primary" type="button">Detail</button>
                            <button class="btn btn-primary" type="button">Update</button>
                            <button class="btn btn-primary" type="button">Delete</button>
                        </div>
                    </div>

                </div>
            </div>
            <div class="col">
                <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png" />
                    <div class="card-body p-4">
                        <h4 class="card-title">Lorem libero donec</h4>
                        <p class="card-text">Nullam id dolor id nibh ultricies vehicula ut id elit. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus.</p>
                        <div class="d-flex justify-content-evenly">
                            <button class="btn btn-primary" type="button">Detail</button>
                            <button class="btn btn-primary" type="button">Update</button>
                            <button class="btn btn-primary" type="button">Delete</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
