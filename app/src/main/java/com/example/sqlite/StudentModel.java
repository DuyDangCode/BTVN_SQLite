package com.example.sqlite;

public class StudentModel {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public StudentModel(String id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    private String dob;


}
