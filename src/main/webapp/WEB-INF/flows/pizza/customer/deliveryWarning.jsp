<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/3
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Pizza</title>
</head>
<body>
    <h2>Delivery Unavailable</h2>

    <p>The address is outside of our delivery area. The order
        may still be taken for carry-out.</p>

    <a href="${flowExecutionUrl}&_eventId=accept">Accept</a> |
    <a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
</body>
</html>
