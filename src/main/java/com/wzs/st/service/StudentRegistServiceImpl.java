package com.wzs.st.service;

import com.wzs.comm.utils.DateUtils;
import com.wzs.st.dao.StuDetailInfDao;
import com.wzs.st.dao.StuDetailInfDaoImpl;
import com.wzs.st.dao.StuUserInfoDao;
import com.wzs.st.dao.StuUserInfoDaoImpl;
import com.wzs.st.entity.StuDetailInfEntity;
import com.wzs.st.entity.StuUserInfoEntity;

import java.util.List;


/**
 * description: StudentRegistServiceImpl <br>
 * date: 2020/7/20 11:35 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class StudentRegistServiceImpl implements StudentRegistService {
    @Override
    public int stuRegist(String username, String pwd) {
        StuUserInfoDao dao = new StuUserInfoDaoImpl();
        StuUserInfoEntity entity = new StuUserInfoEntity();
        entity.setStuUserName(username);
        entity.setStuPassword(pwd);
        entity.setRegDate(DateUtils.getCurrentTime());
        int i = dao.insertStuUserInfo(entity);
        return i;
    }

    @Override
    public StuUserInfoEntity stuLogin(String username, String password) {
        StuUserInfoDao dao = new StuUserInfoDaoImpl();
        StuUserInfoEntity entity = new StuUserInfoEntity();
        entity.setStuUserName(username);
        entity.setStuPassword(password);
        StuUserInfoEntity entity1 = null;
        //因为数据库查询不能接受两个参数，所以需要向里面传一个实体（大概是因为Mybatits
        List<StuUserInfoEntity> list = dao.selectStuByUsernamePwd(entity);
        if (list != null && list.size() > 0) {
            entity1 = list.get(0);
        }
        return entity1;
    }

    @Override
    public StuDetailInfEntity selectDetailInfById(String id) {
        StuDetailInfDao dao = new StuDetailInfDaoImpl();
        StuDetailInfEntity entity = dao.selectStuDetailInfById(id);
        return entity;
    }

    @Override
    public List<StuUserInfoEntity> selectStuByUsername(String username) {
        StuUserInfoDao dao = new StuUserInfoDaoImpl();
        List<StuUserInfoEntity> list = dao.selectStuByUsername(username);
        return list;
    }
}
