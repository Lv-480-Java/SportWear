<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category update</title>
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
        <li>ID: <c:out value="${requestScope.category.id}"/></li><br/>
        <li>Category name: <c:out value="${requestScope.category.name}"/></li><br/>
        <li>Category_ID: <c:out value="${requestScope.category.category_id}"/></li><br/>

        <div class="main">
            <form method="post" action="<c:url value='/admin/update-category'/>">
                <div class="field">
                    <label>New name:</label>
                    <input type="text" name="name"/>
                </div>
                <div class="field">
                    <label>New category_id:</label>
                    <input type="text" name="category_id"/>
                </div>
                <label><input type="number" hidden name="id" value="${requestScope.category.id}"/></label><br/>
                <input type="submit" value="Ok" name="Ok"><br>
            </form>
        </div>
</body>
</html>
