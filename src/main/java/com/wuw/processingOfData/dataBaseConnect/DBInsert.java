package com.wuw.processingOfData.dataBaseConnect;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 連接資料庫並將讀取檔案寫入資料庫
public class DBInsert {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/test";
        String userName = "wuchengxuan";
        String password = "0000";

        BufferedReader bufferedReader = null;
        String[] cnt = null;
        String line = "";
        List<String> c1 = new ArrayList<>();
        List<String> c2 = new ArrayList<>();
        List<String> c3 = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/wuchengxuan/Desktop/file/fakeData.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
            line = bufferedReader.readLine();
            while (line != null) {
                cnt = line.split(",");
                c1.add(cnt[0]);
                c2.add(cnt[1]);
                c3.add(cnt[2]);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(c1.size());
        System.out.println(c2.size());
        System.out.println(c3.size());

        try (Connection connection = DriverManager.getConnection(url, userName, password)) {

            String insertQuery = "INSERT INTO test(c1 ,c2 ,c3) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            for (int i = 0; i < 20; i++) {
                preparedStatement.setString(1, c1.get(i));
                preparedStatement.setString(2, c2.get(i));
                preparedStatement.setString(3, c3.get(i));
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
