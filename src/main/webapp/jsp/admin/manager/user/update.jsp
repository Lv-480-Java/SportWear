<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User update</title>
</head>
<body>

    <li><c:out value="${requestScope.user.first_name}"/></li><br/>
    <li><c:out value="${requestScope.user.last_name}"/></li><br/>
    <li><c:out value="${requestScope.user.phone}"/></li><br/>
    <li><c:out value="${requestScope.user.address_id}"/></li><br/>
    <li><c:out value="${requestScope.user.email}"/></li><br/>
    <li><c:out value="${requestScope.user.password}"/></li><br/>

    <form method="post" action="<c:url value='/admin/update-user'/>">

    <label>New user first name: <input type="text" name="first_name"/></label><br/>
    <label>New user last name: <input type="text" name="last_name"/></label><br/>
    <label>New user phone: <input type="text" name="phone"/></label><br/>
    <label>New user address_id: <input type="text" name="address_id"/></label><br/>
    <label>New user email: <input type="text" name="email"/></label><br/>
    <label>New user password: <input type="text" name="password"/></label><br/>

    <label><input type="number" hidden name="id" value="${requestScope.user.id}"/></label><br/>

    <input type="submit" value="Ok" name="Ok"><br>
    </form>

</body>
</html>
