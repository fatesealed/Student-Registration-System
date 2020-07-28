package com.wzs.st.entity;

public class SubjectInformationEntity {
    private String appID;
    private String stuID;
    private String examIdX;
    private String appDateTime;
    private String verState;
    private String verDateTime;
    private String verCase;

    public String getVerCase() {
        return verCase;
    }

    public void setVerCase(String verCase) {
        this.verCase = verCase;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getExamIdX() {
        return examIdX;
    }

    public void setExamIdX(String examIdX) {
        this.examIdX = examIdX;
    }

    public String getAppDateTime() {
        return appDateTime;
    }

    public void setAppDateTime(String appDateTime) {
        this.appDateTime = appDateTime;
    }

    public String getVerState() {
        return verState;
    }

    public void setVerState(String verState) {
        this.verState = verState;
    }

    public String getVerDateTime() {
        return verDateTime;
    }

    public void setVerDateTime(String verDateTime) {
        this.verDateTime = verDateTime;
    }
}
