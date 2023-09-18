<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanhviet
  Date: 15/09/2023
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calcultor</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <label for="usd">Enter a mount of dollar:</label>
    <input name="usd" id="usd" type="number"> <br/>
    <label>VND: ${vnd}</label> <br/>
    <input type="submit" value="OK">
</form>
</body>
</html>
