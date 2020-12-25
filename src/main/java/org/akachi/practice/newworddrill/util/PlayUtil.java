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
        if (this.isWait) {
            wait(this.word);
        }
        String url_word = StringUtil.replaceUrl(word);
        int type = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT).intValue() + 1;
        int type2 = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT_SECOND).intValue() + 1;
        String saveWord = StringUtil.replaceSaveFileName(word);
        String wordFileName = type + DrillConstant.UNDERLINE + saveWord + DrillConstant.AUDIO_SUFFIX;
        String url = DrillConfig.SOUND_PREFIX + type + DrillConfig.SOUND_SUFFIX + url_word;
        String url2 = DrillConfig.SOUND_PREFIX + type2 + DrillConfig.SOUND_SUFFIX + url_word;
        try {
            File file = HttpUtil.downloadNet(url, DrillConfig.AUDIO_PATH, wordFileName);
            if (DrillConfig.AUDIO_START_PLAY) {
                new Thread() {
                    @Override
                    public void run(
                    ) {
                        int i = play(
                                new File(
                                        System.getProperty("user.dir") +
                                                DrillConstant.DIAGONAL +
                                                DrillConfig.AUDIO_START));
                        if (i == -1) {
                            reDown(DrillConfig.AUDIO_PATH + wordFileName, url2, DrillConfig.AUDIO_PATH, wordFileName);
                        }
                    }
                }.start();
            }
            Thread.sleep(DrillConfig.AUDIO_START_TIME);
            int i = play(file);
            if (i == -1) {
                reDown(DrillConfig.AUDIO_PATH + wordFileName, url2, wordFileName, DrillConfig.AUDIO_PATH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解决bug从新下载
     *
     * @param path     路径
     * @param url      地址
     * @param fileName 名字
     * @param dir      地址
     */
    private void reDown(String path, String url, String fileName, String dir) {
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
    }

    /**
     * 音频播放
     *
     * @param file 文件名
     * @return 返回代码 -数是错误
     */
    public int play(File file) {

        FileInputStream fileInputStream = null;
        //创建一个缓冲流
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            //创建一个缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            Player player = new Player(bufferedInputStream);
            long playStartTime = System.currentTimeMillis();
            player.play();
            long playEndTime = System.currentTimeMillis();
            player.close();
            long playTime = playEndTime - playStartTime;
            double theoryMinPlayTime = word.length() * DrillConfig.SOUND_WAIT * 0.5;
            if (playTime < theoryMinPlayTime && playTime < DrillConstant.AUDIO_LENGTH_MAX_TIME) {
                throw new AudioLengthException(word, playTime, theoryMinPlayTime);
            }
        } catch (FileNotFoundException | JavaLayerException e) {
            return -2;
        } catch (AudioLengthException e) {
            return -1;
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
        return 0;
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
