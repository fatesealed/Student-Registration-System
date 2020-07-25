package com.wzs.test;

import com.wzs.st.dao.StuUserInfoDao;
import com.wzs.st.dao.StuUserInfoDaoImpl;
import com.wzs.st.entity.StuUserInfoEntity;
import org.junit.Test;

import java.util.List;

/**
 * @author dell
 * @date 2020/7/18 14:29 test1
 */

public class test1 {
    @Test
    public void test_save() {
        System.out.println("+++");
        StuUserInfoEntity e = new StuUserInfoEntity();
        e.setStuUserName("lyx");
        e.setStuId("52424");
        e.setStuPassword("123456");
        e.setRegDate("2014-9-9");
        StuUserInfoDao dao = new StuUserInfoDaoImpl();
        int i = dao.insertStuUserInfo(e);
        System.out.println(i);
    }
    @Test
    public void test_select(){
        StuUserInfoDao dao=new StuUserInfoDaoImpl();
        List<StuUserInfoEntity> list=dao.selectStudentIdInfoList();
        if(list!=null){
            for(int i=0;i<list.size();i++){
                StuUserInfoEntity e=list.get(i);
                System.out.println(e.getStuId()+":"+e.getStuUserName());
            }
        }
    }
    @Test
    public void test_delete(){
        StuUserInfoDao dao=new StuUserInfoDaoImpl();
        dao.deleteStudentIdInformation("7652139c-f527-4a90-b0d1-791fd22a99db");
    }
    @Test
    public void test_update(){
        StuUserInfoDao dao=new StuUserInfoDaoImpl();
        StuUserInfoEntity entity=dao.selectStudentIdInfoById("123456");
        entity.setStuUserName("zhangsan");
        entity.setStuPassword("654321");
        dao.updateStudentIdInformation(entity);
    }
}
