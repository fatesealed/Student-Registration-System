<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/style.css"/>
    <script type="text/javascript" src="<%=basePath%>comm/Js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=basePath%>comm/Js/common.js"></script>
    <link href="<%=basePath%>comm/assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>comm/assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>comm/assets/css/main-min.css" rel="stylesheet" type="text/css"/>


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

        .navOver {
            background: url(http://img04.taobaocdn.com/tps/i4/T1GgTxXm4qXXaGyjny-500-188.png) -9999px -9999px no-repeat;
        }

    </style>
</head>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，${affair.teaName}<span class="dl-log-user"></span><a href="/chinapost/index.php?m=Public&a=logout"
                                                                    title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div>
        </div>
        <ul id="J_Nav" class="nav-list ks-clear">
            <li class="nav-item dl-selected">
                <div class="nav-item-inner nav-home">系统管理</div>
            </li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
        <li class="dl-tab-item">
            <div class="dl-second-nav" style="height: 647px;">
                <div class="dl-second-tree" id="J_1Tree">
                </div>
                <div class="dl-second-slib-con">
                    <div class="dl-second-slib">

                    </div>
                </div>
            </div>
            <div class="dl-inner-tab" id="J_1Tab">
                <div class="bui-nav-tab" aria-disabled="false" style="height: 647px;" aria-pressed="false">
                    <div class="tab-nav-bar"><s class="tab-nav-arrow arrow-left"></s>
                        <div class="tab-nav-wrapper">
                            <div class="tab-nav-inner">
                                <ul class="tab-nav-list" style="width: 140px; left: 0px;" id="mainTab">

                                </ul>
                            </div>
                        </div>
                        <s class="tab-nav-arrow arrow-right">

                        </s>
                    </div>
                    <div class="tab-content-container" style="height: 626px;">
                        <div class="tab-content" style="" id="frameDiv">
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</div>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/bui-min.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main', function () {
        var config = [{
            id: '1', menu: [{
                text: '系统管理', items: [{id: '12', text: '考务管理', href: '<%=basePath%>page/affairs/affairsInfoList.jsp'},
                    {
                        id: '3',
                        text: '考生报考信息管理',
                        href: '<%=basePath%>AffairStudentExamInfoControl.do?action=selectStudentExampInfo&pageNow=1'
                    },
                    {id: '4', text: '考生信息管理', href: '<%=basePath%>page/affairs/studentInfoList.jsp'},
                    {id: '5', text: '考生信息统计管理', href: '<%=basePath%>page/affairs/stInfoStatistics.jsp'},
                    {id: '6', text: '个人信息管理', href: '<%=basePath%>page/affairs/affairInfo.jsp'}]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });

</script>
</body>
</html>
