<%--
  Created by IntelliJ IDEA.
  User: thanhviet
  Date: 22/09/2023
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Settings</h1>
<table>
    <%--@elvariable id="email" type="email"--%>
    <form:form method="post" modelAttribute="email" action="/save">
        <tr>
            <td>Languages:</td>
            <td>
                <from:select path="language">
                    <from:option value="English">English</from:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </from:select>
            </td>
        </tr>

        <tr>
            <td>
                Page Size:
            </td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                emails per page
            </td>
        </tr>

        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamFilter" value="true"/>
                Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature" cols="20" rows="10"/>
            </td>
        </tr>
        <br/>
        <tr>
            <td></td>
            <td>
                <button type="submit">Update</button>
                <button onclick="window.location='/'">Cancel</button>
            </td>
        </tr>
    </form:form>
</table>
</body>
</html>
