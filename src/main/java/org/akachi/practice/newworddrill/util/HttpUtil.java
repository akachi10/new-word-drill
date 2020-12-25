package org.akachi.practice.newworddrill.util;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/12/2 9:37
 */
public class HttpUtil {

    /**
     * 下载文件
     *
     * @param url      下载地址
     * @param path     文件路径
     * @param fileName 存储文件名
     * @throws MalformedURLException URL异常
     */
    public static File downloadNet(String url, String path, String fileName) throws MalformedURLException {
        File pathDir = new File(path);
        if (!pathDir.exists()) {
            pathDir.mkdirs();
        }
        File theFile = new File(path + "/" + fileName);
        //如果文件存在不需要进行任何操作。
        if (theFile.exists()) {
            return theFile;
        }
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL uri = new URL(url);

        try {
            URLConnection conn = uri.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(path + "/" + fileName);

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            try {
                fs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                inStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            theFile = new File(path + "/" + fileName);
            //如果文件存在不需要进行任何操作。
            if (theFile.exists()) {
                return theFile;
            } else {
                return null;
            }
        }
    }
}
