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
    <title>游戏交易</title>

    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="row">

    <div class="col-md-1"></div>
    <div class="col-md-10">
        <%@ include file="include/top.jsp" %>
        <table class="table table-condensed">

            <th>name</th>
            <th>数量</th>
            <th>price</th>
            <th>time</th>
            <th>购买</th>
            <c:forEach var="goods" items="${lists}">
                <tr>
                    <td>${goods.name}</td>
                    <td>${goods.areaId}</td>
                    <td>${goods.price}</td>
                    <td>${goods.startTime}</td>
                    <td><a href="${pageContext.request.contextPath}/goods/${goods.goodsId}">购买</a></td>
                </tr>

            </c:forEach>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>


</body>

</html>
