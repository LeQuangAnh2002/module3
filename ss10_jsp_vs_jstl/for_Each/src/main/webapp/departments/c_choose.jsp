<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/3/2023
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>c:choose,c:when,c:otherwise example</title>
</head>
<body>

<h2>c:choose,c:when,c:otherwise example</h2>
<c:choose>
  <%-- Khi tham số color == 'red' --%>
  <c:when test="${param.color=='red'}">
    <p style="color:red;">RED COLOR</p>
  </c:when>

  <%-- Khi tham số color == 'blue' --%>
  <c:when test="${param.color=='blue'}">
    <p style="color:blue;">BLUE COLOR</p>
  </c:when>

  <%-- Các trường hợp khác --%>
  <c:otherwise>
    <b>Other color</b>
  </c:otherwise>
</c:choose>
</body>
</html>
