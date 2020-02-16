<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.02.2020
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
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

    .admin-page {
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

<div><u class="admin-page" style="font-size: 30px">Профіль користувача</u><br></div>

<li>First name: <c:out value="${sessionScope.user.first_name}"/></li><br/>
<li>Last name: <c:out value="${sessionScope.user.last_name}"/></li><br/>
<li>Email: <c:out value="${sessionScope.user.email}"/></li><br/>
<li>Phone: <c:out value="${sessionScope.user.phone}"/></li><br/>
<li>Country: <c:out value="${sessionScope.address.country}"/></li><br/>
<li>City: <c:out value="${sessionScope.address.city}"/></li><br/>
<li>Street: <c:out value="${sessionScope.address.street}"/></li><br/>

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
            <label>New user country:</label>
            <input type="text" name="country"/><br/>
        </div>
        <div class="field">
            <label>New user city:</label>
            <input type="text" name="city"/><br/>
        </div>
        <div class="field">
            <label>New user street:</label>
            <input type="text" name="street"/><br/>
        </div>


        <label><input type="number" hidden name="id" value="${requestScope.user.id}"/></label><br/>
        <input type="submit" value="Ok" name="Ok"><br>
    </form>
    <div><a href="/user/user-homepage"><u class="admin-page">Повернутися на головну</u></a><br></div>
</div>

</body>
</html>
