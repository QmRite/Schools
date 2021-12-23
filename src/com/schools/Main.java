package com.schools;


import org.jfree.data.category.CategoryDataset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static ArrayList<School> schools = new ArrayList<>();

    public static void main(String[] args) {
        parseCSV();

        try {
            String tableName = "schools";
            DbHandler dbHandler = DbHandler.getInstance();
            dbHandler.createTable(tableName);
            for (var school: schools){
                dbHandler.addSchool(school, tableName);
            }

            HashMap<String, Float> CountriesAndAvgStudents = dbHandler.getCountriesAndAverageStudentsCount(10);
            ChartHandler.createChart(ChartHandler.createDatasetFromHashMap(CountriesAndAvgStudents));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parseCSV(){
        try {
            var parsedData = CSVParser.parse("Schools.csv", true);
            for (var school: parsedData){
                schools.add(new School(school));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
