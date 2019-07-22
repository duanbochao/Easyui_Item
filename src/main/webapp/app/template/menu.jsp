<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 段卫杰
  Date: 2019/7/18
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1">
    <c:forEach items="${menus}" var="menu">
        <tr>
            <td onclick="menuItem('${menu.name}','${menu.url}')">${menu.name}</td>
        </tr>
    </c:forEach>
</table>