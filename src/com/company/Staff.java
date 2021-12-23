package com.company;

public class Staff {
    private int students;
    private double teachers;

    public Staff(int students, double teachers) {
        this.students = students;
        this.teachers = teachers;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public double getTeachers() {
        return teachers;
    }

    public void setTeachers(double teachers) {
        this.teachers = teachers;
    }
}
