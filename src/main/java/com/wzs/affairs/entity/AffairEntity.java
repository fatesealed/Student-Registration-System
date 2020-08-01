package com.wzs.affairs.entity;

public class AffairEntity {
    private int teaId;
    private String teaName;
    private String teaSex;
    private String teaUserName;
    private String teaPassword;
    private String teaDateTime;
    private String isAuth;

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public String getTeaUserName() {
        return teaUserName;
    }

    public void setTeaUserName(String teaUserName) {
        this.teaUserName = teaUserName;
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword;
    }

    public String getTeaDateTime() {
        return teaDateTime;
    }

    public void setTeaDateTime(String teaDateTime) {
        this.teaDateTime = teaDateTime;
    }

    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }
}
