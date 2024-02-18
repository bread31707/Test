package com.wuw.dealZipData;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args){

//        zipTobase64String();
        base64ToZipToData();

    }

    public static void base64ToZipToData(){
        String base64String = "UVEsUVEsUVENClExLFEyLFEz";
        try {
            // 解碼 base64 字串為 byte array
            byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64String);

            // 創建 ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(decodedBytes);

            // 使用 ZipInputStream 讀取資料
            ZipInputStream zis = new ZipInputStream(bais);

            // 遍歷壓縮檔內的檔案
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // 檔案名稱
                String fileName = entry.getName();

                // 創建 StringBuilder 來保存檔案內容
                StringBuilder fileContent = new StringBuilder();

                // 讀取檔案內容
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fileContent.append(new String(buffer, 0, len, "UTF-8"));
                }

                // 輸出檔案內容
                System.out.println("檔案名稱: " + fileName);
                System.out.println("檔案內容: ");
                System.out.println(fileContent.toString());
            }

            // 關閉 ZipInputStream
            zis.close();

            System.out.println("解壓縮完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void zipTobase64String(){
        try {
            // 讀取 zip 檔案
            FileInputStream fis = new FileInputStream("/Users/wuchengxuan/Desktop/detail.zip");
            ZipInputStream zis = new ZipInputStream(fis, StandardCharsets.UTF_8);

            // 遍歷 zip 檔案內的條目
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // 檢查是否為 CSV 檔案
                if (!entry.isDirectory() && entry.getName().toLowerCase().endsWith(".csv")) {
                    // 讀取 CSV 檔案內容為 byteArray
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        baos.write(buffer, 0, len);
                    }
                    byte[] csvByteArray = baos.toByteArray();

                    // 將 byteArray 轉換為 base64 字串
                    String base64String = Base64.getEncoder().encodeToString(csvByteArray);

                    // 輸出 base64 字串
                    System.out.println("Base64 字串:");
                    System.out.println(base64String);

                    // 可選：將 base64 字串寫入檔案
                    // FileWriter writer = new FileWriter("output_base64.txt");
                    // writer.write(base64String);
                    // writer.close();

                    break; // 只處理第一個找到的 CSV 檔案，如果有多個 CSV 檔案，請根據需求調整
                }
            }

            // 關閉 ZipInputStream
            zis.close();

            System.out.println("轉換完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
