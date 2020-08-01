<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="/page/common/include.jsp" %>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>

<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10" style="width:50%;margin:0 auto;">
        <caption><h2>考务信息编辑</h2></caption>
        <tr>
            <td width="20%" class="tableleft" colspan="2" style="text-align: right; font-size:13px;padding-right:50px;">
                xx已登录！
            </td>

        </tr>
        <tr>
            <td width="20%" class="tableleft">姓名</td>
            <td><input type="text" name="username" value="张三"/></td>
        </tr>
        <tr>
            <td class="tableleft">出生日期</td>
            <td><input type="text" name="" value="1999-10-10"/></td>
        </tr>
        <tr>
            <td class="tableleft">性别</td>
            <td>
                <input type="radio" name="sex" value="1" checked/> 男
                <input type="radio" name="sex" value="0"/> 女
            </td>
        </tr>
        <tr>
            <td class="tableleft">身份证号码</td>
            <td><input type="text" name="realname" value="23232323232323"/></td>
        </tr>
        <tr>
            <td class="tableleft">联系方式</td>
            <td><input type="text" name="realname" value="1590107878"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email" value="123321@123.com"/></td>
        </tr>

        <tr>
            <td class="tableleft">是否管理员</td>
            <td>
                <select name=" ">
                    <option>是</option>
                </select>

            </td>
        </tr>

        <tr>

            <td colspan="2" style="text-align: center">
                <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
                <button type="submit" class="btn btn-primary" type="button">取消</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    $(function () {
        $('#backid').click(function () {
            window.location.href = "index.html";
        });

    });
</script>

