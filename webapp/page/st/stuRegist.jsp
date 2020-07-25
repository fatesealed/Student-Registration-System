<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<html>
<head>
    <title>考生注册</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <style type="text/css">
        #base {
            margin: 0 auto;
            width: 480px;
            text-align: center;
            margin-top: 200px;
        }

        ul {
            padding: 0px;
            margin: 0px;
            list-style: none;
        }

        .label_field, .label_input, .error_span {
            display: block;
            padding-top: 10px;
            padding-bottom: 5px;
            float: left;
            height: 25px;
            width: 150px;
            padding-bootom: 5px;
            padding-top: 5px;
        }

        #main {
            border: solid 1px #1B3160;
            float: left;
        }

        #main li {
            width: 478px;
            float: left;
        }

        h2 {
            padding-top: 5px;
            padding-bottom: 5px;
            text-align: center;
            margin: 0px;
            color: #fff;
        }

        .error_span {
            padding-left: 20px;
            font-size: 13px;
        }

        .base {
            background-color: #1c6a9e;
            padding: 0px;
            margin: 0px;
        }

    </style>
    <script type="text/javascript">
        function stRegist() {
            var username = document.getElementById("username").value;
            var pwd = document.getElementById("password").value;
            var rpwd = document.getElementById("repassword").value;
            if (username == "") {
                document.getElementById("username_alt").innerHTML = "用户名不能为空";
            } else {
                var reg = /^[A-Za-z0-9]{8,12}$/;
                if (!reg.test(username) || !isNaN((reg))) {
                    document.getElementById("username_alt").innerHTML = "格式错误！A-Za-z0-9组成，8-12位";
                    return;
                }
                document.getElementById("username_alt").innerHTML = "";
                if (pwd == "") {
                    document.getElementById("password_alt").innerHTML = "密码不能为空";
                    return;
                } else {
                    document.getElementById("password_alt").innerHTML = "";
                }
                if (rpwd == "") {
                    document.getElementById("repassword_alt").innerHTML = "重复输入密码不能为空！";
                    return;
                } else {
                    document.getElementById("repassword_alt").innerHTML = "";
                }
                if (rpwd != pwd) {
                    document.getElementById("repassword_alt").innerHTML = "两次输入密码不一致！";
                    return;
                } else {
                    document.getElementById("repassword_alt").innerHTML = "";
                }
                document.getElementById("registForm").submit();
            }
        }
    </script>
</head>
<body>
<div id="base" class="base">
    <h2>考生注册</h2>
    <form action="<%=basePath%>StuRegistControl" method="post" id="registForm">
        <ul id="main">
            <li>
                <label class="label_field">用户名</label>
                <label class="label_input">
                    <input type="text" id="username" name="username">
                </label>
                <label class="error_span">
                    <span id="username_alt" style="color:red"></span>
                </label>
            </li>
            <li>
                <label class="label_field">密码</label>
                <label class="label_input">
                    <input type="password" id="password" name="password">
                </label>
                <label class="error_span">
                    <span id="password_alt" style="color:red"></span>
                </label>
            </li>
            <li>
                <label class="label_field">重复密码</label>
                <label class="label_input">
                    <input type="password" id="repassword" name="repassword">
                </label>
                <label class="error_span">
                    <span id="repassword_alt" style="color:red"></span>
                </label>
            </li>

            <li style="text-align: center">
                <input type="button" value="注册" onclick="stRegist()">
                <input type="reset" value="取消">
            </li>
        </ul>
    </form>
</div>
</body>
</html>
