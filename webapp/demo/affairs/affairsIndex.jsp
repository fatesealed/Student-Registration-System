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
    <link href="<%=basePath%>comm/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>comm/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>comm/assets/css/main-min.css" rel="stylesheet" type="text/css" />


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

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">root</span><a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>
           <%-- <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>--%>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/bui-min.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[{id:'12',text:'考务管理',href:'<%=basePath%>demo/affairs/affairsInfoList.jsp'},{id:'3',text:'考生管理',href:'<%=basePath%>demo/affairs/studentInfoList.jsp'},{id:'4',text:'考生信息统计管理',href:'<%=basePath%>demo/affairs/stInfoStatistics.jsp'},{id:'6',text:'个人信息管理',href:'<%=basePath%>demo/affairs/affairInfo.jsp'}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>
