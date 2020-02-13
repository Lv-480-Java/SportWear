<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<style>
    body {
        align-content: center;
        background: linear-gradient(100deg, rgba(66, 80, 245, 0.8) 0%, rgba(66, 80, 245, 0.4) 100%);
        font-family: "Roboto", sans-serif;
        font-size: 14px;
        text-align: center;
    }

    div {
        margin: 30px;
        font-size: 20px;
    }

    #admin-page {
        color: #a60305;
    }

    label {
        float: left;
        padding-right: 10px;
        color: #ffd774 !important;
        text-decoration: none
    }

    .field {
        clear: both;
        text-align: right;
        line-height: 25px;
    }

    .main {
        margin-left: 500px;
        float: left;
        text-align: center;
    }
</style>
<div>

<h1>User management</h1><br/>

<h2>Всі користувачі</h2><br/>

    <c:forEach var="user" items="${requestScope.users}">
        <ul>
            <li>ID: <c:out value="${user.id}"/></li>
            <li>First name: <c:out value="${user.first_name}"/></li>
            <li>Last name: <c:out value="${user.last_name}"/></li>
            <li>Phone: <c:out value="${user.phone}"/></li>
            <li>Address_id: <c:out value="${user.address_id}"/></li>
            <li>email: <c:out value="${user.email}"/></li>
            <li>password: <c:out value="${user.password}"/></li>

            <form method="post" action="<c:url value='/admin/delete-user'/>">
                <input type="number" hidden name="id" value="${user.id}" />
                <input type="submit" name="delete" value="Видалити"/>
            </form>

            <form method="get" action="<c:url value='/admin/update-user'/>">
                <input type="number" hidden name="id" value="${user.id}" />
                <input type="submit" value="Редагувати"/>
            </form>
        </ul>
        <hr/>
    </c:forEach>


    <h2>Створення нового користувача</h2><br/>

    <div class="main">
        <form method="post" action="/admin/add-user">
            <div class="field">
                <label for="first_name">First name</label>
                <input type="text" id="first_name" name="first_name" required="required"/>
            </div>
            <div class="field">
                <label for="last_name">Last name</label>
                <input type="text" id="last_name" name="last_name" required="required"/>
            </div>
            <div class="field">
                <label for="phone">Phone</label>
                <input type="text" id="phone" name="phone" required="required"/>
            </div>
            <div class="field">
                <label for="address_id">Address_ID</label>
                <input type="number" id="address_id" name="address_id" required="required"/>
            </div>
            <div class="field">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" required="required"/>
            </div>
            <div class="field">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required="required"/>
            </div>
            <div class="form-group">
                <button type="submit">Додати</button>
            </div>
        </form>
        <div><a href="/admin/admin-service"><u id="admin-page">Back to Admin Service</u></a><br></div>
    </div>

</div>

</body>
</html>
