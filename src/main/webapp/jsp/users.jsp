<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.02.2020
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Users</title>
</head>
<body>
    <h1>Users Management</h1><br>
    <div>
        <c:forEach var="user" items="${requestScope.users}">
            <ul>
                <li>First name: <c:out value="${user.first_name}"/></li>
                <li>Last name: <c:out value="${user.last_name}"/></li>
                <li>Phone: <c:out value="${user.phone}"/></li>
                <li>Address: <c:out value="${user.address_id}"/></li>
                <li>Email: <c:out value="${user.email}"/></li>
                <li>Password: <c:out value="${user.password}"/></li>
                <br>
            </ul>
            <hr>
        </c:forEach>
    </div>

    <div>
        <h2>Create user</h2>
        <form method="post" action="">
            <div class="form-group">
                <label for="first_name">First name</label>
                <input type="text" id="first_name" name="first_name" required="required"/>
            </div>
            <div class="form-group">
                <label for="last_name">Last name</label>
                <input type="text" id="last_name" name="last_name" required="required"/>
            </div>
            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" required="required"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required="required"/>
            </div>
            <div class="form-group">
                <button type="submit">Додати</button>
            </div>
        </form>
    </div>


</body>
</html>
