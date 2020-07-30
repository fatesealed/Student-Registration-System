package com.wzs.comm.filter;

import com.wzs.st.entity.StuUserInfoEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤客户端发送给服务器端请求的方法；注意：servlet后台跳转servlet，服务器端跳转，不过滤
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getRequestURI();//例如：   /ExamSubjectControl
        String requestURL = path.substring(path.lastIndexOf("/"));
        String staticFileType = null;
        if (requestURL.lastIndexOf(".") != -1) {
            staticFileType = requestURL.substring(requestURL.lastIndexOf("."));
        }
        if (requestURL != null && requestURL.equals("/")) {//项目根目录
            filterChain.doFilter(request, response);//放行
        } else if (requestURL != null && requestURL.equals("/stLogin.jsp")) {//登陆页面
            filterChain.doFilter(request, response);//放行
        } else if (requestURL != null && requestURL.equals("/ValidateCodeControl")) {//登陆页面
            filterChain.doFilter(request, response);//放行
        } else if (requestURL != null && requestURL.equals("/StudentLoginControl")) {//登陆验证的servlet请求
            filterChain.doFilter(request, response);//放行
        } else if (staticFileType != null && staticFileType.toLowerCase().equals(".css")) {
            filterChain.doFilter(request, response);//放行
        } else if (staticFileType != null && staticFileType.toLowerCase().equals(".js")) {
            filterChain.doFilter(request, response);//放行
        } else if (staticFileType != null && (staticFileType.toLowerCase().equals(".jpg") ||
                staticFileType.toLowerCase().equals(".png") ||
                staticFileType.toLowerCase().equals(".gif"))) {
            filterChain.doFilter(request, response);//放行
        } else if (staticFileType != null && (staticFileType.toLowerCase().equals(".jsp"))) {
            filterChain.doFilter(request, response);//放行
        } else if (requestURL != null && requestURL.equals("/affairsLogin.jsp")) {//考务登录页面
            filterChain.doFilter(request, response);//放行
        } else if (staticFileType != null && (staticFileType.toLowerCase().equals(".do"))) {//考务相关请求
            if (requestURL != null && requestURL.equals("/affairLoginControl.do")) {//如果是登录请求，则放行
                filterChain.doFilter(request, response);//放行
            } else {//do结尾，且不是登录请求，判断是否已登录，已登录则放行
                String user = (String) req.getSession().getAttribute("affair");
                if (user != null) {
                    filterChain.doFilter(request, response);//放行
                } else {
                    req.getRequestDispatcher("/page/affairs/affairsLogin.jsp").forward(req, resp);

                }
            }
        } else {
            if (staticFileType != null && (staticFileType.toLowerCase().equals(".do"))) {//访问考务的请求
                String user = (String) req.getSession().getAttribute("affair");
                if (user != null) {
                    filterChain.doFilter(request, response);//放行
                } else {

                    req.getRequestDispatcher("/page/affairs/affairsLogin.jsp").forward(req, resp);
                }

            } else {
                //上面不论用户是否登录成功，都必须要放行；
                //下面：登陆成功放行，未登录返回登录页面
                StuUserInfoEntity user = (StuUserInfoEntity) req.getSession().getAttribute("user");

                if (user != null) {//登录成功过
                    filterChain.doFilter(request, response);//放行
                } else {
                    //返回登录页面
                    resp.sendRedirect("page/st/stLogin.jsp");
                }
            }


        }
    }

    @Override
    public void destroy() {

    }
}
