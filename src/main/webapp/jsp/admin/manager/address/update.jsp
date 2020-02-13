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
    <style>
        html {
            display: flex;
            justify-content: center;
        }
        body {
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

        #admin-page {
            color: #a60305;
        }

    </style>
    <li>ID: <c:out value="${requestScope.address.id}"/></li>
    <br/>
    <li>Country: <c:out value="${requestScope.address.country}"/></li>
    <br/>
    <li>City: <c:out value="${requestScope.address.city}"/></li>
    <br/>
    <li>Street: <c:out value="${requestScope.address.street}"/></li>
    <br/>
    <div class="main">
        <form method="post" action="<c:url value='/admin/update-address'/>">
            <div class="field">
                <label>New country:</label>
                <input type="text" name="country"/>
            </div>
            <div class="field">
                <label>New city:</label>
                <input type="text" name="city"/>
            </div>
            <div class="field">
                <label>New street:</label>
                <input type="text" name="street"/>
            </div>

            <label><input type="number" hidden name="id" value="${requestScope.address.id}"/></label><br/>

            <input type="submit" value="Ok" name="Ok"><br>
        </form>
        <div><a href="/admin/address-index"><u id="admin-page">Back to Panel Management</u></a><br></div>
    </div>
</body>
</body>
</html>
