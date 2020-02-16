<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.02.2020
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accessories</title>
</head>
<body>

<style>
    body {
        background: linear-gradient(100deg, rgba(66, 80, 245, 0.8) 0%, rgba(66, 80, 245, 0.4) 100%);
    }

    .div-main {
        display: flex;
        justify-content: space-evenly;
        flex-wrap: wrap;
    }

    img {
        margin-top: 50px;
        height: 500px;
        width: 500px;
    }

    div {
        padding-bottom: 50px;
        text-align: center;
    }

    button {
        margin-top: 30px;
    }

    #back-page {
        color: #a60305;
    }

    footer {
        height: 100px;
        text-align: center;
        font-size: 30px;
    }

</style>

<div class="div-main">
<div>
    <img src="<c:url value="/jsp/img/accessories/1.jpg"/>" alt=""><br>
    <button type="submit">Купити</button>
</div>
<div>
    <img src="<c:url value="/jsp/img/accessories/2.jpg"/>" alt=""><br>
    <button type="submit">Купити</button>
</div>
<div>
    <img src="<c:url value="/jsp/img/accessories/3.jpg"/>" alt=""><br>
    <button type="submit">Купити</button>
</div>
<div>
    <img src="<c:url value="/jsp/img/accessories/4.jpg"/>" alt=""><br>
    <button type="submit">Купити</button>
</div>
<div>
    <img src="<c:url value="/jsp/img/accessories/5.jpg"/>" alt=""><br>
    <button type="submit">Купити</button>
</div>

</div>

<footer>
    <a class="content" href="/user/user-homepage"><u id="back-page">Повернутися на головну</u></a><br>
</footer>

</body>
</html>
