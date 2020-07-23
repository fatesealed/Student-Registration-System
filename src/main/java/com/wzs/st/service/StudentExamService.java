package com.wzs.st.service;

import com.wzs.st.entity.TestDetailEntity;

import java.util.List;

public interface StudentExamService {
    //根据考试科目id查询考试的省份和地点
    public List<TestDetailEntity> selectExamcourseAddr(String examId);
    //根据考试科目id 省份 城市 地点 查询考试时间段
    public List<TestDetailEntity> selectExamcourseTime(TestDetailEntity entity);
}
