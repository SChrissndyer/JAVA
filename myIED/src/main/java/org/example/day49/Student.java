package org.example.day49;

import java.util.ArrayList;

public class Student extends Person{
    private int studentId;

    private ArrayList<String> classList;


    public Student(String name, String phoneNumber,int id, ArrayList<String> list) {
        super(name, phoneNumber);
        this.studentId=id;
        this.classList=list;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public ArrayList<String> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<String> classList) {
        this.classList = classList;
    }
}
