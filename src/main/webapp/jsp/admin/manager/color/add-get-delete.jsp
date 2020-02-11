    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--
          Created by IntelliJ IDEA.
          User: Admin
          Date: 11.02.2020
          Time: 3:38
          To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color</title>
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

    <h1>Color management</h1><br/>

    <h2>Всі кольори</h2><br/>

    <c:forEach var="color" items="${requestScope.colors}">
        <ul>
        <li>Name: <c:out value="${color.name}"/></li>

        <form method="post" action="<c:url value='/admin/delete-color'/>">
        <input type="number" hidden name="id" value="${color.id}" />
        <input type="submit" name="delete" value="Видалити"/>
        </form>

        <form method="get" action="<c:url value='/admin/update-color'/>">
        <input type="number" hidden name="id" value="${color.id}" />
        <input type="submit" value="Редагувати"/>
        </form>
        </ul>
        <hr/>
    </c:forEach>

    <h2>Створення нового кольору</h2><br/>

        <form method="post" action="/admin/add-color">
        <div class="form-group">
        <label>Color name</label>
        <input type="text" name="name"/>
        <button type="submit" value="ok">OK</button>
        </div>
        </form>

    </body>
</html>
