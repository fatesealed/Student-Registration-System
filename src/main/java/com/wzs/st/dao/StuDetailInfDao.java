package com.wzs.st.dao;

import com.wzs.st.entity.StuDetailInfEntity;

import java.util.List;
import java.util.Map;

public interface StuDetailInfDao {
    public StuDetailInfEntity selectStuDetailInfById(String stuId);
    public int insertStuInf(StuDetailInfEntity entity);
    //根绝考生id查询考生报考信息列表
    public List<Map<String,Object>>  selectExamDetailList(String stuId);
}
