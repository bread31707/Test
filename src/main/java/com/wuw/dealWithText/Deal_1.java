package com.wuw.dealWithText;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Deal_1 {
    public static void main(String[] args) {

        String line = "";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String dataPath = "";
        String targetPath = "";

        try {

            FileInputStream fileInputStream = new FileInputStream(dataPath);
            FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));

            line = bufferedReader.readLine();
            while(line != null){

//                // 直接處理 line
//                if(line.contains("?")){
//                    bufferedWriter.write(line+"\n");
//                }

//                // 處理可解析的 line
//                String[] cnt = line.split("\\|");
//                if(cnt[0].contains("?")){
//                    bufferedWriter.write(cnt[0]);
//                }

                line = bufferedReader.readLine();
            }

            bufferedWriter.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
