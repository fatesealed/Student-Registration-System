package com.wzs.affairs.service;

import com.wzs.affairs.entity.AffairEntity;

public interface AffairLoginService {
    public AffairEntity affairLogin(String username, String password);
}
