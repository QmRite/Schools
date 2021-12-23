package com.schools;

public class School {
    private final String district;
    private final String name;
    private final String country;
    private String grades;
    private Staff staff;
    private Finances finances;
    private Subjects subjects;

    public School(String district, String name, String country, String grades,
                  Staff staff, Finances finances, Subjects subjects) {
        this.district = district;
        this.name = name;
        this.country = country;
        this.grades = grades;
        this.staff = staff;
        this.finances = finances;
        this.subjects = subjects;
    }

    public School(String[] str){
        this(str[1], str[2],  str[3], str[4],
                new Staff(Integer.parseInt(str[5]), Double.parseDouble(str[6])),
                new Finances(Double.parseDouble(str[10]), Double.parseDouble(str[11])),
                new Subjects(Double.parseDouble(str[12]), Double.parseDouble(str[13]),
                        Double.parseDouble(str[14]), Double.parseDouble(str[7]), Double.parseDouble(str[8]), Double.parseDouble(str[9])));
    }

    public String getDistrict() {
        return district;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Finances getFinances() {
        return finances;
    }

    public void setFinances(Finances finances) {
        this.finances = finances;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
}
