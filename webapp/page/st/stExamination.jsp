<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
        /*
        * $(document)选择当前文本对象
        * ready方法表示当前页面加载完毕后指定动作
        * JSON是一种数据格式:var a={"username":"zyg","age":23}
        *JSON数组：var b=[{"username":"zyg","age":23},{"username":"JONES","age":23}]
        * a.username
        * b[1].username
        * b[1].age
        *
        * JSON数据格式转换可以通过第三方工具包或者java 类方法进行转换
        * 这次我们准备使用开源的工具类转换
        * */
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
                            var val = res[i].examIdX + ":" + res[i].province + ":" + res[i].city + ":" + res[i].examAdd;
                            opts = opts + "<option value='" + val + "'>" + res[i].province + "-" + res[i].city + "-" + res[i].examAdd + "</option>";//value=考试科目id，文本=考试等级
                            $("#addr").html(opts);

                        }
                    },
                    error: function () {//服务器端响应失败执行的方法
                        alert("系统响应失败！");
                    }


                });

            });
        });
    </script>
</head>
<body>

<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10" style="width:50%;margin:0 auto;">
        <caption><h2>考生报名</h2></caption>
        <tr>
            <td width="20%" class="tableleft" colspan="2" style="text-align: right; font-size:13px;padding-right:50px;">
                <span style="float:right;">${user.stuUserName}您已登录,&nbsp;&nbsp;<a href="#">[退出]</a></span>
            </td>

        </tr>
        <tr>
            <td width="20%" class="tableleft">姓名</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td class="tableleft">出生日期</td>
            <td><input type="password" name="password"/></td>
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
            <td><input type="text" name="realname"/></td>
        </tr>
        <tr>
            <td class="tableleft">联系方式</td>
            <td><input type="text" name="realname"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td class="tableleft">考试科目</td>
            <td>
                <!--
                 这里通过下拉列表选项变化时，发送一个异步请求，查询等级
                 AJax 异步请求：通过JS  XMLHTTPRequest对象，通过客户端向服务器端异步交互数据的技术，实现页面局部刷新；
                 一般不直接写原生js实现，而是通过jquery或者其他js框架实现；
                -->
                <select name="examName" id="examName">
                    <option>--请选择--</option>
                    <c:forEach items="${examNames}" var="row">
                        <option value="${row.examName}">${row.examName}</option>
                    </c:forEach>

                </select>

            </td>
        </tr>
        <tr>
            <td class="tableleft">考试等级</td>
            <td>
                <select name="leval" id="leval">
                    <option>--请选择--</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="tableleft">报考地区</td>
            <td>
                <select name="addr" id="addr">
                    <option>--请选择--</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="tableleft">考试时间</td>
            <td>
                <select name=" ">
                    <option>--请选择--</option>
                </select>

            </td>
        </tr>
        <tr>
            <td class="tableleft">上传照片</td>
            <td><input type="file" name="email"/></td>
        </tr>


        <tr>

            <td colspan="2" style="text-align: center">
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
        $('#backid').click(function () {
            window.location.href = "index.html";
        });

    });
</script>

