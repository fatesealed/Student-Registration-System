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
    <script>
        $(document).ready(function () {
            //选择考生报考科目列表
            $("#examName").change(function () {
                var examNameVal = $(this).val();

                //发送异步请求，获取考试等级数据
                $.ajax({
                    url: "<%=basePath%>ExamSubjectControl?action=selectExamNames",//访问请求的地址
                    data: {examName: examNameVal},//提交的数据; 第一种：属性=值&属性=值  第二种： {属性：值，属性：值。。。。}
                    type: "post",//请求方式
                    dataType: "json",//响应过来的数据格式;注意后台必须要将响应过来的数据转为json格式字符串；xml，jsonp，text,html,json
                    success: function (res) {//服务器端响应成功，此时执行的方法
                        //使用servlet异步响应客户端数据res，此时res可能是一个json格式字符串，json格式字符串不可以直接对象点获取数据
                        //只用js认为他是对象，此时才可以点属性获取值
                        //最好转换一下，让json格式字符串转为json对象；js中认为json 对象才可以通过点属性获取值；
                        // var result=$.parseJSON(res);//将res 转为json对象，前提是res必须是符合json格式的字符串
                        //alert(res);//如果alert 出来的值为{.....}  [......]具体内容，此时一定为字符串，一定要转对象；否则为object 就不需要转
                        var opts = "<option value=''>--请选择--</option>";
                        for (var i = 0; i < res.length; i++) {
                            opts = opts + "<option value='" + res[i].examId + "'>" + res[i].examGrade + "等级" + "</option>";//value=考试科目id，文本=考试等级
                            $("#leval").html(opts);
                        }
                    },
                    error: function () {//服务器端响应失败执行的方法
                        alert("系统响应失败！");
                    }


                });

            });
            //选择考试等级触发的动作
            $("#leval").change(function () {
                var examId = $(this).val();//考试科目ID
                $.ajax({
                    url: "<%=basePath%>ExamSubjectControl?action=selectExamAddr",
                    data: {examId: examId},
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        var opts = "<option value=''>--请选择--</option>";
                        for (var i = 0; i < res.length; i++) {
                            // alert(res[i].provinces+":"+res[i].city+":"+res[i].testPlace);
                            var val = res[i].examId + ":" + res[i].province + ":" + res[i].city + ":" + res[i].examAdd;
                            opts = opts + "<option value='" + val + "' addr='" + res[i].examAdd + "'>" + res[i].province + "-" + res[i].city + "</option>";//value=考试科目id，文本=考试等级
                            $("#addr").html(opts);

                        }
                    },
                    error: function () {//服务器端响应失败执行的方法
                        alert("系统响应失败！");
                    }


                });

            });
            //选择考试地点触发的动作
            $("#addr").change(function () {
                var addr = $(document.getElementById("addr").options[document.getElementById("addr").selectedIndex]).attr("addr");
                //parent()寻找上一层元素，find表示过滤，找里面的元素
                $(this).parent().find("span").html(addr);
                var val = $(this).val();
                //发送异步请求查询考试时间段列表
                $.ajax({
                    url: "<%=basePath%>ExamSubjectControl?action=selectExamBetweenTimes",
                    data: {items: val},
                    dataType: "json",
                    type: "post",
                    success: function (res) {
                        var opts = "<option value=''>--请选择--</option>";
                        for (var i = 0; i < res.length; i++) {
                            //如果用:后面截取的时候会出问题
                            var val = res[i].examIdX + "#" + res[i].examSDateTime + "#" + res[i].examEDateTime;
                            opts = opts + "<option value='" + val + "'>" + res[i].examSDateTime + "-" + res[i].examEDateTime + "</option>"
                            $("#testTime").html(opts);
                        }
                    },
                    error: function () {
                        alert("响应失败");
                    }
                })
            })
        });
    </script>
</head>
<body>


<table class="table table-bordered table-hover definewidth m10" style="width:50%;margin:0 auto;">
    <caption><h2>考生报名</h2></caption>
    <tr>
        <td width="20%" class="tableleft" style="text-align: right; font-size:13px;padding-right:50px;" colspan="3">
            <span style="float:right;">${user.stuUserName}您已登录,&nbsp;&nbsp;<a href="<%=basePath%>StudentExitControl">[退出]</a></span>
        </td>


    </tr>
    <tr>

        <td width="20%" class="tableleft">姓名</td>
        <td>${stuInfo.stuName}</td>
        <td rowspan="5" style="text-align: right;border:0px;padding:0px;margin:0px;">
            <image style="border:solid 1px #dddddd; width:150px;height:160px;"
                   src="<%=imgPath%>${stuInfo.stuPicUrl}/${stuInfo.stuPicName}"></image>
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

<form id="examForm" action="<%=basePath%>ExamSubjectControl?action=reApply" method="post" class="form-inline">

    <table class="table table-bordered table-hover definewidth m10" style="width:50%;margin:0 auto;">

        <tr>
            <td>

                <div class="formRow">
                    <div class="form-group">
                        <label>考试科目</label>
                        <select name="examName" id="examName" class="form-control">
                            <option value="">--请选择--</option>
                            <c:forEach items="${examNames}" var="row">
                                <option value="${row.examName}">${row.examName}</option>
                            </c:forEach>

                        </select>

                    </div>

                    <div class="form-group">
                        <label>考试等级</label>
                        <select name="leval" id="leval" class="form-control">
                            <option value="">--请选择--</option>
                        </select>

                    </div>
                </div>

            </td>

        </tr>

        <tr>

            <td>

                <div class="formRow">
                    <div class="form-group">
                        <label>报考地区</label>
                        <select name="addr" id="addr" class="form-control">
                            <option value="">--请选择--</option>
                        </select>
                        <span></span>

                    </div>

                    <div class="form-group">
                        <label>考试时间</label>
                        <select name="testTime" id="testTime" class="form-control">
                            <option value="">--请选择--</option>
                        </select>

                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">
                <button type="submit" class="btn btn-primary">保存</button> &nbsp;&nbsp;
                <button type="reset" class="btn btn-primary" type="button">取消</button>
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

