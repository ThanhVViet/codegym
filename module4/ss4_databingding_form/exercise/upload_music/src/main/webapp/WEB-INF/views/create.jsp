<%--
  Created by IntelliJ IDEA.
  User: thanhviet
  Date: 22/09/2023
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Music</title>
</head>
<body>
<table>
    <form method="post" action="/" novalidate="novalidate" enctype="multipart/form-data">
        <input type="hidden" name="id" value="0">
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>
                Artist:
            </td>
            <td>
                <input type="text" name="artist">
            </td>
        </tr>

        <tr>
            <td>
                Genre:
            </td>
            <td>
                <input type="text" name="genre">
            </td>
        </tr>
        <tr>
            <td>
                File:
            </td>
            <td>
                <input type="file" name="file" accept=".mp3,.wav,.ogg,.m4p">
            </td>
        </tr>
        <button>Create</button>
    </form>
</table>
</body>
</html>
