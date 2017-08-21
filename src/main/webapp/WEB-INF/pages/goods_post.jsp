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
    <title>商品资料</title>

    <%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/top.jsp" %>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <form action="${pageContext.request.contextPath}/goods/edit" method="post">
            <div class="form-group">
                <label for="name">名称</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="名称">
            </div>
            <div class="form-group">
                <label for="num">数量</label>
                <input type="number" class="form-control" id="num" name="number" placeholder="数量">
            </div>
            <div class="form-group">
                <label for="price">价格</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="价格">
            </div>
            <div class="form-group">
                <label for="price">区域</label>
                <input type="number" class="form-control" id="area" name="areaId" placeholder="区域">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>

    </form>
    </div>
</div>
<div class="col-md-1"></div>
</body>
</html>

