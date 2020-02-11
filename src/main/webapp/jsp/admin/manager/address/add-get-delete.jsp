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
                color: rgba(0, 0, 0, 0.6);
                font-family: "Roboto", sans-serif;
                font-size: 14px;
            }
            label {
                color: #ffd774 !important;
                text-decoration: none
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
            input {
                height: 25px;
            }
        </style>
        <div>
            <h1>Address management</h1>

            <h2>Всі адреси</h2><br/>

            <c:forEach var="address" items="${requestScope.addresses}">
                <ul>
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

            <h2>Створення нової адреси</h2><br/>

            <form method="post" action="/admin/add-address">
                <div class="form-group">
                    <label>country</label>
                    <input type="text" name="country"/><br>
                    <label>city</label>
                    <input type="text" name="city"/><br>
                    <label>street</label>
                    <input type="text" name="street"/><br>

                    <button type="submit" value="ok">OK</button>
                </div>
            </form>
        </div>
    </body>
</html>
