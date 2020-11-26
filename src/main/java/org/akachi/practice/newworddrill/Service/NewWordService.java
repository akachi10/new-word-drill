package org.akachi.practice.newworddrill.Service;

import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.NewWord;
import org.akachi.practice.newworddrill.mapper.NewWordMapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


@Service("NewWordService")
public class NewWordService {

    @Autowired
    private NewWordMapper newWordMapper;

//    /**
//     * 更新Word
//     * @param newWord 单词
//     * @return 更新调数
//     */
//    public int update(NewWord newWord){
//        return newWordMapper.update(newWord);
//    }

    /**
     * 更新Word 包括主键
     *
     * @param newWord 单词
     * @param oldWord 旧组件
     * @return 更新调数
     */
    public int alter(NewWord newWord, String oldWord) {
        return newWordMapper.updateByWord(newWord, oldWord, DrillConfig.FLAG);
    }

    /**
     * 插入一个新单词
     *
     * @param word 单词
     */
    public void memoryWord(NewWord word) {
        //吧凌晨写入的单词算入今天
        newWordMapper.insert(word);
        word=newWordMapper.findWord(word.getWord(),word.getFlag());
        word.setCreateTime(subTime(word.getCreateTime()));
        word.setLastLetheTime(subTime(word.getLastLetheTime()));
        word.setLastMemoryTime(subTime(word.getLastMemoryTime()));
        word.setMemoryTime(subTime(word.getMemoryTime()));
        newWordMapper.update(word);
    }

    /**
     * 让凌晨写入的内容也算入今日
     * @param date
     * @return
     */
    private Date subTime(Date date) {
        if (date != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
//            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            if (calendar.get(Calendar.HOUR_OF_DAY) < 5) {
                calendar.add(Calendar.HOUR_OF_DAY, -24);
                date = calendar.getTime();
            }
        }
        return date;
    }

    /**
     * 查询单词
     *
     * @param word 单词
     * @return 单词对象
     */
    public NewWord findWord(String word) {
        return newWordMapper.findWord(word, DrillConfig.FLAG);
    }

    /**
     * 查询所有单词
     *
     * @return 所有单词
     */
    public List<NewWord> findAll() {
        return newWordMapper.findAll(DrillConfig.FLAG);
    }

    /**
     * 查询过去的天数
     *
     * @param formerlyDay 过去一天
     * @return
     */
    public List<NewWord> findWordByTime(int formerlyDay) {
        formerlyDay = formerlyDay * -1;
        Date date = new Date();
        LocalDate theDate = LocalDate.now();
        //如果是昨天就1、如果今天就是0，这里的 theDate和endDate风别表示今天0点和明天0点
        theDate = theDate.plusDays(formerlyDay);
        LocalDate endDate = theDate.plusDays(1);
        return newWordMapper.findAllByDay(theDate, endDate, DrillConfig.FLAG);
    }

    public List<String> flagList() {
        return this.newWordMapper.flagList();
    }

    /**
     * 查询过去的天数
     *
     * @param formerlyDay 过去一天
     * @return
     */
    public List<NewWord> findWrongWordByTime(int formerlyDay) {
        formerlyDay = formerlyDay * -1;
        Date date = new Date();
        LocalDate theDate = LocalDate.now();
        //如果是昨天就1、如果今天就是0，这里的 theDate和endDate风别表示今天0点和明天0点
        theDate = theDate.plusDays(formerlyDay);
        LocalDate endDate = theDate.plusDays(1);
        return newWordMapper.findWrongByDay(theDate, endDate, DrillConfig.FLAG);
    }

    /**
     * 查询过去的天数
     *
     * @param beginDay 过去一天
     * @param days 查询天数
     * @return
     */
    public List<NewWord> findWrongWordByTime(int beginDay,int days) {
        beginDay = beginDay * -1;
        Date date = new Date();
        LocalDate theDate = LocalDate.now();
        //如果是昨天就1、如果今天就是0，这里的 theDate和endDate风别表示今天0点和明天0点
        theDate = theDate.plusDays(beginDay);
        LocalDate endDate = theDate.plusDays(days*-1);
        //这里是向前查的所有end和begin是调换过来的。
        return newWordMapper.findWrongByDay(endDate, theDate, DrillConfig.FLAG);
    }

    /**
     * 删除单词
     *
     * @param word 单词
     * @return 删除几条 如果单词存在返回1
     */
    public int deleteWord(String word) {
        return newWordMapper.deleteWord(word, DrillConfig.FLAG);
    }

//    /**
//     * 测试单词
//     * @param newWord 单词
//     * @param isSuccess 是否测试成功
//     */
//    public void reMemory(NewWord newWord,boolean isSuccess){
//        if(NewWordProxy.getInstance(newWord).isRecordTestDay()) {
//            if (isSuccess) {
//                successMemory(newWord);
//            } else {
//                defeatedMemory(newWord);
//            }
//        }
//    }

    /**
     * 成功
     *
     * @param newWord 单词
     */
    public void successMemory(NewWord newWord) {
        newWord.setSuccessCount(newWord.getSuccessCount() + 1);
        newWord.setLastMemoryTime(new Date(System.currentTimeMillis()));
        newWordMapper.update(newWord);
    }

    /**
     * 失败
     *
     * @param newWord 单词
     */
    public void loseMemory(NewWord newWord) {
        Calendar calendar = new GregorianCalendar();
        //获得当前记忆时间
        calendar.setTime(newWord.getMemoryTime());
        //算出当前修正后的测试次数
        int differenceCount = newWord.getSuccessCount() - newWord.getLetheCount();
        //下面3行获得当前修正次数与上一个修正次数的相距天数
        int p1 = new Double(Math.pow(differenceCount, DrillConfig.MAGNITUDE)).intValue();
        int p2 = new Double(Math.pow(differenceCount - 1, DrillConfig.MAGNITUDE)).intValue();
        int p3 = p1 - p2;
        //当前记忆时间减去相距天数
        calendar.add(Calendar.DATE, p3);
        //修记忆时间
        newWord.setMemoryTime(calendar.getTime());
        //最后记忆时间
        newWord.setLastMemoryTime(new Date());
        //+1失败次数
        newWord.setLetheCount(newWord.getLetheCount() + 1);
        //更新最后失败时间
        newWord.setLastLetheTime(new Date(System.currentTimeMillis()));
        newWordMapper.update(newWord);
    }
}
