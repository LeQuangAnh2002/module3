<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/5/2023
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Customer</title>
</head>
<body>
<H1>Update Customer</H1>
<p>
  <c:if test='${requestScope["message"] != null}'>
  <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p><a href="/customers">Back to customer list</a></p>
<p>
  <form method="post">
    <fieldset>
      <legend>Customer information</legend>
      <table>
        <tr>
          <td>Name: </td>
          <td><input type="text" name="name" id="name" value="${customer.getName()}"></td>
        </tr>
        <tr>
          <td>Email: </td>
          <td><input type="text" name="email" id="email" value="${customer.getEmail()}"></td>
        </tr>
        <tr>
          <td>Address: </td>
          <td><input type="text" name="address" id="address" value="${customer.getAddress()}"></td>
        </tr>
        <tr style="collapse: 2">
          <td><input type="submit" value="Update customer"></td>
        </tr>
      </table>
    </fieldset>
</form>
</p>
</body>
</html>
