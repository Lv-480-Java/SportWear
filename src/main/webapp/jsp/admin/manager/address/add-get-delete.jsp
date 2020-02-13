<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.02.2020
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Address</title>
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
                text-decoration: none;
                float:left;
                padding-right:10px;
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
            .main {
                float: left;
                margin-left: 480px;
            }
            input {
                height: 25px;
            }
            .field {
                clear: both;
                text-align: right;
                line-height: 25px;
            }
        </style>

            <h1>Address management</h1>

            <h2>Всі адреси</h2><br/>

            <c:forEach var="address" items="${requestScope.addresses}">
                <ul>
                    <li>ID: <c:out value="${address.id}"/></li>
                    <li>Country: <c:out value="${address.country}"/></li>
                    <li>City: <c:out value="${address.city}"/></li>
                    <li>Street: <c:out value="${address.street}"/></li>

                    <form method="post" action="<c:url value='/admin/delete-address'/>">
                        <input type="number" hidden name="id" value="${address.id}" />
                        <input type="submit" name="delete" value="Видалити"/>
                    </form>

                    <form method="get" action="<c:url value='/admin/update-address'/>">
                        <input type="number" hidden name="id" value="${address.id}" />
                        <input type="submit" value="Редагувати"/>
                    </form>
                </ul>
                <hr/>
            </c:forEach>

            <div class="main">
                <h2>Створення нової адреси</h2><br/>

                <form method="post" action="/admin/add-address">
                    <div class="form-group">
                        <div class="field">
                            <label>country</label>
                            <input type="text" name="country"/><br>
                        </div>
                        <div class="field">
                            <label>city</label>
                            <input type="text" name="city"/><br>
                        </div>
                        <div class="field">
                            <label>street</label>
                            <input type="text" name="street"/><br>
                        </div>
                        <button type="submit" value="ok">OK</button>
                    </div>
                </form>
                <div><a href="/admin/admin-service"><u id="admin-page">Back to Admin Service</u></a><br></div>
            </div>
    </body>
</html>
