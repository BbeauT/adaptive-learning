package com.example.btarekegn.schoolapp.entity;

public class Quiz {

    private long id;
    private String courseCode;
    private String quizName;
    private String quizResourceUrl;
    private String date;

    public Quiz(long id, String quizName, String quizResourceUrl, String courseCode, String data) {
        this.id = id;
        this.quizName = quizName;
        this.quizResourceUrl = quizResourceUrl;
        this.courseCode = courseCode;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizResourceUrl() {
        return quizResourceUrl;
    }

    public void setQuizResourceUrl(String quizResourceUrl) {
        this.quizResourceUrl = quizResourceUrl;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
