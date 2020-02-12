<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10.02.2020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update operation</title>
</head>
<body>
<style>
    body {
        margin-top: 50px;
        align-content: center;
        background: linear-gradient(100deg, rgba(66, 80, 245, 0.8) 0%, rgba(66, 80, 245, 0.4) 100%);
        font-family: "Roboto", sans-serif;
        text-align: center;
    }
    .ok {
        margin-left: 30px;
    }
</style>
        <li>ID: <c:out value="${requestScope.brand.id}"/></li><br/>
        <li>Brand name: <c:out value="${requestScope.brand.name}"/></li><br/>
        <div class="main">
            <form method="post" action="<c:url value='/admin/update-brand'/>">

                <label>New name: <input type="text" name="name"/></label><br/>

                <label></label><br/>
                <input type="number" hidden name="id" value="${requestScope.brand.id}"/>

                <input class="ok" type="submit" value="Ok" name="Ok"><br>
            </form>
        </div>
</body>
</html>
