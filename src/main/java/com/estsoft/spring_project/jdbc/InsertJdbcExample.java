package com.estsoft.spring_project.jdbc;

/*1. DB 연결
 * 2. SQL 실행 -> INSERT INTO 쿼리
 * 3. 결과 출력 -> insert 갯수
 * */

import java.sql.*;

public class InsertJdbcExample {

    private static final String url = "jdbc:mysql://localhost:3306/test_db";
    private static final String user = "root";
    private static final String password = "0000";

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
        ) {
            String query = "INSERT INTO students (name, age, address) VALUES"
                    + "('노영재', 27, '인천'), "
                    + "('노영제', 26, '인천'), "
                    + "('노영자', 25, '인천') ";

            int row = statement.executeUpdate(query);
                    System.out.println("행의 개수: " + row);

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
