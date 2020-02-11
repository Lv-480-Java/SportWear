<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category update</title>
</head>
<body>

        <li><c:out value="${requestScope.category.name}"/></li><br/>
        <li><c:out value="${requestScope.category.id}"/></li><br/>

        <form method="post" action="<c:url value='/admin/update-category'/>">

            <label>New name: <input type="text" name="name"/></label><br/>
            <label>New category_id: <input type="text" name="category_id"/></label><br/>

            <label><input type="number" hidden name="id" value="${requestScope.category.id}"/></label><br/>

            <input type="submit" value="Ok" name="Ok"><br>
        </form>

</body>
</html>
