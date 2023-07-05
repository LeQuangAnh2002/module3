<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/4/2023
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
  <style>

    table {
      width: 100%;
      border-collapse: collapse;
      font-family: arial, sans-serif;
    }
    tr, td ,th{
    padding: 15px;
      border: 1px solid black;

    }
    th{
      height: 40px;
      text-align: left;
    }

  </style>
</head>
<body>
<h1>Customer</h1>
<p>
  <a href="/customers?action=create">Create new customer</a>
</p>
<table >
  <tr>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:forEach items='${requestScope["customers"]}' var="c">
    <tr>

      <td><a href="/customers?action=view&id=${c.getId()}">${c.getName()}</a></td>
      <td>${c.getEmail()}</td>
      <td>${c.getAddress()}</td>
      <td><a href="/customers?action=edit&id=${c.getId()}">edit</a></td>
      <td><a href="/customers?action=delete&id=${c.getId()}">delete</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
