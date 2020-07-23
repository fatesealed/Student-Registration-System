package com.wzs.st.control;

import com.wzs.st.service.StudentRegistService;
import com.wzs.st.service.StudentRegistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description: StuRegistControl <br>
 * date: 2020/7/20 14:34 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
@WebServlet("/StuRegistControl")
public class StuRegistControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理客户端请求");
        String username=req.getParameter("username");
        String pwd=req.getParameter("password");
        String id=req.getParameter("userId");
        StudentRegistService service=new StudentRegistServiceImpl();
        int i=service.stuRegist(username,pwd,id);
        if(i>0){
            resp.sendRedirect("page/st/stLogin.jsp");
        }
        else {
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
