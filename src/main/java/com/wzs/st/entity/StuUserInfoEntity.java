package com.wzs.st.entity;

import java.sql.Date;

/**
 * @author dell
 * @date 2020/7/18 11:51 StuUserInfoEntity
 */

public class StuUserInfoEntity {
    private String stuId;
    private String stuUserName;
    private String stuPassword;
    private String regDate;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuUserName() {
        return stuUserName;
    }

    public void setStuUserName(String stuUserName) {
        this.stuUserName = stuUserName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
