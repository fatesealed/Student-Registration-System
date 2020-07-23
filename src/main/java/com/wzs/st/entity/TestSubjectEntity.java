package com.wzs.st.entity;

import java.io.Serializable;

/**
 * description: TestSubjectEntity <br>
 * date: 2020/7/22 15:10 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class TestSubjectEntity implements Serializable {
    private String examId;
    private String examName;
    private String examGrade;
    private String examDate;
    private String examTime;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(String examGrade) {
        this.examGrade = examGrade;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }
}
