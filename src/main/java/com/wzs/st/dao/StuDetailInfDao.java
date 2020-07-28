package com.wzs.st.dao;

import com.wzs.st.entity.StuDetailInfEntity;

public interface StuDetailInfDao {
    public StuDetailInfEntity selectStuDetailInfById(String stuId);
    public int insertStuInf(StuDetailInfEntity entity);
}
