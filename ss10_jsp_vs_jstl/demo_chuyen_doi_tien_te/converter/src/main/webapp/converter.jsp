<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 7/3/2023
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));
    float vnd = rate * usd;
  %>
<H1>rate: <%=rate%></H1>
<H1>usd: <%=usd%></H1>
<H1>vnd: <%=vnd%></H1>
</body>
</html>
