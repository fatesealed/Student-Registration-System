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
                            opts = opts + "<option value='" + val + "' addr='" + res[i].examAdd + "'>" + res[i].province + "-" + res[i].city  + "</option>";//value=考试科目id，文本=考试等级
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
                            var val = res[i].examId + "#" + res[i].examSDateTime + "#" + res[i].examEDateTime;
                            opts = opts + "<option value='" + val + "'>" + res[i].examSDateTime + "-" + res[i].examEDateTime + "</option>"
                            $("#testTime").html(opts);
                        }
                    },
                    error: function () {
                        alert("响应失败");
                    }
                })
            })
            //使用bootstrap进行表单校验
            $("#examForm").bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                }, fields: {
                    username: {
                        validators: {
                            notEmpty: {
                                message: '姓名不能为空'
                            }/*, trigger: 'change'*/


                        }
                    },
                    birthday: {
                        validators: {
                            notEmpty: {
                                message: '生日不能为空'
                            }/*, trigger: 'change'*/

                        }
                    },
                    cardno: {
                        validators: {
                            notEmpty: {
                                message: '证件号码不能为空'
                            }/*, trigger: 'change'*/

                        }
                    },
                    phonenum: {
                        validators: {
                            notEmpty: {
                                message: '联系方式不能为空'
                            }/*, trigger: 'change'*/

                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: '邮箱不能为空'
                            },/*, trigger: 'change'*/
                            regexp: {
                                regexp: /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/,
                                message: '邮箱格式错误'
                            }
                        }
                    },
                    examName: {
                        validators: {
                            notEmpty: {
                                message: '考试科目不能为空'
                            }/*, trigger: 'change'*/

                        }
                    },
                    leval: {
                        validators: {
                            notEmpty: {
                                message: '考试等级不能为空'
                            }/*, trigger: 'change'*/

                        }
                    },
                    addr: {
                        validators: {
                            notEmpty: {
                                message: '考试地点不能为空'
                            }/*, trigger: 'change'*/

                        }
                    }, testTime: {
                        validators: {
                            notEmpty: {
                                message: '考试时间不能为空'
                            }/*, trigger: 'change'*/

                        }
                    }, myFile: {
                        validators: {
                            notEmpty: {
                                message: '请上传照片'
                            }/*, trigger: 'change'*/
                            /*, regexp:{
                                regexp:/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.((jpg)|(png))$/,
                                message: '请上传png/jpg格式'
                            }*/

                        }
                    }

                }

            })
            //初始化校验
            $("#examForm").bootstrapValidator('validate');
        });
    </script>
</head>
<body>

<form id="examForm" action="<%=basePath%>ExamSubjectControl?action=stExam" enctype="multipart/form-data" method="post"
      class="form-inline">

    <table class="table table-bordered table-hover definewidth m10" style="width:50%;margin:0 auto;">
        <caption><h2>考生报名</h2></caption>
        <tr>
            <td width="20%" class="tableleft" style="text-align: right; font-size:13px;padding-right:50px;">
                <span style="float:right;">${user.stuUserName}您已登录,&nbsp;&nbsp;<a
                        href="<%=basePath%>StudentExitControl">[退出]</a></span>
            </td>

        </tr>
        <tr>
            <td>
                <div class="formRow">
                    <div class="form-group col-md-1">
                        <label class="col-md-1">姓名</label>
                        <input class="col-md-1" type="text" name="username" class="form-control"/>
                    </div>

                    <div class="form-group col-md-1">
                        <label>生日</label>
                        <input type="text" name="birthday" class="form-control"/>
                    </div>
                </div>

            </td>

        </tr>

        <tr>
            <td>
                <div class="formRow">
                    <div class="form-group">
                        <label>性别</label>
                        男<input type="radio" name="sex" value="1" checked class="form-control"/>
                        女<input type="radio" name="sex" value="0" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label>身份证号码</label>
                        <input type="text" name="cardno" class="form-control"/>
                    </div>
                </div>

            </td>

        </tr>

        <tr>

            <td>
                <div class="formRow">
                    <div class="form-group">
                        <label>联系方式</label>
                        <input type="text" name="phonenum" class="form-control"/>

                    </div>

                    <div class="form-group">
                        <label>邮箱</label>
                        <input type="text" name="email" class="form-control"/>
                    </div>
                </div>

            </td>

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
            <td>

                <div class="formRow">
                    <div class="form-group">
                        <label>上传照片</label>
                        <input type="file" name="myFile" class="form-control">
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

