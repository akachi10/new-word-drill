package org.akachi.practice.newworddrill.exception;

import org.akachi.practice.newworddrill.command.AbstractCommand;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/12/2 16:39
 */
public class AudioLengthException extends RuntimeException {
    /**
     * 播放时长异常
     *
     * @param word              单词
     * @param playTime          实际播放时间
     * @param theoryMinPlayTime 理论播放时间
     */
    public AudioLengthException(String word, long playTime, Double theoryMinPlayTime, String abstractCommand) {
        super(word + "播放时长" + playTime + "毫秒，不足" + theoryMinPlayTime + "毫秒。音频文件可能损坏、系统会删除此音频不必理会。");
        output(abstractCommand, word + "播放时长" + playTime + "毫秒，不足" + theoryMinPlayTime + "毫秒。音频文件可能损坏、系统会删除此音频不必理会。\r\n");
    }

    /**
     * 导入1
     *
     * @param output1
     * @param output
     */
    public void output(String output1, String output) {
        System.out.println("[" + output1 + "]:" + output);
    }
}
