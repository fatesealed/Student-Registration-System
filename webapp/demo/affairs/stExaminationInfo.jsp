<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/style.css" />
    <script type="text/javascript" src="<%=basePath%>comm/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/common.js"></script>



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
        <caption><h2>考生个人信息</h2></caption>
        <tr>
            <td width="20%" class="tableleft" style="text-align: right; font-size:13px;padding-right:50px;" colspan="3">
                <span style="float:right;">xx您已登录</span>
            </td>


        </tr>
        <tr>

            <td width="20%" class="tableleft">姓名</td>
            <td>张三</td>
            <td  rowspan="5" style="text-align: right;border:0px;padding:0px;margin:0px;" ><image style="border:solid 1px #dddddd; width:150px;height:160px;"  src="<%=basePath%>comm/images/logo_820.jpg"></image></td>
        </tr>
        <tr>
            <td class="tableleft">出生日期</td>
            <td colspan="2">1999-10-10</td>
        </tr>
        <tr>
            <td class="tableleft">性别</td>
            <td colspan="2">
                <input type="radio" name="sex" value="1" checked/> 男
                <input type="radio" name="sex" value="0"/> 女
            </td>
        </tr>
        <tr>
            <td class="tableleft">身份证号码</td>
            <td colspan="2">23232323232323</td>
        </tr>
        <tr>
        <td class="tableleft">联系方式</td>
        <td colspan="2">15901051676</td>
      </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td colspan="2">123123@123.com</td>
        </tr>
        <tr>
            <td class="tableleft">考试科目</td>
            <td colspan="2">
                <select   name=" " >
                    <option>Java 工程师认证</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="tableleft">考试等级</td>
            <td colspan="2">
                <select   name=" " >
                    <option>一级</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="tableleft">报考地区</td>
            <td colspan="2">
                <select   name=" " >
                    <option>北京</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="tableleft">考试时间</td>
            <td colspan="2">
                <select   name=" " >
                    <option>09:00-12:00</option>
                </select>

            </td>
        </tr>


        <tr>

            <td colspan="3" style="text-align: center">
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
        $('#backid').click(function(){
            window.location.href="index.html";
        });

    });
</script>

