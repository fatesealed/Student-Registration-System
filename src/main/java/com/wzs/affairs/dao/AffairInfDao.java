package com.wzs.affairs.dao;

import com.wzs.affairs.entity.AffairEntity;

import java.util.List;

public interface AffairInfDao {
    public List<AffairEntity> selectAffByUsernamePwd(AffairEntity entity);
}
