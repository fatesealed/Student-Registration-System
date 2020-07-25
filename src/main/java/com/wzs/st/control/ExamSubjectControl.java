package com.wzs.st.control;

import com.wzs.comm.utils.JsonUtils;
import com.wzs.st.entity.TestDetailEntity;
import com.wzs.st.entity.TestSubjectEntity;
import com.wzs.st.service.StudentExamService;
import com.wzs.st.service.StudentExamServiceImpl;
import com.wzs.st.service.StudentLoginService;
import com.wzs.st.service.StudentLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: zyg
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: ytzhaof@isoftstone.com
 * @Date: 2020/7/22 10:40
 * @Version: 1.0
 * @Description: 定义一个action属性，要求每个走该servlet的请求都必须传递一个action属性，区分不同的请求
 * <a href="ExamSubjectControl?action="selectExamNames>查询xxxA</a>
 * <a href="ExamSubjectControl?action="selectEvals>查询xxxB</a>
 */
@WebServlet("/ExamSubjectControl")
public class ExamSubjectControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");//修改响应数据编码格式
        StudentLoginService registService = new StudentLoginServiceImpl();
        String action = req.getParameter("action");
        //查询报考科目等等级列表（根据科目名称）
        if (action != null && action.equals("selectExamNames")) {
            String examName = req.getParameter("examName");
            List<TestSubjectEntity> levals = registService.selectLevalS(examName);
                /*for(int i=0;i<levals.size();i++){
                    System.out.println(levals.get(i).getLeval());
                }*/
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
            List<TestDetailEntity> list=service.selectExamcourseTime(e);
            //把查询到的list转换为json字符串，异步相应客户端
            String jsonStr=JsonUtils.listToJson(list);
            System.out.println("JSON:"+jsonStr);
            PrintWriter out=resp.getWriter();
            out.print(jsonStr);
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

