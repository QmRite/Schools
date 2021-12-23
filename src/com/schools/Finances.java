package com.schools;

public class Finances {
    private double expenditure;
    private double income;

    public Finances(double expenditure, double income) {
        this.expenditure = expenditure;
        this.income = income;
    }

    public double getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(double expenditure) {
        this.expenditure = expenditure;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
