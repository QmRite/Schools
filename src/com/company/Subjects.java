package com.company;

public class Subjects {
    private double english;
    private double read;
    private double math;
    private double calworks;
    private double lunch;
    private double computer;

    public Subjects(double english, double read, double math, double calworks, double lunch, double computer) {
        this.english = english;
        this.read = read;
        this.math = math;
        this.calworks = calworks;
        this.lunch = lunch;
        this.computer = computer;
    }

    public double getComputer() {
        return computer;
    }

    public void setComputer(double computer) {
        this.computer = computer;
    }

    public double getCalworks() {
        return calworks;
    }

    public void setCalworks(double calworks) {
        this.calworks = calworks;
    }

    public double getLunch() {
        return lunch;
    }

    public void setLunch(double lunch) {
        this.lunch = lunch;
    }

    public double getEnglish() {
        return english;
    }

    public double getRead() {
        return read;
    }

    public double getMath() {
        return math;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public void setRead(double read) {
        this.read = read;
    }

    public void setMath(double math) {
        this.math = math;
    }
}
