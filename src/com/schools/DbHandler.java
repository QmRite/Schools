package com.schools;

import org.sqlite.JDBC;

import java.sql.*;

public class DbHandler {

    private Connection connection;
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    private DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection("jdbc:sqlite:Schools.db");
    }

    public void createTable(String name){
        String query = "CREATE TABLE " + name + "( " +
                "district VARCHAR(5) PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "country VARCHAR(20)," +
                "grades VARCHAR(5), " +
                "students INTEGER, " +
                "teachers INTEGER, " +
                "english FLOAT(10), " +
                "math FLOAT(10), " +
                "read FLOAT(10), " +
                "calworks FLOAT(10), " +
                "lunch FLOAT(10), " +
                "computer FLOAT(10), " +
                "expenditure FLOAT(10), " +
                "income FLOAT(10))";
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void selectCountriesWithAverageExpenditureHigherThan(int expen, String tableName){
        String query = "SELECT country, AVG(expenditure) as avg " +
                "FROM " + tableName + " " +
                "WHERE expenditure >= "+ expen + " " +
                "GROUP BY country";
        printCountries(query);
    }

    public void selectCountriesWithAverageExpenditureHigherThan(int expen, String[] countries, String tableName){
        var condition = createConditionString("country", countries);
        String query = "SELECT country, AVG(expenditure) as avg " +
                "FROM " + tableName + " " +
                "WHERE expenditure >= "+ expen + " AND (" + condition + ") " +
                "GROUP BY country";
        printCountries(query);
    }

    private void printCountries(String query){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String country = rs.getString("country");
                int avg = rs.getInt("avg");
                System.out.println(country + "\t| " + avg);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private String createConditionString(String column, String[] conditions){
        StringBuilder result = new StringBuilder();
        for (String condition: conditions){
            result.append(String.format("%s LIKE \"%s\" OR ", column, condition));
        }
        return result.substring(0, result.length() - 4);
    }

    public void selectSchoolWithHighestSubjectScore(String subject, String tableName){
        String query = "SELECT name, students, math " +
                "FROM " + tableName + " " +
                "ORDER BY " + subject + " DESC " +
                "LIMIT 1";
        printName(query);
    }

    public void selectSchoolWithHighestSubjectScore(String subject, int[] borders, String tableName){
        String condition = createBordersCondition("students", borders);
        String query = "SELECT name, students, math " +
                "FROM " + tableName + " " +
                condition +
                "ORDER BY " + subject + " DESC " +
                "LIMIT 1";
        printName(query);
    }

    private void printName(String query){
        try{
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private String createBordersCondition(String column, int[] borders){
        if (borders.length % 2 != 0)
            throw new IllegalArgumentException();
        StringBuilder result = new StringBuilder();
        result.append("WHERE ");
        for (int i = 0; i < borders.length; i+=2){
            result.append(String.format("%s BETWEEN %d AND %d OR ", column, borders[i], borders[i + 1]));
        }
        return result.substring(0, result.length() - 3);
    }

    public void deleteTable(String name){
        String query = "DROP TABLE "+ name;
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addSchool(School school, String tableName) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO " + tableName + "(`district`, `name`, `country`, `grades`," +
                        " `students`, `teachers`, `english`, `math`," +
                        " `read`, `calworks`, `lunch`, `computer`," +
                        " `expenditure`, `income`) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setObject(1, school.getDistrict());
            statement.setObject(2, school.getName());
            statement.setObject(3, school.getCountry());
            statement.setObject(4, school.getGrades());
            statement.setObject(5, school.getStaff().getStudents());
            statement.setObject(6, school.getStaff().getStudents());
            statement.setObject(7, school.getSubjects().getEnglish());
            statement.setObject(8, school.getSubjects().getMath());
            statement.setObject(9, school.getSubjects().getRead());
            statement.setObject(10, school.getSubjects().getCalworks());
            statement.setObject(11, school.getSubjects().getLunch());
            statement.setObject(12, school.getSubjects().getCalworks());
            statement.setObject(13, school.getFinances().getExpenditure());
            statement.setObject(14, school.getFinances().getIncome());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
