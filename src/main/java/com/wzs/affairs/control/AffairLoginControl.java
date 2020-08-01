package com.wzs.affairs.control;

import com.wzs.affairs.entity.AffairEntity;
import com.wzs.affairs.service.AffairLoginService;
import com.wzs.affairs.service.AffairLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/affairLoginControl.do")
public class AffairLoginControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AffairLoginService loginService = new AffairLoginServiceImpl();
        if (username != null && password != null) {
            AffairEntity entity = loginService.affairLogin(username, password);
            if (entity != null) {
                //能找到
                entity.setTeaPassword("***");
                //登陆成功 将实体放入整个对话中，用于整个会话
                req.getSession().setAttribute("affair", entity);
                //判断用户是否存在，存在则表明填写过，走个人信息查询
                req.getRequestDispatcher("/page/affairs/affairsIndex.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/page/affairs/affairsLogin.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/page/affairs/affairsLogin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
