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
    <title>Product</title>
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
        color: #ffd774 !important;
        text-decoration: none
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
        margin-left: 500px;
        float: left;
        text-align: center;
    }
</style>

<div>
    <h1>Product management</h1><br/>

    <h2>Всі продукти</h2><br/>

    <c:forEach var="product" items="${requestScope.products}">
        <ul>
            <li>ID: <c:out value="${product.id}"/></li>
            <li>Name: <c:out value="${product.name}"/></li>
            <li>Model: <c:out value="${product.model}"/></li>
            <li>Sex: <c:out value="${product.sex}"/></li>
            <li>Size: <c:out value="${product.size}"/></li>
            <li>Color_id: <c:out value="${product.color_id}"/></li>
            <li>Price: <c:out value="${product.price}"/></li>
            <li>Category_id: <c:out value="${product.category_id}"/></li>
            <li>Brand_id: <c:out value="${product.brand_id}"/></li>

            <form method="post" action="<c:url value='/admin/delete-product'/>">
                <input type="number" hidden name="id" value="${product.id}" />
                <input type="submit" name="delete" value="Видалити"/>
            </form>

            <form method="get" action="<c:url value='/admin/update-product'/>">
                <input type="number" hidden name="id" value="${product.id}" />
                <input type="submit" value="Редагувати"/>
            </form>
        </ul>
        <hr/>
    </c:forEach>

    <h2>Створення нового продукту</h2><br/>

    <div class="main">
        <form method="post" action="/admin/add-product">
            <div class="field">
                <label>Product name</label>
                <input type="text" name="name"/><br>
            </div>
            <div class="field">
                <label>Model</label>
                <input type="text" name="model"/><br>
            </div>
            <div class="field">
                <label>Sex</label>
                <input type="text" name="sex"/><br>
            </div>
            <div class="field">
                <label>Size</label>
                <input type="number" name="size"/><br>
            </div>
            <div class="field">
                <label>Color_id</label>
                <input type="number" name="color_id"/><br>
            </div>
            <div class="field">
                <label>Price</label>
                <input type="number" name="price"/><br>
            </div>
            <div class="field">
                <label>Category_id</label>
                <input type="number" name="category_id"/><br>
            </div>
            <div class="field">
                <label>Brand_id</label>
                <input type="number" name="brand_id"/><br>
            </div>
            <button type="submit" value="ok">OK</button>
        </form>
        <div><a href="/admin/admin-service"><u id="admin-page">Back to Admin Service</u></a><br></div>
    </div>

</div>

</body>
</html>
