package com.wzs.st.service;

import com.wzs.st.entity.TestSubjectEntity;

import java.util.List;

public interface StudentLoginService {
    //查询所有科目
    public List<TestSubjectEntity> selectExamNames();
    //根据考试科目查询等级
    public List<TestSubjectEntity> selectLevalS(String examName);
}
