package org.akachi.practice.newworddrill.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/2 19:43
 */
public class StringUtil {

    public static String regReplace(String content, String pattern, String newString){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        String result = m.replaceAll(newString);
        return result;
    }

    public static String randomShow(String content,float scale,List<Integer> seed){
        /*scale=scale*0.7f; 最大提示*/
        if(scale>1){
            scale=1f;
        }
        int length = content.length();
        float count = Math.round(length*scale);

        if(seed==null){
            seed = new ArrayList<Integer>();
        }
        /*这里不解决相同长度单词发生的替换问题，本质上来说此方法不应该解决意外更换单词导致的BUG*/
        if(seed.size()!=content.length()) {
            seed.clear();
            for(int i = 0;i<length;i++){
                seed.add(i);
            }
            Collections.shuffle(seed);
        }
        String retContent = regReplace(content,".","*");
        for (int i = 0;i<count;i++){
            int index = seed.get(i);
            String replaceStr = content.substring(index,index+1);
            // prefix  suffix
            String prefixStr = retContent.substring(0,index);
            String suffixStr = retContent.substring(index+1,length);
            retContent = prefixStr+replaceStr+suffixStr;
        }
        return retContent;
    }

    public static void main(String[] args) {
        List<Integer> seed=new ArrayList<>();
        String word = StringUtil.randomShow("a",0.1f,seed);
        System.out.println(word);
        word = StringUtil.randomShow("umbreall",0.2f,seed);
        System.out.println(word);
        word = StringUtil.randomShow("umbreall",0.4f,seed);
        System.out.println(word);
        word = StringUtil.randomShow("umbreall",0.5f,seed);
        System.out.println(word);
        word = StringUtil.randomShow("umbreall",0.8f,seed);
        System.out.println(word);
        word = StringUtil.randomShow("umbreall",1f,seed);
        System.out.println(word);
    }

    public static String format2(float value) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }
}
