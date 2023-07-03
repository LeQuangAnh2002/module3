<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>

        table {
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
        }

    </style>
</head>
<body>
    <h1>Danh sách khách hàng </h1>
    <br>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach items="${requestScope.customers}" var="cu">
    <tr>
        <td>${cu.name}</td>
        <td>${cu.birthDate}</td>
        <td>${cu.address}</td>
        <td><img src="${cu.image}" width="80px" height="80px"></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>