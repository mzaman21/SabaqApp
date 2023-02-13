package com.example.sabaq;

public class StudentModel {
    private int Id;
    private String Name;

    public StudentModel(int id, String name) {
        Id = id;
        Name = name;
    }

    public StudentModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
