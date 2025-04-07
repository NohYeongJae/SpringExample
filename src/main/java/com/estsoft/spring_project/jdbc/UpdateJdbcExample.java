package com.estsoft.spring_project.jdbc;

import java.sql.*;

public class UpdateJdbcExample {
    private static final String url = "jdbc:mysql://localhost:3306/test_db";
    private static final String user = "root";
    private static final String password = "0000";

    public static void main(String[] args) {

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement statement = conn.createStatement();
                ){
            String query = "UPDATE students SET name='노영재', address='인천광역시' WHERE id=1";
            int row = statement.executeUpdate(query);
            System.out.println("업데이트 수: " + row);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
