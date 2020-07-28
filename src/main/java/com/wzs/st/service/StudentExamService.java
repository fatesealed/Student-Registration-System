package com.wzs.st.service;

import com.wzs.st.entity.StuDetailInfEntity;
import com.wzs.st.entity.SubjectInformationEntity;
import com.wzs.st.entity.TestDetailEntity;

import java.util.List;
import java.util.Map;

public interface StudentExamService {
    //根据考试科目id查询考试的省份和地点
    public List<TestDetailEntity> selectExamcourseAddr(String examId);
    //根据考试科目id 省份 城市 地点 查询考试时间段
    public List<TestDetailEntity> selectExamcourseTime(TestDetailEntity entity);
    //新增报考学生信息
    public int insertStuInfo(StuDetailInfEntity entity);
    //新增学生考试报考信息
    public int insertSubInfo(SubjectInformationEntity entity);
    //根据考生id查询考生报考信息列表
    public List<Map<String,Object>> selectExamDetailList(String stuId);
    //取消报考该门操作
    public int resetExamBySubjectId(String subId);
}
