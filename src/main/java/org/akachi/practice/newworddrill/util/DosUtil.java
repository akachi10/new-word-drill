package org.akachi.practice.newworddrill.util;

import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/11/25 21:57
 */
public class DosUtil extends Thread {
    private String word;

    /**
     * 使用浏览器发声
     *
     * @param word 单词
     */
    public static void sound(String word) {
        DosUtil dosUtil = new DosUtil();
        dosUtil.word=word;
        dosUtil.start();
    }

    @Override
    public void run() {
        word=word.replace(DrillConstant.SPACE,"%20");
        String str = DrillConfig.SOUND;
        Double i = Math.random()*5;
        str = str.replace(DrillConstant.PLACEHOLDER,""+(i.intValue()+1));
        try {
            Runtime.getRuntime().exec(DrillConfig.BROWSER_PATH +DrillConstant.SPACE+ str + word);
            Thread.sleep(new Double((DrillConfig.INITIAL_SOUND_WAIT+word.length()/10d)*DrillConfig.SOUND_WAIT).intValue());
            Runtime.getRuntime().exec("taskkill /IM " + DrillConfig.BROWSER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
