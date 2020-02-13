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
    <title>Order</title>
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
    label {
        color: #ffd774 !important;
        text-decoration: none
    }
    div {
        margin: 30px;
        font-size: 20px;
    }

    #admin-page {
        color: #a60305;
    }

    .form-group button {
        outline: none;
        background: #4A5686;
        border: 0;
        border-radius: 4px;
        padding:  5px 10px;
        color: #FFFFFF;
        font-family: inherit;
        font-weight: 500;
        line-height: inherit;
        text-transform: uppercase;
        cursor: pointer;
    }
    input {
        height: 25px;
    }

    .labels {
        float: left;
        padding-right: 10px;
    }

    .field {
        clear: both;
        text-align: right;
        line-height: 25px;
    }

    .main {
        float: left;
        text-align: center;
        margin-left: 520px;
    }
</style>

<h1>Order management</h1><br/>

<h2>Всі замовлення</h2><br/>

<c:forEach var="order" items="${requestScope.orders}">
    <ul>
        <li>ID: <c:out value="${order.id}"/></li>
        <li>Date: <c:out value="${order.localDate}"/></li>
        <li>Count: <c:out value="${order.count}"/></li>
        <li>User_id: <c:out value="${order.user_id}"/></li>
        <li>Is_buy: <c:out value="${order.is_buy}"/></li>

        <form method="post" action="<c:url value='/admin/delete-order'/>">
            <input type="number" hidden name="id" value="${order.id}" />
            <input type="submit" name="delete" value="Видалити"/>
        </form>

        <form method="get" action="<c:url value='/admin/update-order'/>">
            <input type="number" hidden name="id" value="${order.id}" />
            <input type="submit" value="Редагувати"/>
        </form>
    </ul>
    <hr/>
</c:forEach>

<h2>Створення нового замовлення</h2><br/>

<form method="post" action="/admin/add-order">

    <div class="main">
        <div class="field">
            <label class="labels">Date</label>
            <input type="date" name="date"><br>
        </div>
        <div class="field">
            <label class="labels">Count</label>
            <input type="number" name="count"/><br>
        </div>
        <div class="field">
            <label class="labels">User_id</label>
            <input type="number" name="user_id"/><br>
        </div>
        <div class="field">
            <label class="labels">Статус покупки</label>
            <input type="checkbox" value="true" name="is_buy"/><br>
        </div>
        <button type="submit" value="ok">OK</button>
        <div><a href="/admin/admin-service"><u id="admin-page">Back to Admin Service</u></a><br></div>
    </div>
</form>

</body>
</html>
