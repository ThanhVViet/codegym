<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich" method="post">
    <input type="checkbox" id="lettuce" name="condiment" value="Lettuce">
    <label for="lettuce"> Lettuce</label><br>
    <input type="checkbox" id="tomato" name="condiment" value="Tomato">
    <label for="tomato"> Tomato</label><br>
    <input type="checkbox" id="mustard" name="condiment" value="Mustard">
    <label for="mustard"> Mustard</label><br>
    <input type="checkbox" id="sprouts" name="condiment" value="Sprouts">
    <label for="sprouts"> Sprouts</label><br><br/>
    <hr>
    <input type="submit" value="Save">
</form>

<c:if test="${not empty condiment}">
    Result: ${condiment}
</c:if>
</body>
</html>