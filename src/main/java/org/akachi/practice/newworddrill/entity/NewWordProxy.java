package org.akachi.practice.newworddrill.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/1 15:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NewWordProxy extends NewWord{

    private NewWordProxy(){
    }

    /**
     * 失败计数器
     */
    private int loseCount;

    /**
     * 测试次数
     */
    private int drillCount;

    /**
     * 构造单词代理器
     * @param newWord 单词
     * @return 单词代理
     */
    public static NewWordProxy getInstance(NewWord newWord){
        NewWordProxy newWordProxy = new NewWordProxy();
        newWordProxy.setWord(newWord.getWord());
        newWordProxy.setPhoneticSymbol(newWord.getPhoneticSymbol());
        newWordProxy.setChinese(newWord.getChinese());
        newWordProxy.setMemoryTime(newWord.getMemoryTime());
        newWordProxy.setLastMemoryTime(newWord.getLastMemoryTime());
        newWordProxy.setLastLetheTime(newWord.getLastLetheTime());
        newWordProxy.setLetheCount(newWord.getLetheCount());
        newWordProxy.setSuccessCount(newWord.getSuccessCount());
        newWordProxy.setCreateTime(newWord.getCreateTime());
        newWordProxy.setFlag(newWord.getFlag());
        return newWordProxy;
    }

    /**
     * 单日是否是测验日
     * @return 是否是测验日
     */
    public boolean isRecordTestDay(){
        Date theDate = new Date(System.currentTimeMillis());
        /*今天尚未测试过或录入单词，并且今天是训练日，那么今天也是测试日。*/
        return isDrillDay()
                /*如果今天已经测试成功了那今天就不是测试日了*/
                && !DateUtils.isSameDay(theDate, lastMemoryTime)
                /*如果今天是记忆日那么今天也不是测试日*/
                && !DateUtils.isSameDay(theDate, lastLetheTime)
                /*如果今天已经测试失败了那今天就不是测试日了*/
                && !DateUtils.isSameDay(theDate, memoryTime);
        /*如果今天是练习日并且没有测试过啧今天是测试日*/
    }

    /**
     * 当日是否是练习日
     * @return 是否是练习日
     */
    public boolean isDrillDay(){
        int nextTestDay = getNextTestDay();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(memoryTime);
        /*增加到相应的天数*/
        calendar.add(Calendar.DATE,nextTestDay);
        Date theDate = new Date(System.currentTimeMillis());
        /*如果今天与甲醛后的日期是同一天那么今天是练习日*/
        /*是测练习日*/
        return
                /*如果加权后的时间与今天是同一天那么今天是训练日*/
                DateUtils.isSameDay(calendar.getTime(), theDate)
                /*如果已经超过加权后的时间那么今天是训练日*/
                || theDate.getTime() > calendar.getTime().getTime()
                /*如果在今天测试失败了那么今天也是练习日 */
                || DateUtils.isSameDay(theDate, lastLetheTime)
                /*如果今天录入的单词今天也是训练日*/
                || DateUtils.isSameDay(theDate, lastMemoryTime)
                /*如果在今天测成功那今天也是练习日*/
                || DateUtils.isSameDay(theDate, memoryTime);
    }

    /**
     * 获得下一次测试时间
     * @return 多少天之后
     */
    private int getNextTestDay(){
        int testCount = Math.max(successCount - letheCount, 1);
        return new Double(Math.pow(testCount, DrillConfig.MAGNITUDE)).intValue();
    }

//    /**
//     * 下一次相对测试时间
//     * @return 多少天之后
//     */
//    private Integer getNextRelativeTestDay() {
//        int testDay = new Double(Math.pow(getTestCount(), magnitude)).intValue();
//        int lastTestDay = new Double(Math.pow(getTestCount()-1,magnitude)).intValue();
//        return testDay -lastTestDay;
//    }
}
