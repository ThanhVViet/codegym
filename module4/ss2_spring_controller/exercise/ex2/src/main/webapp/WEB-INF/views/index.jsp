<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <div>
        <input type="number" id="lettuce" name="n1">
        <label for="lettuce"> Nhập số thu nhất </label><br>
        <input type="number" id="tomato" name="n2">
        <label for="tomato"> Nhập số thứ hai </label><br>
        <input type="hidden" name="operator" id="operator">
    </div>

    <div>
        <button type="submit" onclick="document.getElementById('operator').value = '+'">Addition (+)</button>
        <button type="submit" onclick="document.getElementById('operator').value = '-'">Subtraction (-)</button>
        <button type="submit" onclick="document.getElementById('operator').value = '*'">Multiplication (*)</button>
        <button type="submit" onclick="document.getElementById('operator').value = '/'">Division (/)</button>
    </div>
    <hr>
</form>
<c:if test="${not empty result}">
    Result: ${result}
</c:if>
</body>
</html>