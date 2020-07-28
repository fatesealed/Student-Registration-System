<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/7/28
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    String imgPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()  + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/bootstrap-responsive.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>comm/Css/style.css"/>
<script type="text/javascript" src="<%=basePath%>comm/Js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/Js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/Js/ckform.js"></script>
<script type="text/javascript" src="<%=basePath%>comm/Js/common.js"></script>
<link rel="stylesheet" type="text/css"
      href="<%=basePath%>comm/bootstrapvalidator-0.4.5/dist/css/bootstrapValidator.min.css">
<script type="text/javascript"
        src="<%=basePath%>comm/bootstrapvalidator-0.4.5/dist/js/bootstrapValidator.min.js"></script>

