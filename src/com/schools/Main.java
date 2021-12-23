package com.schools;


import java.util.ArrayList;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<School> schools = new ArrayList<>();
        try {
            var parsedData = CSVParser.parse("Schools.csv", true);
            for (var school: parsedData){
                schools.add(new School(school));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            String tableName = "schools";
            DbHandler dbHandler = DbHandler.getInstance();
            dbHandler.deleteTable(tableName);
            dbHandler.createTable(tableName);
            for (var school: schools){
                dbHandler.addSchool(school, tableName);
            }
            //dbHandler.selectCountriesWithAverageExpenditureHigherThan(10, new String[]{"Glenn", "Fresno", "Contra Costa", "El Dorado"}, tableName);
            dbHandler.selectSchoolWithHighestSubjectScore("math", new int[]{5000, 7000, 10000, 11000}, tableName);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("sa");
    }
}
