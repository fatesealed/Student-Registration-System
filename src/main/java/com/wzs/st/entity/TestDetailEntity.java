package com.wzs.st.entity;

import java.io.Serializable;

/**
 * description: TestDetailEntity <br>
 * date: 2020/7/23 11:39 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class TestDetailEntity implements Serializable {
    private String examIdX;
    private String examId;
    private String province;
    private String city;
    private String examAdd;
    private String examSDateTime;
    private String examEDateTime;

    public String getExamIdX() {
        return examIdX;
    }

    public void setExamIdX(String examIdX) {
        this.examIdX = examIdX;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExamAdd() {
        return examAdd;
    }

    public void setExamAdd(String examAdd) {
        this.examAdd = examAdd;
    }

    public String getExamSDateTime() {
        return examSDateTime;
    }

    public void setExamSDateTime(String examSDateTime) {
        this.examSDateTime = examSDateTime;
    }

    public String getExamEDateTime() {
        return examEDateTime;
    }

    public void setExamEDateTime(String examEDateTime) {
        this.examEDateTime = examEDateTime;
    }
}
