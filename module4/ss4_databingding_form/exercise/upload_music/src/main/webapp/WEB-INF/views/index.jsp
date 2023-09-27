<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Music</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            border: 1px solid;
            table-layout: fixed;
        }

        table td {
            border: 1px solid;
            text-align: center;
        }

        tr:hover {
            background-color: blue;
        }

        table th:first-child {
            width: 5%;
        }

        table th:last-child {
            width: 30%;
        }
    </style>
</head>
<body>
<div>
    <h1>List Song</h1>
    <a href="/add">Add new</a>
</div>
<table>
    <thead>
    <th>Name</th>
    <th>Artist</th>
    <th>Genre</th>
    <th>Link</th>
    </thead>
    <tbody>
    <c:forEach var="e" items="${res}">
        <tr>
            <td><c:out value="${e.name}"/></td>
            <td>${e.artist}</td>
            <td>${e.genre}</td>
            <td>
                <audio controls><source src="<c:url value="${e.link}"/>" type="audio/wav">
                </audio>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
