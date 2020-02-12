<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
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
    <h1>Category management</h1><br/>

    <h2>Всі категорії</h2><br/>

    <c:forEach var="category" items="${requestScope.categories}">
        <ul>
            <li>ID: <c:out value="${category.id}"/></li>
            <li>Name: <c:out value="${category.name}"/></li>
            <li>Category_ID: <c:out value="${category.category_id}"/></li>


            <form method="post" action="<c:url value='/admin/delete-category'/>">
                <input type="number" hidden name="id" value="${category.id}" />
                <input type="submit" name="delete" value="Видалити"/>
            </form>

            <form method="get" action="<c:url value='/admin/update-category'/>">
                <input type="number" hidden name="id" value="${category.id}" />
                <input type="submit" value="Редагувати"/>
            </form>
        </ul>
        <hr/>
    </c:forEach>

    <h2>Створення нової категорії</h2><br/>

    <form method="post" action="/admin/add-category">
        <div class="form-group">
            <label>Category name</label>
            <input type="text" name="name"/>
            <button type="submit" value="ok">OK</button>
        </div>
    </form>
</div>

</body>
</html>
