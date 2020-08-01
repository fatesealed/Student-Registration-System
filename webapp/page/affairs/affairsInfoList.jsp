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
<form class="form-inline definewidth m20" action="index.html" method="get">
    <button type="submit" class="btn btn-primary">新增</button>&nbsp;&nbsp;
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>用户名</th>
        <th>密码</th>
        <th>创建时间</th>
        <th>角色</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${rows}" var="e" varStatus="a">
        <tr id="${e.examIdX}">
            <td>${a.count}</td>
            <td>${e.stuName}</td>
            <td>${e.examName}</td>
            <td>${e.examGrade}</td>
            <td>${e.province}-${e.city}-${e.examAdd}</td>
            <td>${e.examSDateTime}-${e.examEDateTime}</td>
            <td>${e.appDateTime}</td>
            <td>
                <c:if test="${e.verState=='F'}">审核未通过</c:if>
                <c:if test="${e.verState=='Y'}">已审核</c:if>
                <c:if test="${e.verState=='N'}">待审核</c:if>
            </td>
            <td>${e.verCase}</td>
            <td>${e.verDateTime}</td>
            <td>
                <a href="edit.html">审核</a>
                <a href="edit.html">查看</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="11">
            <a href="<%=basePath%>AffairStudentExamInfoControl.do?action=selectStudentExampInfo&pageNow=1">首页</a>
            <a href="<%=basePath%>AffairStudentExamInfoControl.do?action=selectStudentExampInfo&pageNow=${pageUtils.pageNow-1}">上一页</a>
            <a href="<%=basePath%>AffairStudentExamInfoControl.do?action=selectStudentExampInfo&pageNow=${pageUtils.pageNow+1}">下一页</a>
            <a href="<%=basePath%>AffairStudentExamInfoControl.do?action=selectStudentExampInfo&pageNow=${pageUtils.pageTotal}">尾页</a>
            当前页码${pageUtils.pageNow},共${pageUtils.total}条记录，总页数：${pageUtils.pageTotal}
        </td>
    </tr>
</table>
</body>
</html>
<script>
    $(function () {
        $('#addnew').click(function () {

            window.location.href = "add.html";
        });


    });

    function del(id) {


        if (confirm("确定要删除吗？")) {

            var url = "index.html";

            window.location.href = url;

        }


    }
</script>