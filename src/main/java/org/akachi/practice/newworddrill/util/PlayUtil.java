package org.akachi.practice.newworddrill.util;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

    @Override
    /**
     * 播放
     */
    public void run() {
        String url_word = word.replace(DrillConstant.SPACE, DrillConstant.URL_SPACE);
        int type = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT).intValue();
        String wordFileName = type + DrillConstant.UNDERLINE + word + DrillConstant.AUDIO_SUFFIX;
        try {
            String url = DrillConfig.SOUND_PREFIX + type + DrillConfig.SOUND_SUFFIX + url_word;
            HttpUtil.downloadNet(url, DrillConfig.AUDIO_PATH, wordFileName);
            Integer playTime = getTime(word);
            if (DrillConfig.AUDIO_START_PLAY) {
                play(System.getProperty("user.dir") + DrillConstant.DIAGONAL + DrillConfig.AUDIO_START, DrillConfig.AUDIO_START_TIME);
            }
            play(DrillConfig.AUDIO_PATH + wordFileName, playTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 播放声音
     *
     * @param path 单词
     */
    public void play(String path, Integer playTime) {
        try {
            File f = new File(path);
            FileInputStream fileInputStream = new FileInputStream(f);
            //创建一个缓冲流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            Player player = new Player(bufferedInputStream);

            player.play();
            Thread.sleep(playTime);
            player.close();
            try {
                this.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        } catch (InterruptedException | FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public Integer getTime(String word) {
        int time = new Double((DrillConfig.INITIAL_SOUND_WAIT + word.length()) * DrillConfig.SOUND_WAIT).intValue();
        return time;
    }
}
