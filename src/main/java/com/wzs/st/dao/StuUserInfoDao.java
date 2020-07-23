package com.wzs.st.dao;

import com.wzs.st.entity.StuUserInfoEntity;

import java.util.List;

/**
 * @Author Wang Zhishan
 * @Description //修改学生信息接口
 * @Date 12:07 2020/7/21
 * @Param
 * @return
 **/
public interface StuUserInfoDao {
    public int insertStuUserInfo(StuUserInfoEntity entity);
    public List<StuUserInfoEntity> selectStudentIdInfoList();
    public int deleteStudentIdInformation(String studentId);
    public int updateStudentIdInformation(StuUserInfoEntity entity);
    public StuUserInfoEntity selectStudentIdInfoById(String stuId);
    public List<StuUserInfoEntity> selectStuByUsernamePwd(StuUserInfoEntity entity);
    public List<StuUserInfoEntity> selectStuByUsername(String username);
}
