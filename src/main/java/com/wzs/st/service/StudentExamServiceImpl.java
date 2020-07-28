package com.wzs.st.service;

import com.wzs.st.dao.*;
import com.wzs.st.entity.StuDetailInfEntity;
import com.wzs.st.entity.SubjectInformationEntity;
import com.wzs.st.entity.TestDetailEntity;

import java.util.List;

/**
 * description: StudentExamServiceImpl <br>
 * date: 2020/7/23 11:45 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class StudentExamServiceImpl implements StudentExamService {
    @Override
    public List<TestDetailEntity> selectExamcourseAddr(String examId) {
        TestDetailDao dao = new TestDetailDaoImpl();
        List<TestDetailEntity> list = dao.selectExamcourseAddr(examId);
        return list;
    }

    @Override
    public List<TestDetailEntity> selectExamcourseTime(TestDetailEntity entity) {
        TestDetailDao dao = new TestDetailDaoImpl();
        List<TestDetailEntity> list = dao.selectExamcourseTime(entity);
        return list;
    }

    @Override
    public int insertStuInfo(StuDetailInfEntity entity) {
        StuDetailInfDao dao = new StuDetailInfDaoImpl();
        int i = dao.insertStuInf(entity);
        return i;
    }

    @Override
    public int insertSubInfo(SubjectInformationEntity entity) {
        SubjectInformationDao dao=new SubjectInformationDaoImpl();
        int i=dao.insertSubjectInformation(entity);
        return i;
    }
}
