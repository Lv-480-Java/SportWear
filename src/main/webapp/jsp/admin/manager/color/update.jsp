    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--
          Created by IntelliJ IDEA.
          User: Admin
          Date: 11.02.2020
          Time: 2:39
          To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color update</title>
</head>
<body>

    <li><c:out value="${requestScope.color.name}"/></li><br/>

    <form method="post" action="<c:url value='/admin/update-color'/>">

    <label>New color name: <input type="text" name="name"/></label><br/>

    <label><input type="number" hidden name="id" value="${requestScope.color.id}"/></label><br/>

    <input type="submit" value="Ok" name="Ok"><br>
    </form>

</body>
</html>
