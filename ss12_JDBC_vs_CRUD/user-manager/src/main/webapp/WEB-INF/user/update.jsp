<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/10/2023
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>User Management</h1>
<h2>
    <a href="users?action=list">Back to list</a>
</h2>
</center>
<div align="center">
    <form method="post" action="/users">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Update User</h2>
            </caption>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" id="name" value="${user.getName()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" value="${user.getEmail()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" id="country" value="${user.getCountry()}" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${user.getId()}">

        </table>

    </form>
</div>
</body>
</html>
