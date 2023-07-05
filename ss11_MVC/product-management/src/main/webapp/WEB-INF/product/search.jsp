<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/6/2023
  Time: 12:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
            border: 1px solid gray;
            font-family: Arial,sans-serif;
        }
        th,tr,td{
            padding: 15px;
            border: 1px solid black;
        }
        th{
            text-align: left;
        }
        a{
            text-decoration: none;

        }
    </style>
</head>
<body>
<p>
<H1>Search Products</H1>
</p>
<p>
    <a href="/products">Back to list</a>
</p>
<table>
    <tr>
        <form method="post" action="/products">
            <label>Product Name:</label>
            <input type="text" name="searchName">
            <input type="submit" value="Search">
            <input type="hidden" name="action" value="search">
        </form>
    </tr>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Category</th>
        <th>View</th>
        <th>Edit</th>
        <th>Update</th>
    </tr>
    <c:forEach items="${requestScope.searchResult}" var="s">
    <tr>
        <td>${s.getProductName()}</td>
        <td>${s.getPrice()}</td>
        <td>${s.getDescription()}</td>
        <td>${s.producer.getProducerName()}</td>
        <td><a href="/products?action=view&id=${s.getId()}">VIEW</a></td>
        <td><a href="/products?action=update&id=${s.getId()}">EDIT</a></td>
        <td><a href="/products?action=delete&id=${s.getId()}">DELETE</a></td>

    </tr>
    </c:forEach>

</body>
</html>
