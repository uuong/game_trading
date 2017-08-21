<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/19 0019
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/user">用户资料 <span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/order">充值</a></li>
                <li><a href="${pageContext.request.contextPath}/goods">上架</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">登录
                    </button>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/access/logout" id="logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- Button trigger modal -->


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">

            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/access" method="post">
                    <div class="form-group">
                        <label for="username" class="control-label">用户名:</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">密码:</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                    <a href="${pageContext.request.contextPath}/access/reg">
                        <button type="button" class="btn btn-default">注册</button>
                    </a>
                    <input value="登录" type="submit"  class="btn btn-primary"  >
                </form>
            </div>

        </div>
    </div>
</div>
<div id="message" >xx</div>


<script>

    function login() {
        var username = document.getElementById("username").value;
        var pass = document.getElementById("password").value;

        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/access",
            data: {"username": username, "password": pass},
            success: function (msg) {
                if (msg == "success") {

                }
            },
            error: function (msg) {
                alert("程序出错 请联系管理员");
            }
        })
    }
    $(function () {
        $("#message").hide();
        $("#logout").click(function () {
            $.ajax({
                type: "delete",
                url: "${pageContext.request.contextPath}/access",
                success: function (msg) {
                    alert(msg);
                }
            })
        })

    });
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        var modal = $(this)
        modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body ').val(recipient)
    })
</script>