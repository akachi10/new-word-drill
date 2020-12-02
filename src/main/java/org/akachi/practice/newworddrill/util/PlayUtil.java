package org.akachi.practice.newworddrill.util;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.exception.AudioLengthException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Date;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/11/25 21:57
 */
public class PlayUtil extends Thread {
    private String word;

    /**
     * 使用浏览器发声
     *
     * @param word 单词
     */
    public static void sound(String word) {
        PlayUtil dosUtil = new PlayUtil();
        dosUtil.word = word;
        dosUtil.start();
    }

    /**
     * 播放
     */
    @Override
    public void run() {
        String url_word = word.replace(DrillConstant.SPACE, DrillConstant.URL_SPACE).toLowerCase();
        int type = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT).intValue() + 1;
        int type2 = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT_SECOND).intValue() + 1;
        String saveWord = word.replace('?', '_').replace('!', '_');
        String wordFileName = type + DrillConstant.UNDERLINE + saveWord + DrillConstant.AUDIO_SUFFIX;
        String url = DrillConfig.SOUND_PREFIX + type + DrillConfig.SOUND_SUFFIX + url_word;
        String url2 = DrillConfig.SOUND_PREFIX + type2 + DrillConfig.SOUND_SUFFIX + url_word;
        try {
            HttpUtil.downloadNet(url, DrillConfig.AUDIO_PATH, wordFileName);
            Integer playTime = getTime(word);
            if (DrillConfig.AUDIO_START_PLAY) {
                play(System.getProperty("user.dir") + DrillConstant.DIAGONAL + DrillConfig.AUDIO_START, DrillConfig.AUDIO_START_TIME, null, null, null);
            }
            play(DrillConfig.AUDIO_PATH + wordFileName, playTime, url2, DrillConfig.AUDIO_PATH, wordFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 音频播放
     *
     * @param path     文件位置
     * @param playTime 等待时间 已弃用
     * @param url      文件下载位置(BUG解决)
     * @param dir      存储路径(BUG解决)
     * @param fileName 文件名(BUG解决) 这里用原文件名
     */
    public void play(String path, Integer playTime, String url, String dir, String fileName) {

        FileInputStream fileInputStream = null;
        //创建一个缓冲流
        BufferedInputStream bufferedInputStream = null;
        try {
            File f = new File(path);
            fileInputStream = new FileInputStream(f);
            //创建一个缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            Player player = new Player(bufferedInputStream);
            long l1 = System.currentTimeMillis();
            player.play();
            long l2 = System.currentTimeMillis();
            Thread.sleep(playTime);
            player.close();
            long l3=l2-l1;
            if(l3<DrillConstant.AUDIO_LENGTH_TIME){
                throw new AudioLengthException(fileName+"播放时长度不足"+l3+"毫秒.");
            }
        } catch (InterruptedException | FileNotFoundException | JavaLayerException|AudioLengthException e) {
            e.printStackTrace();
            if (url != null && fileName != null && dir != null) {
                try {
                    File theFile = new File(path);
                    //如果文件存在不需要进行任何操作。
                    if (theFile.exists()) {
                        theFile.delete();
                    }
                    HttpUtil.downloadNet(url, dir, fileName);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        }finally {
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Integer getTime(String word) {
        int time = new Double((DrillConfig.INITIAL_SOUND_WAIT + word.length()) * DrillConfig.SOUND_WAIT).intValue();
        return time;
    }
}
