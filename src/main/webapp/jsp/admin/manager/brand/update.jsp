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

        <li><c:out value="${requestScope.brand.name}"/></li><br/>

        <form method="post" action="<c:url value='/admin/update-brand'/>">

            <label>New name: <input type="text" name="name"/></label><br/>

            <label><input type="number" hidden name="id" value="${requestScope.brand.id}"/></label><br/>

            <input type="submit" value="Ok" name="Ok"><br>
        </form>
</body>
</html>
