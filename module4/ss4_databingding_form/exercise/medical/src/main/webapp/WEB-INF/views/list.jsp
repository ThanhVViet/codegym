<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-11">
            <h2 class="text-center">DANH SÁCH KHAI BÁO Y TẾ</h2>
        </div>
        <div class="col-1 text-end">
            <a class="btn btn-success" href="/create">ADD</a>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Year of Birth</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${medicalList}">
            <tr>
                <td>${e.fullName}</td>
                <td>${e.yearBirth}</td>
                <td>${e.phone}</td>
                <td>
                    <a href="/create/${e.id}" class="btn btn-primary btn-sm">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-nuVAYRRg3nWfWg9OXJ8F3JvxCK2+w0kqMKIlgYO47jGpgzHgmeHSh0CZxTjtkSqc"
        crossorigin="anonymous"></script>
</body>
</html>
