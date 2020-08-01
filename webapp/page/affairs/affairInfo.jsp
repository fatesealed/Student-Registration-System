<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="/page/common/include.jsp" %>
    <title>考务个人信息</title>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }


    </style>
</head>
<body>

<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10" style="width:50%;margin:0 auto;">
        <caption><h2>考务个人信息</h2></caption>
        <tr>
            <td width="20%" class="tableleft" colspan="2" style="text-align: right; font-size:13px;padding-right:50px;">
                xx已登录！
            </td>

        </tr>
        <tr>
            <td width="20%" class="tableleft">姓名</td>
            <td>张三</td>
        </tr>
        <tr>
            <td class="tableleft">出生日期</td>
            <td>1999-10-10</td>
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
            <td>2323232323232</td>
        </tr>
        <tr>
            <td class="tableleft">联系方式</td>
            <td>23302981838</td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td>123321@123.com</td>
        </tr>

        <tr>
            <td class="tableleft">角色</td>
            <td>
                普通考务人员
            </td>
        </tr>

        <tr>

            <td colspan="2" style="text-align: center">
                <button type="submit" class="btn btn-primary" type="button">返回</button> &nbsp;&nbsp;

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

