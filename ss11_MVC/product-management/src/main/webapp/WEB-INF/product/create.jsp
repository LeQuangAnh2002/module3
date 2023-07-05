<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/5/2023
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
</head>
<p>
    <h1>Create new product</h1>
</p>
<p>
    <a href="/products">Back to list</a>
</p>
<form method="post" action="/products">
    <table>
        <tr>
            <td><lable> Product Name</lable></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><lable> Price</lable></td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td><lable> Description </lable></td>
            <td><input type="text" name="desc"></td>
        </tr>
        <tr>
            <td><lable> Producer </lable></td>
            <td>
                <select name="producerId">
                    <c:forEach items="${producers}" var="p">
                        <option value="${p.id}" >${p.producerName}</option>
                    </c:forEach>
                </select>
            </td>

        </tr>
        <tr style="collapse: 2">
            <input type="submit" value="ADD">
        </tr>
    </table>
    <input type="hidden" name="action" value="create">
</form>
<body>

</body>
</html>
