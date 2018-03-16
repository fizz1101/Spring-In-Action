<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/9
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/style/style.css" />" >
</head>
<body>
    <h1>Register</h1>
    <form method="POST" enctype="multipart/form-data"><!-- 不填action，默认当前路径 -->
        Username: <input type="text" name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        First Name: <input type="text" name="firstName" /><br/>
        Last Name: <input type="text" name="lastName" /><br/>
        Email: <input type="email" name="email" /><br/>
        Picture: <input type="file" name="portrait" /><br/>
        <input type="submit" value="Register" />
    </form>
</body>
</html>
