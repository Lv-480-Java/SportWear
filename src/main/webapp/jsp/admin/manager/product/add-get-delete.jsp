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
    <h1>Product management</h1><br/>

    <h2>Всі продукти</h2><br/>

    <c:forEach var="product" items="${requestScope.products}">
        <ul>
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

    <form method="post" action="/admin/add-product">
        <div class="form-group">
            <label>Product name</label>
            <input type="text" name="name"/><br>

            <label>Model</label>
            <input type="text" name="model"/><br>

            <label>Sex</label>
            <input type="text" name="sex"/><br>

            <label>Size</label>
            <input type="number" name="size"/><br>

            <label>Color_id</label>
            <input type="number" name="color_id"/><br>

            <label>Price</label>
            <input type="number" name="price"/><br>

            <label>Category_id</label>
            <input type="number" name="category_id"/><br>

            <label>Brand_id</label>
            <input type="number" name="brand_id"/><br>

            <button type="submit" value="ok">OK</button>
        </div>
    </form>
</div>

</body>
</html>
