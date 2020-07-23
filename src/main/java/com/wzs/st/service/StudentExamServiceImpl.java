package com.wzs.st.service;

import com.wzs.st.dao.TestDetailDao;
import com.wzs.st.dao.TestDetailDaoImpl;
import com.wzs.st.entity.TestDetailEntity;

import java.util.List;

/**
 * description: StudentExamServiceImpl <br>
 * date: 2020/7/23 11:45 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class StudentExamServiceImpl implements StudentExamService{
    @Override
    public List<TestDetailEntity> selectExamcourseAddr(String examId) {
        //System.out.println("111");
        TestDetailDao dao=new TestDetailDaoImpl();
        List<TestDetailEntity> list=dao.selectExamcourseAddr(examId);
        return list;
    }

    @Override
    public List<TestDetailEntity> selectExamcourseTime(TestDetailEntity entity) {
        TestDetailDao dao=new TestDetailDaoImpl();
        List<TestDetailEntity> list=dao.selectExamcourseTime(entity);
        return list;
    }
}
