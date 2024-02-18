package com.wuw.fakeData;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class dataDenerater {
    public static void main(String[] args) {

        String c1 = "00000";
        String c2 = "000000";
        String c3 = "0000000";


        BufferedWriter bufferedWriter = null;
        String url = "/Users/wuchengxuan/Desktop/file/fakeData.txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));

            for (int i = 0; i < 20; i++) {
                bufferedWriter.write(c1);
                bufferedWriter.write(",");
                bufferedWriter.write(c2);
                bufferedWriter.write(",");
                bufferedWriter.write(c3);
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
