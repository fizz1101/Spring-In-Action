<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/style.css" />" >
</head>
<body>
    <h1>Your Profile</h1>
    <%--<c:choose>--%>
        <%--<c:when test="${not empty spitter}">--%>
            <c:out value="${spitter.username}" /><br/>
            <c:out value="${spitter.firstName}" /> <c:out value="${spitter.lastName}" /><br/>
            <c:out value="${spitter.email}" />
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<div>不存在</div>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>
</body>
</html>
