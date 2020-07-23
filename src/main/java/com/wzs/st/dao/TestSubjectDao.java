package com.wzs.st.dao;

import com.wzs.st.entity.TestSubjectEntity;

import java.util.List;

public interface TestSubjectDao {
    public List<TestSubjectEntity> selectExamNames();
    public List<TestSubjectEntity> selectLevalS(String examName);
}
