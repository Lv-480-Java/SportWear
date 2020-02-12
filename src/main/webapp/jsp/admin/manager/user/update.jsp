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
<style>
    html {
        display: flex;
        justify-content: center;
    }

    body {
        margin-top: 50px;
        align-content: center;
        background: linear-gradient(100deg, rgba(66, 80, 245, 0.8) 0%, rgba(66, 80, 245, 0.4) 100%);
        font-family: "Roboto", sans-serif;
    }

    label {
        float: left;
        padding-right: 10px;
    }

    .field {
        clear: both;
        text-align: right;
        line-height: 25px;
    }

    .main {
        margin: 30px;
        float: left;
        text-align: center;
    }
</style>
    <li>ID: <c:out value="${requestScope.user.id}"/></li><br/>
    <li>First name: <c:out value="${requestScope.user.first_name}"/></li><br/>
    <li>Last name: <c:out value="${requestScope.user.last_name}"/></li><br/>
    <li>Phone: <c:out value="${requestScope.user.phone}"/></li><br/>
    <li>Address_ID: <c:out value="${requestScope.user.address_id}"/></li><br/>
    <li>Email: <c:out value="${requestScope.user.email}"/></li><br/>
    <li>Password: <c:out value="${requestScope.user.password}"/></li><br/>

    <div class="main">
        <form method="post" action="<c:url value='/admin/update-user'/>">

            <div class="field">
                <label>New user first name:</label>
                <input type="text" name="first_name"/><br/>
            </div>
            <div class="field">
                <label>New user last name:</label>
                <input type="text" name="last_name"/><br/>
            </div>
            <div class="field">
                <label>New user phone:</label>
                <input type="text" name="phone"/><br/>
            </div>
            <div class="field">
                <label>New user address_id:</label>
                <input type="number" name="address_id"/><br/>
            </div>
            <div class="field">
                <label>New user email:</label>
                <input type="text" name="email"/><br/>
            </div>
            <div class="field">
                <label>New user password:</label>
                <input type="text" name="password"/><br/>
            </div>

            <label><input type="number" hidden name="id" value="${requestScope.user.id}"/></label><br/>
            <input type="submit" value="Ok" name="Ok"><br>
        </form>
    </div>
</body>
</html>
