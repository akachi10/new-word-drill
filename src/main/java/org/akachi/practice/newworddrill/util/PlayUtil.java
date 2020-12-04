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

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/11/25 21:57
 */
public class PlayUtil extends Thread {
    private String word;
    private boolean isWait;

    /**
     * 使用浏览器发声
     *
     * @param word   单词
     * @param isWait 是否等待
     */
    public static void sound(String word, boolean isWait) {
        PlayUtil dosUtil = new PlayUtil();
        dosUtil.word = word;
        dosUtil.isWait = isWait;
        dosUtil.start();
    }

    /**
     * 播放
     */
    @Override
    public void run() {
        if(this.isWait){
            wait(this.word);
        }
        String url_word = word.replace(DrillConstant.SPACE, DrillConstant.URL_SPACE).toLowerCase();
        int type = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT).intValue() + 1;
        int type2 = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT_SECOND).intValue() + 1;
        String saveWord = word.replace('?', '_').replace('!', '_');
        String wordFileName = type + DrillConstant.UNDERLINE + saveWord + DrillConstant.AUDIO_SUFFIX;
        String url = DrillConfig.SOUND_PREFIX + type + DrillConfig.SOUND_SUFFIX + url_word;
        String url2 = DrillConfig.SOUND_PREFIX + type2 + DrillConfig.SOUND_SUFFIX + url_word;
        try {
            HttpUtil.downloadNet(url, DrillConfig.AUDIO_PATH, wordFileName);
            if (DrillConfig.AUDIO_START_PLAY) {
                new Thread(){
                    @Override
                    public void run(
                             ){
                        PlayUtil playUtils = new PlayUtil();
                        play(System.getProperty("user.dir") + DrillConstant.DIAGONAL + DrillConfig.AUDIO_START, null, null, null);
                    }
                }.start();
                }
            Thread.sleep(DrillConfig.AUDIO_START_TIME);
            play(DrillConfig.AUDIO_PATH + wordFileName, url2, DrillConfig.AUDIO_PATH, wordFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 音频播放
     *
     * @param path     文件位置
     * @param url      文件下载位置(BUG解决)
     * @param dir      存储路径(BUG解决)
     * @param fileName 文件名(BUG解决) 这里用原文件名
     */
    public void play(String path, String url, String dir, String fileName) {

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
            player.close();
            long l3 = l2 - l1;
            double LOT = word.length() * DrillConfig.SOUND_WAIT * 0.5;
            if (l3 < LOT&&l3<DrillConstant.AUDIO_LENGTH_MAX_TIME) {
                System.out.print(word + "播放时长" + l3 + "毫秒，不足" + LOT + "毫秒。音频文件可能损坏、系统会删除此音频不必理会。");
                throw new AudioLengthException(word + "播放时长度不足" + LOT + "毫秒。音频文件可能损坏、系统会删除此音频不必理会。");
            }
        } catch (FileNotFoundException | JavaLayerException | AudioLengthException e) {
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
        } finally {
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

    /**
     * 获得等待时长
     *
     * @param word 单词
     * @return
     */
    private static Integer getWaitTime(String word) {
        int time = new Double((DrillConfig.INITIAL_SOUND_WAIT + word.length()) * DrillConfig.SOUND_WAIT).intValue();
        return time;
    }

    public static void wait(String word) {
        int i = getWaitTime(word);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
