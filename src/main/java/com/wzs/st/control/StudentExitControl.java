package com.wzs.st.control;

import com.wzs.st.entity.StuUserInfoEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/StudentExitControl")
public class StudentExitControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        StuUserInfoEntity user = (StuUserInfoEntity) session.getAttribute("user");
        if (user != null) {
            session.removeAttribute("user");
        }
        //销毁session
        session.invalidate();
        req.getRequestDispatcher("page/st/stLogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
