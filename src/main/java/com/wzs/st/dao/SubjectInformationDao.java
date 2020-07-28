package com.wzs.st.dao;

import com.wzs.st.entity.SubjectInformationEntity;

public interface SubjectInformationDao {
    public int insertSubjectInformation(SubjectInformationEntity entity);
    public int deleteSubjectInformation(String subId);
}
