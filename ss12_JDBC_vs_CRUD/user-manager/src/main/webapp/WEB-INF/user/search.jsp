<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/10/2023
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>User Management</h1>
<h2>

  <a href="/users?action=list">Back To User</a>
</h2>
<caption><h2>Search Users</h2></caption>
</center>
<div align="center">

  <table border="1" cellpadding="5">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th>Actions</th>
    </tr>
    <c:forEach var="u" items="${users}">
      <tr>
        <td><c:out value="${u.id}"/></td>
        <td><c:out value="${u.name}"/></td>
        <td><c:out value="${u.email}"/></td>
        <td><c:out value="${u.country}"/></td>
        <td>
          <a href="/users?action=edit&id=${u.id}">Edit

          </a>
          <a href="/users?action=delete&id=${u.id}" >Delete
          </a>

        </td>

      </tr>
    </c:forEach>
  </table>

</div>
</body>
</html>
