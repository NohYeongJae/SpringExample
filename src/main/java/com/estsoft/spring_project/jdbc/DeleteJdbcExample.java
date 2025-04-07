package com.estsoft.spring_project.jdbc;

import java.sql.*;

public class DeleteJdbcExample {
    private static final String url = "jdbc:mysql://localhost:3306/test_db";
    private static final String user = "root";
    private static final String password = "0000";

    public static void main(String[] args) {

        try(
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement statement = conn.createStatement();
                ){
            String sql = "DELETE FROM students WHERE age >= 25";
            int row = statement.executeUpdate(sql);
            System.out.println("Deleted: " + row + " rows");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
