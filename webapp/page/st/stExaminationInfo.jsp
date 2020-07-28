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
        //取消单场报名
        function resetExam(appID) {
            $.ajax({
                url: "<%=basePath%>ExamSubjectControl?action=resetExam",
                type: "post",
                data: {appID: appID},
                dataType: "json",
                success: function (res) {
                    if (res == "1") {
                        //移除行
                        $("#" + appID).remove();
                        //重新将序号从1排列
                        $("#examTable tr:not(:first)").each(function (index) {//找到的每一个元素，都执行该方法；即遍历每个元素
                            $(this).find("td:first").html(index + 1);
                        });
                    }
                    else {
                        alert("操作失败")
                    }
                },error:function () {
                    alert("系统相应失败")
                }
            })
        }
    </script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10" style="width:50%;margin:0 auto;">
        <caption><h2>考生个人信息</h2></caption>
        <tr>
            <td width="20%" class="tableleft" style="text-align: right; font-size:13px;padding-right:50px;" colspan="3">
                <span style="float:right;">${user.stuUserName}您已登录,&nbsp;&nbsp;<a
                        href="<%=basePath%>StudentExitControl">[退出]</a></span>
            </td>


        </tr>
        <tr>

            <td width="20%" class="tableleft">姓名</td>
            <td>${stuInfo.stuName}</td>
            <td rowspan="5" style="text-align: right;border:0px;padding:0px;margin:0px;">
                <image style="border:solid 1px #dddddd; width:150px;height:160px;"
                       src="<%=imgPath%>/${stuInfo.stuPicUrl}/${stuInfo.stuPicName}"></image>
            </td>
        </tr>
        <tr>
            <td class="tableleft">出生日期</td>
            <td colspan="2">${stuInfo.stuBirth}</td>
        </tr>
        <tr>
            <td class="tableleft">性别</td>
            <td colspan="2">
                <c:if test="${stuInfo.stuSex==1}">男</c:if>
                <c:if test="${stuInfo.stuSex==0}">女</c:if>
            </td>
        </tr>
        <tr>
            <td class="tableleft">身份证号码</td>
            <td colspan="2">${stuInfo.stuIdNum}</td>
        </tr>
        <tr>
            <td class="tableleft">联系方式</td>
            <td colspan="2">${stuInfo.stuTel}</td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td colspan="2">${stuInfo.stuEmail}</td>
        </tr>

    </table>
    <!--报考记录-->
    <a class="btn btn-default" href="<%=basePath%>ExamSubjectControl?action=loadExamPage">报考其他考试</a>
    <table class="table table-bordered table-hover definewidth m10" id="examTable">
        <thead>
        <tr>
            <th>序号</th>
            <th>考试科目</th>
            <th>考试级别</th>
            <th>考试地点</th>
            <th>考试时间</th>
            <th>报考时间</th>
            <th>状态</th>
            <th>原因</th>
            <th>审核时间</th>
            <th>操作</th>


        </tr>
        </thead>
        <c:forEach items="${examRows}" var="e" varStatus="a">
            <tr id="${e.appID}">
                    <%-- 这个count好像不是数据库里面的东西 大概是库里面自带的东西--%>
                <td>${a.count}</td>
                <td>${e.examName}</td>
                <td>${e.examGrade}</td>
                <td>${e.province}-${e.city}-${e.examAdd}</td>
                <td>${e.examSDateTime}-${e.examEDateTime}</td>
                <td>${e.appDateTime}</td>
                <td>
                    <c:if test="${e.verState=='F'}">审核未通过</c:if>
                    <c:if test="${e.verState=='Y'}">已审核</c:if>
                </td>
                <td>${e.checkCause}</td>
                <td>${e.checkTime}</td>
                <td>
                    <c:if test="${e.verState!='Y'}">
                        <a class="btn btn-default" href="javascript:void(0)"
                           onclick="resetExam('${e.appID}')">取消报名</a>
                    </c:if>

                </td>
            </tr>
        </c:forEach>

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

