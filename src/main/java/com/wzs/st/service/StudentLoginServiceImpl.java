package com.wzs.st.service;

import com.wzs.st.dao.TestSubjectDao;
import com.wzs.st.dao.TestSubjectDaoImpl;
import com.wzs.st.entity.TestSubjectEntity;

import java.util.List;

/**
 * description: StudentLoginServiceImpl <br>
 * date: 2020/7/22 15:25 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class StudentLoginServiceImpl implements StudentLoginService{
    @Override
    public List<TestSubjectEntity> selectExamNames() {
        TestSubjectDao dao=new TestSubjectDaoImpl();
        List<TestSubjectEntity> list=dao.selectExamNames();
        return list;
    }

    @Override
    public List<TestSubjectEntity> selectLevalS(String examName) {
        TestSubjectDao dao=new TestSubjectDaoImpl();
        List<TestSubjectEntity> list=dao.selectLevalS(examName);
        return list;
    }
}
