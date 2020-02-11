<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.02.2020
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Admin Manager</title>
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
        h1 {
            color: #a60305;
        }
        a {
            color: #f6fffd !important;
            text-decoration: none
        }
        div {
            margin: 30px;
            font-size: 20px;
            text-align: center;
        }
        u {
            color: black;
        }
    </style>
    <div>
        <h1>Admin Service</h1><br>
        <form method="get" action="">
            <div class="form-group">
                <div><a href="admin/address-index"><u>Address Menu</u></a><br></div>
                <div><a href="admin/brand-index"><u>Brand Menu</u></a><br></div>
                <div><a href="admin/category-index"><u>Category Menu</u></a><br></div>
                <div><a href="admin/color-index"><u>Color Menu</u></a><br></div>
                <div><a href="admin/order-index"><u>Order Menu</u></a><br></div>
                <div><a href="admin/product-index"><u>Product Menu</u></a><br></div>
                <div><a href="admin/user-index"><u>Users Menu</u></a><br></div>
            </div>
        </form>
    </div>
    </body>
</html>
