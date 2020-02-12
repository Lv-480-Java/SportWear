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
<style>
    body {
        margin-top: 30px;
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
        float: left;
        text-align: center;
        margin-left: 520px;
    }
</style>

<li>ID: <c:out value="${requestScope.order.id}"/></li><br/>
<li>Date: <c:out value="${requestScope.order.localDate}"/></li><br/>
<li>Count: <c:out value="${requestScope.order.count}"/></li><br/>
<li>User_ID: <c:out value="${requestScope.order.user_id}"/></li><br/>
<li>Is_Buy: <c:out value="${requestScope.order.is_buy}"/></li><br/>

<div class="main">
    <form method="post" action="<c:url value='/admin/update-order'/>">
        <div class="field">
            <label>New order date:</label>
            <input type="date" name="date"><br/>
        </div>
        <div class="field">
            <label>New order count:</label>
            <input type="number" name="count"/><br/>
        </div>
        <div class="field">
            <label>New order user_id:</label>
            <input type="number" name="user_id"/><br/>
        </div>
        <div class="field">
            <label>New order is_buy:</label>
            <input type="checkbox" value="true" name="is_buy"/><br/>
        </div>
        <label><input type="number" hidden name="id" value="${requestScope.order.id}"/></label><br/>
        <input type="submit" value="Ok" name="Ok"><br>
    </form>
</div>
</body>
</html>
