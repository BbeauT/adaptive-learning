package com.example.btarekegn.schoolapp.entity;

public class Course {

    private long id;
    private String code;
    private String title;
    private String resourceUrl;
    private String instructor;

    public Course(long id, String code, String title, String resourceUrl, String instructor) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.instructor = instructor;
        this.resourceUrl = resourceUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
