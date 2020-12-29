package org.akachi.practice.newworddrill.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/12/28 16:38
 */
public class FileUtil {

    public static String getFileString(File file) {
        String str = "";
        try {
            FileInputStream in = new FileInputStream(file);
            // size 为字串的长度 ，这里一次性读完
            int size = in.available();
            byte[] buffer = new byte[size];
            int read = in.read(buffer);
            in.close();
            str = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 获得array
     *
     * @param fileName
     * @return
     */
    public static List<String> getFileArray(String fileName) {
        List<String> array = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fileReader);
            String str = null;
            while ((str = bf.readLine()) != null) {
                array.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
