package com.wzs.st.dao;

import com.wzs.st.entity.TestDetailEntity;

import java.util.List;

public interface TestDetailDao {
    /***
     *
     * @return
     * 根据考试科目id查询考试省份城市地点
     */
    public List<TestDetailEntity> selectExamcourseAddr(String examId);

    /***
     *
     * @param entity
     * @return
     * 根据考试科目id，省份，城市，地点查询考试时间段
     */
    public List<TestDetailEntity> selectExamcourseTime(TestDetailEntity entity);
}
