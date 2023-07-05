<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/5/2023
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
<H1>View Product </H1>
</p>
<p>
  <a href="/products">Back to list</a>
</p>
<form method="post" >


  <table border="1">
    <tr>
      <td>Name:</td>
      <td><input type="text" name="name" id="name" value="${product.getProductName()}" readonly></td>
    </tr>
    <tr>
      <td>Price:</td>
      <td><input type="text" name="price" id="email" value="${product.getPrice()}" readonly></td>
    </tr>
    <tr>
      <td>Description:</td>
      <td>
        <input type="text" name="desc" id="desc" value="${product.getDescription()}" readonly></td>

    </tr>
    <tr>
      <td>Producer:</td>
      <td>
        <input type="text" name="producer" value="${product.producer.getProducerName()}  " readonly></td>
      </td>
    </tr>

  </table>

</form>
</body>
</html>
