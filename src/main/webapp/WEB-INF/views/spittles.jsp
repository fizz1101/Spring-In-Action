<%--
  Created by IntelliJ IDEA.
  User: Fizz
  Date: 2018/1/8
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/style.css" />" >
</head>
<body>
    <div class="listTitle">
        <h1>Recent Spittles</h1>
        <ul class="spittleList">
            <c:forEach items="${spittleList}" var="spittle" >
                <c:choose>
                    <c:when test="${not empty spittle}">
                        <li id="spittle_<c:out value="spittle.id"/>">
                            <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
                            <div>
                                <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                                <span class="spittleLocation">(<c:out value="${spittle.latitude}" />, <c:out value="${spittle.longitude}" />)</span>
                            </div>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <div style="color: red; font-weight: bold;">当前没有数据</div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </div>
</body>
<script>

</script>
</html>
