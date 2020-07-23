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
<form class="form-inline definewidth m20" action="index.html" method="get">
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增用户</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>考试科目</th>
        <th>考试地点</th>
        <th>考试时间</th>
        <th>等级</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tr>
        <td>1</td>
        <td>张三</td>
        <td>男</td>
        <td>计算机等级考试</td>
        <td>北京</td>
        <td>2020-10-10 09:00-12:00</td>
        <td>一级</td>
        <td>已审核</td>
        <td>
            <a href="edit.html">审核</a>
            <a href="edit.html">编辑</a>
            <a href="edit.html">删除</a>

        </td>
    </tr>
</table>
</body>
</html>
<script>
    $(function () {


        $('#addnew').click(function(){

            window.location.href="add.html";
        });


    });

    function del(id)
    {


        if(confirm("确定要删除吗？"))
        {

            var url = "index.html";

            window.location.href=url;

        }




    }
</script>