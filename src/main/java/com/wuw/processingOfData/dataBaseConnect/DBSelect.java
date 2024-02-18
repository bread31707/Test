package com.wuw.processingOfData.dataBaseConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 連接資料庫，並依 target select
public class DBSelect {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String userName = "wuchengxuan";
        String password = "0000";

        List<String> c1List = new ArrayList<>();
        List<String> c2List = new ArrayList<>();
        List<String> c3List = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        String target = "00001";

        try (Connection connection = DriverManager.getConnection(url, userName, password)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT * FROM test");

            while (resultSet.next()) {
                String c1 = resultSet.getString("c1");
                String c2 = resultSet.getString("c2");
                String c3 = resultSet.getString("c3");
                c1List.add(c1);
                c2List.add(c2);
                c3List.add(c3);
            }

            for(int i =0; i < c1List.size(); i++){
                if(target.equals(c1List.get(i))){
                    answer.add(c1List.get(i)+","+c2List.get(i)+","+c3List.get(i));
                }
            }

            answer.forEach(node->{
                System.out.println(node);
            });

            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
