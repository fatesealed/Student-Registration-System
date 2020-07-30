package com.wzs.st.control;

import com.wzs.comm.utils.DateUtils;
import com.wzs.comm.utils.JsonUtils;
import com.wzs.st.entity.*;
import com.wzs.st.service.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 定义一个action属性，要求每个走该servlet的请求都必须传递一个action属性，区分不同的请求
 */
@WebServlet("/ExamSubjectControl")
public class ExamSubjectControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");//修改响应数据编码格式
        StudentRegistService registService = new StudentRegistServiceImpl();
        StudentLoginService loginService = new StudentLoginServiceImpl();
        String action = req.getParameter("action");
        //查询报考科目等等级列表（根据科目名称）
        if (action != null && action.equals("selectExamNames")) {
            String examName = req.getParameter("examName");
            List<TestSubjectEntity> levals = loginService.selectLevalS(examName);
            //将数据转为json格式字符串，异步响应客户端
            String jsonStr = JsonUtils.listToJson(levals);
            System.out.println("JSON:" + jsonStr);
            PrintWriter out = resp.getWriter();
            out.print(jsonStr);
            out.close();

        }
        //根据 考试科目id 查询考试地点信息列表
        else if (action != null && action.equals("selectExamAddr")) {
            String examId = req.getParameter("examId");
            StudentExamService service = new StudentExamServiceImpl();
            List<TestDetailEntity> list = service.selectExamcourseAddr(examId);
            String jsonStr = JsonUtils.listToJson(list);
            System.out.println("JSON:" + jsonStr);
            PrintWriter out = resp.getWriter();
            out.print(jsonStr);
            out.close();
        }
        //根据考试科目id 省份 城市 具体时间查询考试时间段列表
        else if (action != null && action.equals("selectExamBetweenTimes")) {
            String items = req.getParameter("items");
            String[] itemsArray = items.split(":");
            String examId = itemsArray[0];
            String province = itemsArray[1];
            String city = itemsArray[2];
            String addr = itemsArray[3];
            StudentExamService service = new StudentExamServiceImpl();
            TestDetailEntity e = new TestDetailEntity();
            e.setExamId(examId);
            e.setProvince(province);
            e.setCity(city);
            e.setExamAdd(addr);
            List<TestDetailEntity> list = service.selectExamcourseTime(e);
            //把查询到的list转换为json字符串，异步相应客户端
            String jsonStr = JsonUtils.listToJson(list);
            System.out.println("JSON:" + jsonStr);
            PrintWriter out = resp.getWriter();
            out.print(jsonStr);
            out.close();
        }
        //考生报考信息提交
        else if (action != null && action.equals("stExam")) {
            StudentExamService service = new StudentExamServiceImpl();
            //创建文件扫描工厂类
            FileItemFactory factory = new DiskFileItemFactory();
            //文件上传处理器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解析请求信息
            List<FileItem> fileItemList = null;
            try {
                //获得信息
                fileItemList = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            if (fileItemList != null && fileItemList.size() > 0) {
                StuDetailInfEntity stu = new StuDetailInfEntity();
                StuUserInfoEntity user = (StuUserInfoEntity) req.getSession().getAttribute("user");
                //查询简单信息并且构造详细信息的Id
                stu.setStuId(user.getStuId());
                SubjectInformationEntity subject = new SubjectInformationEntity();
                subject.setStuID(stu.getStuId());
                //指示器
                Iterator<FileItem> iterator = fileItemList.iterator();
                InputStream settingInput = ExamSubjectControl.class.getClassLoader().getResourceAsStream("setting.properties");
                Properties properties = new Properties();
                properties.load(settingInput);
                while (iterator.hasNext()) {
                    FileItem item = iterator.next();
                    //判断表单中数据是否是正常的表单数据，非文件数据
                    if (item.isFormField()) {
                        //获取页面Input的name属性值
                        String fieldName = item.getFieldName();
                        if (fieldName != null && fieldName.equals("username")) {
                            String username = item.getString();
                            username = new String(username.getBytes("iso-8859-1"), "utf-8");
                            stu.setStuName(username);
                        }
                        if (fieldName != null && fieldName.equals("birthday")) {
                            String birthday = item.getString();
                            stu.setStuBirth(birthday);
                        }
                        if (fieldName != null && fieldName.equals("sex")) {
                            String sex = item.getString();
                            stu.setStuSex(sex);
                        }
                        if (fieldName != null && fieldName.equals("cardno")) {
                            String cardno = item.getString();
                            stu.setStuIdNum(cardno);
                        }
                        if (fieldName != null && fieldName.equals("phonenum")) {
                            String phonenum = item.getString();
                            stu.setStuTel(phonenum);
                        }
                        if (fieldName != null && fieldName.equals("testTime")) {
                            String subjectDetail = item.getString();
                            if (subjectDetail != null) {
                                String detailId = subjectDetail.split("#")[0];
                                subject.setExamIdX(detailId);
                                subject.setAppDateTime(DateUtils.getCurrentTime());
                                subject.setVerState("N");
                            }
                        }
                        if (fieldName != null && fieldName.equals("email")) {
                            String email = item.getString();
                            stu.setStuEmail(email);
                        }
                    } else {
                        //图片了图片了
                        InputStream input = item.getInputStream();
                        //获取文件存储路径
                        String pathStr = properties.getProperty("PHOTO_IMG_PATH");
                        File filepath = new File(pathStr);
                        if (!filepath.exists()) {
                            //如果不存在 创建目录
                            filepath.mkdirs();
                        }
                        String fileName = item.getName();//获取文件名
                        String fileType = fileName.substring(fileName.lastIndexOf("."));
                        stu.setStuPicName(stu.getStuId() + fileType);//封装文件名
                        File file = new File(pathStr + "/" + stu.getStuId() + fileType);
                        FileOutputStream outputStream = new FileOutputStream(file);
                        //每次读取字节数据，存入该数组中
                        byte[] i = new byte[1024 * 100];
                        //每次读取字节的个数，即每次读取数据的长度
                        int length = 0;
                        //返回-1表示读完了
                        while ((length = (input.read(i))) != -1) {
                            outputStream.write(i, 0, length);
                        }
                        //关闭输入输出流
                        outputStream.close();
                        input.close();
                    }
                }
                stu.setStuPicUrl(properties.getProperty("PHOTO_IMG_PATH"));
                settingInput.close();
                service.insertStuInfo(stu);
                service.insertSubInfo(subject);
            }
            //查询个人信息以及报考信息列表
            resp.sendRedirect("ExamSubjectControl?action=selectStuExamInfo");
        }
        //查询个人信息以及报考信息列表
        else if (action != null && action.equals("selectStuExamInfo")) {
            StudentExamService examService = new StudentExamServiceImpl();
            //获取考生实体
            StuUserInfoEntity user = (StuUserInfoEntity) req.getSession().getAttribute("user");
            //考生登陆的id
            String stuId = user.getStuId();
            StudentRegistService service = new StudentRegistServiceImpl();
            //查询消息实体
            StuDetailInfEntity stuEntity = registService.selectDetailInfById(stuId);
            req.setAttribute("stuInfo", stuEntity);
            //查询报考信息列表
            List<Map<String, Object>> examRows = examService.selectExamDetailList(stuId);
            req.setAttribute("examRows", examRows);
            //最后实现页面跳转
            req.getRequestDispatcher("/page/st/stExaminationInfo.jsp").forward(req, resp);
        }
        //删除一条报考信息
        else if (action != null && action.equals("resetExam")) {
            String appID = req.getParameter("appID");
            StudentExamService examService = new StudentExamServiceImpl();
            int i = examService.resetExamBySubjectId(appID);
            if (i > 0) {
                String jsonStr = JsonUtils.objectToJson("1");
                PrintWriter out = resp.getWriter();
                out.print(jsonStr);
                out.close();
            } else {
                String jsonStr = JsonUtils.objectToJson("0");
                PrintWriter out = resp.getWriter();
                out.print(jsonStr);
                out.close();
            }
        }
        //加载考试报名界面
        else if (action != null && action.equals("loadExamPage")) {
            List<TestSubjectEntity> list = loginService.selectExamNames();
            //查询考试科目
            req.setAttribute("examNames", list);
            //查询报考个人信息以及报考信息列表
            StuUserInfoEntity user = (StuUserInfoEntity) req.getSession().getAttribute("user");
            //获取考生登陆的id
            String stuId = user.getStuId();
            StuDetailInfEntity stuDetailInfEntity = registService.selectDetailInfById(stuId);
            req.setAttribute("stuInfo", stuDetailInfEntity);
            req.getRequestDispatcher("/page/st/stExaminationAgain.jsp").forward(req, resp);
        }
        //报考其他科目
        else if(action!=null&&action.equals("reApply")){
            //这里学生信息就不用重新写了 只需要写报考的额外信息
            StuUserInfoEntity user = (StuUserInfoEntity) req.getSession().getAttribute("user");
            SubjectInformationEntity entity=new SubjectInformationEntity();
            entity.setStuID(user.getStuId());
            String subjectDetail = req.getParameter("testTime");
            if (subjectDetail != null) {
                String detailId = subjectDetail.split("#")[0];
                entity.setExamIdX(detailId);
                entity.setAppDateTime(DateUtils.getCurrentTime());
                entity.setVerState("N");
            }
            StudentExamService service=new StudentExamServiceImpl();
            service.insertSubInfo(entity);
            //操作完之后刷新页面
            resp.sendRedirect("ExamSubjectControl?action=selectStuExamInfo");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

