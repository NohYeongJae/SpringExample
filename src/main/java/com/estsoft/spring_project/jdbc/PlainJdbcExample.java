package com.estsoft.spring_project.jdbc;

        /*1. Conn
        2. SQL 실행
        3. 결과 출력*/

import java.sql.*;


public class PlainJdbcExample {

    private static final String url = "jdbc:mysql://localhost:3306/test_db";
    private static final String username = "root";
    private static final String password = "0000";

    public static void main(String[] args) {

        try(
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students"); ) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getString("address"));
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

    }
}
