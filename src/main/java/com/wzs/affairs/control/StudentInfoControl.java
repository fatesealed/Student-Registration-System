package com.wzs.affairs.control;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet("/StudentInfoControl.do")
public class StudentInfoControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("upload")) {
            InputStream inputStream = req.getInputStream();
            //创建文件扫描工厂类
            FileItemFactory factory = new DiskFileItemFactory();
            //文件上传处理器
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> fileItemsList = null;//去解析请求信息
            try {
                fileItemsList = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            InputStream inputFileStream = null;
            if (fileItemsList != null && fileItemsList.size() > 0) {
                Iterator<FileItem> iterator = fileItemsList.iterator();
                while (iterator.hasNext()) {
                    FileItem ite = iterator.next();
                    if (!ite.isFormField()) {
                        inputFileStream = ite.getInputStream();
                    }
                }
            }
            //POI 解析EXL
            //创建excel文件的引用
            HSSFWorkbook workbook = new HSSFWorkbook(inputFileStream);
            //创建对工作表的引用
            //按名引用
            HSSFSheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum();
            System.out.println("EXL行数：" + rowCount);
            if (rowCount >= 1) {
                for (int i = 1; i < rowCount + 1; i++) {//注意 getLastRowNum上面获取的是下标不是个数，因此这里rowCount+1
                    HSSFRow row = sheet.getRow(i);//获取行，从第二行获取数据
                    int cellTotal = row.getLastCellNum();
                    Map<String, Object> map = new HashMap<String, Object>();
                    for (int j = 0; j < cellTotal; j++) {
                        String val = null;
                        row.getCell(j).setCellType(CellType.STRING);//强制将单元格转为字符串类型，否则数字认为是整型，会被科学计数
                        val = row.getCell(j).getStringCellValue();
                        map.put("cols_" + j, val);//cols_0 对应姓名，cols_1对应身份证号码，cols_2对应年龄，cols_3 联系方式，cols_4 email

                    }

                    System.out.println(map.get("cols_0") + ":" + map.get("cols_1") + ":" + map.get("cols_2") + ":" + map.get("cols_3") + ":" + map.get("cols_4"));
                    //下面可以写，实例化实体类，然后分别封装上面数据，在add 到list集合中；

                }
            }
            inputFileStream.close();
            inputStream.close();
            // // 封装后此处调用insert方法即可；后面代码略；
            //成功跳转查询操作即可，此处为了演示则直接返回了个jsp；
            req.getRequestDispatcher("page/affairs/studentInfoList.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
