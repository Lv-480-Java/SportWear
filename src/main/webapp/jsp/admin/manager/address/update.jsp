<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Address</title>
</head>
<body>

        <li><c:out value="${requestScope.address.country}"/></li><br/>
        <li><c:out value="${requestScope.address.city}"/></li><br/>
        <li><c:out value="${requestScope.address.street}"/></li><br/>

        <form method="post" action="<c:url value='/admin/update-address'/>">

            <label>New country: <input type="text" name="country"/></label><br/>
            <label>New city: <input type="text" name="city"/></label><br/>
            <label>New street: <input type="text" name="street"/></label><br/>

            <label><input type="number" hidden name="id" value="${requestScope.address.id}"/></label><br/>

            <input type="submit" value="Ok" name="Ok"><br>
        </form>

</body>
</html>
