<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order update</title>
</head>
<body>

<li><c:out value="${requestScope.order.localDate}"/></li><br/>
<li><c:out value="${requestScope.order.count}"/></li><br/>
<li><c:out value="${requestScope.order.user_id}"/></li><br/>
<li><c:out value="${requestScope.order.is_buy}"/></li><br/>

<form method="post" action="<c:url value='/admin/update-order'/>">

    <label>New order date: <input type="date" name="date"></label><br/>
    <label>New order count: <input type="number" name="count"/></label><br/>
    <label>New order user_id: <input type="number" name="user_id"/></label><br/>
    <label>New order is_buy: <input type="checkbox" value="true" name="is_buy"/></label><br/>

    <label><input type="number" hidden name="id" value="${requestScope.order.id}"/></label><br/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
