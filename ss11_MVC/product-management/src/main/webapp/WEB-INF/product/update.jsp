<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/5/2023
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<p>
<H1>Update </H1>
</p>
<p>
    <a href="/products">Back to list</a>
</p>
<form>


    <table border="1">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" id="name" value="${product.getProductName()}"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" id="email" value="${product.getPrice()}"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>
                <input type="text" name="desc" id="desc" value="${product.getDescription()}"></td>

        </tr>
        <tr>
            <td>Producer:</td>

            <%--                    <input type="text" name="producer" value="${product.producer.getProducerName()}"></td>--%>
            <td>
                <select name="producerId">
                    <c:forEach items="${producers}" var="p">
                        <c:if test="${product.producer.id == p.id}">
                            <option value="${p.getId()}" selected>${p.getProducerName()}</option>
                        </c:if>
                        <c:if test="${product.producer.id != p.id}">
                            <option value="${p.getId()}">${p.getProducerName()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr style="collapse: 2">
            <td><input type="submit" value="Update customer"></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="update">
<%--    phải gửi id đối tượng cần update --%>
    <input type="hidden" name="id" value="${product.id}">
</form>
</body>
</html>
