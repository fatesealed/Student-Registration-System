<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript">
        function uploadFile() {
            var val = $("#upfile").val().substr($("#upfile").val().lastIndexOf("."));
            if (val == ".xls") {
                $("#uploadForm").submit();
            } else {
                alert("请上传.xls类型文件!");
            }

        }
    </script>
</head>
<body>

<form class="form-inline definewidth m20" enctype="multipart/form-data"
      action="<%=basePath%>StudentInfoControl.do?action=upload" method="post" id="uploadForm">
    <button type="button" style="position:relative;" class="btn btn-primary btn-fill btn-wd" id="btn" name="btn">导入
        <input id="upfile" style="opacity:0;width:100%;height:100%;position:absolute;top:0;left:0" type="file"
               name="myFile" onchange="uploadFile()"/>
    </button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>身份证号码</th>
        <th>年龄</th>
        <th>联系方式</th>
        <th>邮箱</th>
        <th>操作</th>

    </tr>
    </thead>

    <tr>
        <td>1</td>
        <td>JONES</td>
        <td>2323232323</td>
        <td>23</td>
        <td>15901051676</td>
        <td>123@123.com</td>
        <td>
            <a href="#">删除</a>
        </td>
    </tr>

    <tr>
        <td colspan="11">
            <a href="#">首页</a>
            <a href="#">上一页</a>
            <a href="#">下一页</a>
            <a href="#">尾页</a>
            当前页码#,共#条记录，总页数：#
        </td>
    </tr>
</table>
</body>
</html>
