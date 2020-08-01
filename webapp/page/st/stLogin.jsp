<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <%@include file="/page/common/include.jsp" %>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
    <script>
        function getNewValidateCode(obj) {
            obj.src = "<%=basePath%>ValidateCodeControl?time=" + (new Date()).getMilliseconds();
        }

        //通过jQuery js框架简化js
        function studentLogin() {
            var username = $("#username").val();//$() 选择器   #按照id选择 ；val方法获取value属性
            if (username == "") {
                $("#errorSpan").html("用户名不能为空");
                return;
            }
            var password = $("#password").val();//$() 选择器   #按照id选择 ；val方法获取value属性
            if (password == "") {
                $("#errorSpan").html("密码不能为空");
                return;
            }
            var validateCode = $("#validateCode").val();//$() 选择器   #按照id选择 ；val方法获取value属性
            if (validateCode == "") {
                $("#errorSpan").html("验证码不能为空");
                return;
            }
            $("#loginForm").submit();
        }
    </script>
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" id="loginForm" action="<%=basePath%>StuLoginControl">
        <h2 class="form-signin-heading">考生登录系统</h2>
        <span style="color:red" id="errorSpan"></span>
        <input type="text" id="username" name="username" class="input-block-level" placeholder="账号">
        <input type="password" id="password" name="password" class="input-block-level" placeholder="密码">
        <input type="text" id="validateCode" name="validateCode" class="input-medium" placeholder="验证码">
        <image src="<%=basePath%>ValidateCodeControl" onclick="getNewValidateCode(this)"></image>
        <p>
            <button class="btn btn-large btn-primary" type="button" onclick="studentLogin()">登录</button>
            <a class="btn btn-large btn-primary" href="<%=basePath%>page/st/stuRegist.jsp">注册</a>
            <a class="btn btn-large btn-primary" href="<%=basePath%>page/affairs/affairsLogin.jsp">考务登陆</a>
        </p>
    </form>

</div>
</body>
</html>

