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

<li><c:out value="${requestScope.product.name}"/></li><br/>
<li><c:out value="${requestScope.product.model}"/></li><br/>
<li><c:out value="${requestScope.product.sex}"/></li><br/>
<li><c:out value="${requestScope.product.size}"/></li><br/>
<li><c:out value="${requestScope.product.color_id}"/></li><br/>
<li><c:out value="${requestScope.product.price}"/></li><br/>
<li><c:out value="${requestScope.product.category_id}"/></li><br/>
<li><c:out value="${requestScope.product.brand_id}"/></li><br/>

<form method="post" action="<c:url value='/admin/update-product'/>">

    <label>New product name: <input type="text" name="name"/></label><br/>
    <label>New product model: <input type="text" name="model"/></label><br/>
    <label>New product sex: <input type="text" name="sex"/></label><br/>
    <label>New product size: <input type="number" name="size"/></label><br/>
    <label>New product color_id: <input type="number" name="color_id"/></label><br/>
    <label>New product price: <input type="number" name="price"/></label><br/>
    <label>New product category_id: <input type="number" name="category_id"/></label><br/>
    <label>New product brand_id: <input type="number" name="brand_id"/></label><br/>

    <label><input type="number" hidden name="id" value="${requestScope.product.id}"/></label><br/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
