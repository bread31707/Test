package com.wuw.processingOfData.dataBaseConnect;

import java.sql.*;

// 連接資料庫做單純 select all
public class DBSelectAll {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/apdata";
        String userName = "wuchengxuan";
        String password = "0000";

        try (Connection connection = DriverManager.getConnection(url, userName, password)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT * FROM testinfo");

            while (resultSet.next()) {
                String c1 = resultSet.getString("uuid");
                String c2 = resultSet.getString("starttime");
                String c3 = resultSet.getString("value");
                System.out.println(c1 + " " + c2 + " " + c3);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
