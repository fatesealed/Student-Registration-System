package com.wzs.st.service;

import com.wzs.st.entity.StuDetailInfEntity;
import com.wzs.st.entity.StuUserInfoEntity;

import java.util.List;

public interface StudentRegistService {
    public int stuRegist(String username,String pwd);
    //登陆验证
    public StuUserInfoEntity stuLogin(String username, String password);
    //根据考生id选择学生信息
    public StuDetailInfEntity selectDetailInfById(String id);
    //根据用户名查询学生列表
    public List<StuUserInfoEntity> selectStuByUsername(String username);
}
