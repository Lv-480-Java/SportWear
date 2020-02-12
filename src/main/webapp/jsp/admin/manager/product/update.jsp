<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.02.2020
  Time: 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product update</title>
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

<li>ID: <c:out value="${requestScope.product.id}"/></li><br/>
<li>Product name: <c:out value="${requestScope.product.name}"/></li><br/>
<li>Model: <c:out value="${requestScope.product.model}"/></li><br/>
<li>Sex: <c:out value="${requestScope.product.sex}"/></li><br/>
<li>Size: <c:out value="${requestScope.product.size}"/></li><br/>
<li>Color_ID: <c:out value="${requestScope.product.color_id}"/></li><br/>
<li>Price: <c:out value="${requestScope.product.price}"/></li><br/>
<li>Category_ID: <c:out value="${requestScope.product.category_id}"/></li><br/>
<li>Brand_ID: <c:out value="${requestScope.product.brand_id}"/></li><br/>

<div class="main">
    <form method="post" action="<c:url value='/admin/update-product'/>">

        <div class="field">
            <label>New product name:</label>
            <input type="text" name="name"/><br/>
        </div>
        <div class="field">
            <label>New product model:</label>
            <input type="text" name="model"/><br/>
        </div>
        <div class="field">
            <label>New product sex:</label>
            <input type="text" name="sex"/><br/>
        </div>
        <div class="field">
            <label>New product size:</label>
            <input type="number" name="size"/><br/>
        </div>
        <div class="field">
            <label>New product color_id:</label>
            <input type="number" name="color_id"/><br/>
        </div>
        <div class="field">
            <label>New product price:</label>
            <input type="number" name="price"/><br/>
        </div>
        <div class="field">
            <label>New product category_id:</label>
            <input type="number" name="category_id"/><br/>
        </div>
        <div class="field">
            <label>New product brand_id:</label>
            <input type="number" name="brand_id"/><br/>
        </div>

        <label><input type="number" hidden name="id" value="${requestScope.product.id}"/></label><br/>
        <input type="submit" value="Ok" name="Ok"><br>
    </form>
</div>
</body>
</html>
