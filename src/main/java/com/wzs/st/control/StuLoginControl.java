package com.wzs.st.control;

import com.wzs.st.entity.StuDetailInfEntity;
import com.wzs.st.entity.StuUserInfoEntity;
import com.wzs.st.entity.TestSubjectEntity;
import com.wzs.st.service.StudentLoginService;
import com.wzs.st.service.StudentLoginServiceImpl;
import com.wzs.st.service.StudentRegistService;
import com.wzs.st.service.StudentRegistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * description: StuLoginControl <br>
 * date: 2020/7/21 15:53 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
@WebServlet("/StuLoginControl")
//登陆控制类
public class StuLoginControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentRegistService service = new StudentRegistServiceImpl();
        StudentLoginService loginService=new StudentLoginServiceImpl();
        String validateCode = req.getParameter("validateCode");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (validateCode != null) {
            String sessionValidateCode = req.getSession().getAttribute("VALIDATE_CODE") != null ? req.getSession().getAttribute("VALIDATE_CODE").toString() : null;
            //if (validateCode.toLowerCase().equals(sessionValidateCode.toLowerCase()))
            if(true){
                //字符串比较要用equal
                StuUserInfoEntity entity = service.stuLogin(username, password);
                if (entity != null) {
                    //能找到
                    entity.setStuPassword("***");
                    //登陆成功 将实体放入整个对话中，用于整个会话
                    req.getSession().setAttribute("user", entity);
                    //判断用户是否存在，存在则表明填写过，走个人信息查询
                    //不存在就去报考
                    StuDetailInfEntity stInfo = service.selectDetailInfById(entity.getStuId());
                    if (stInfo != null) {
                        req.getRequestDispatcher("page/st/stExaminationInfo.jsp").forward(req, resp);
                    } else {
                        List<TestSubjectEntity> list=loginService.selectExamNames();
                        req.setAttribute("examNames",list);
                        req.getRequestDispatcher("page/st/stExamination.jsp").forward(req, resp);
                    }

                } else {//不匹配（大概吧
                    req.getRequestDispatcher("page/st/stLogin.jsp").forward(req, resp);
                }
            } else {
                //验证码不匹配
                req.getRequestDispatcher("page/st/stLogin.jsp").forward(req, resp);
            }
        } else {
            //验证码为空
            req.getRequestDispatcher("page/st/stLogin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
