package com.wzs.affairs.service;

import com.wzs.affairs.dao.AffairInfDao;
import com.wzs.affairs.dao.AffairInfDaoImpl;
import com.wzs.affairs.entity.AffairEntity;

import java.util.List;

public class AffairLoginServiceImpl implements AffairLoginService {
    @Override
    public AffairEntity affairLogin(String username, String password) {
        AffairInfDao dao = new AffairInfDaoImpl();
        AffairEntity entity = new AffairEntity();
        entity.setTeaUserName(username);
        entity.setTeaPassword(password);
        AffairEntity entity1 = null;
        //因为数据库查询不能接受两个参数，所以需要向里面传一个实体（大概是因为Mybatits
        List<AffairEntity> list = dao.selectAffByUsernamePwd(entity);
        if (list != null && list.size() > 0) {
            entity1 = list.get(0);
        }
        return entity1;
    }
}
