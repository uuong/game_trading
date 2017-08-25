<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/18 0018
  Time: 11:54
  To changeAmount this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户资料</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/top.jsp" %>
<table class="table">
    <th>id</th>
    <th>time</th>
    <th>amoun</th>
    <th>gid</th>
    <c:forEach var="order" items="${lists}">

        <%--${order.sellerId}--%>

        <tr>
            <td>
                    ${order.orderId}
            </td>
            <td>
                    ${order.time}
            </td>
            <td> ${order.amount}</td>

            <td> ${order.goodsId}</td>
        </tr>

    </c:forEach>

</table>
充值
<form action="order" method="post">
    <input type="number" name="number">
    <input type="submit">
</form>
</body>
</html>
