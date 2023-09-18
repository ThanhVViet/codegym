<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanhviet
  Date: 18/09/2023
  Time: 07:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check</title>
</head>
<body>
<h1>List of Condiments </h1>
<ul>
<c:forEach items="${condiment}" var="condiment" >
    <li>${condiment}</li>
</c:forEach>
</ul>
</body>
</html>
