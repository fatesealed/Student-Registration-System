package com.wzs.affairs.control;

import com.wzs.affairs.service.AffairsStudentExamInfoService;
import com.wzs.affairs.service.AffairsStudentExamInfoServiceImpl;
import com.wzs.comm.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//考务人员对考生信息进行处理
@WebServlet("/AffairStudentExamInfoControl.do")
public class AffairStudentExamInfoControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        //查询报考人员信息及科目信息
        //分页查询
        if (action != null && action.equals("selectStudentExampInfo")) {
            String pageNow = req.getParameter("pageNow");
            //如果页号为空 默认为1
            if (pageNow == null) {
                pageNow = "1";
            }
            AffairsStudentExamInfoService s = new AffairsStudentExamInfoServiceImpl();
            PageUtils utils = new PageUtils();
            //设置当前页码
            utils.setPageNow(Integer.parseInt(pageNow));
            //计算总条数
            int total = s.selectAffirStuExamTotal(utils);
            //设置总记录数，计算出总页数
            utils.setTotal(total);
            if (utils.getPageNow() <= 1) {
                utils.setPageNow(1);
            }
            if (utils.getPageNow() >= utils.getPageTotal()) {
                utils.setPageNow(utils.getPageTotal());
            }
            //如果一页显示的比总数都多，那么显示第一页
            if (utils.getPageSize() >= total) {
                utils.setPageNow(1);
            }
            List<Map<String, Object>> list = s.selectAffirStuExamPageRows(utils);
            req.setAttribute("rows", list);
            utils.setSqlWhere(null);
            req.setAttribute("pageUtils", utils);
            req.getRequestDispatcher("page/affairs/studentExamInfoList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
