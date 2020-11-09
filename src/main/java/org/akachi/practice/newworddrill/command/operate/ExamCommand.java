package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.newworddrill.Service.NewWordService;
import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.entity.NewWordProxy;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;
import org.akachi.practice.newworddrill.util.StringUtil;

import java.util.*;

/**
 * 测验类
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/2 22:53
 */
public class ExamCommand extends AbstractCommand {

    private NewWordService newWordService=(NewWordService) SpringApplicationContextHolder.getBean(NewWordService.class);

    @Override
    public String introduce() {
        return "执行测验="+DrillConfig.FLAG;
    }

    /**
     * 当前正在测验的内容
     */
    private List<NewWordProxy> wordList= new ArrayList<>();

    /**
     * 单词迭代器
     */
    private Iterator<NewWordProxy> wordIterator ;

    /**
     * 测验失败的单词
     */
    private List<NewWordProxy> loseWord= new ArrayList<>();

    /**
     * 测验成功的单词
     */
    private List<NewWordProxy> successWord = new ArrayList<>();
    /**
     * 测验次数用于判断打印的
     */
    private int examCount;

    /**
     * 初始化测验
     */
    public void init(){
        wordList.clear();
        newWordService.findAll().forEach(word->{
            NewWordProxy newWordProxy=NewWordProxy.getInstance(word);
            if(newWordProxy.isRecordTestDay()){
                wordList.add(newWordProxy);
            }
        });
        shuffle();
    }

    private void next(){
        if(wordIterator.hasNext()) {
            NewWordProxy newWordProxy = wordIterator.next();
            exam(newWordProxy);
        }else {
            output("全部测验完成现在重置列表");
            testReport();
        }
    }

    public void begin(){
        init();
        next();
    }

    /**
     * 测验
     * @param newWordProxy
     */
    private void exam(NewWordProxy newWordProxy){
        /*测验输入与输出*/
        if((this.examCount)%DrillConstant.HINT_RATING==0){
                output("如果要结束测试输入'"+DrillConstant.TEST_END+"'!");
            }
        output("请输入'"+newWordProxy.getChinese()+"'的单词");
        String wordTest=input();
        if(DrillConstant.END_TEST.equals(wordTest)||DrillConstant.TEST_END.equals(wordTest)){
            /*打印测试报告*/
            testReport();
            output("已终止测验并重置测验列表");
            return;
        }
        this.examCount++;
        if (newWordProxy.getWord().equals(wordTest)){
            /*测验成功则单词测验次数+1并且清零失败次数*/
            output("正确!");
            newWordProxy.setDrillCount(+1);
            /*如果这输入正确时计数器中的失败次数超过或等于最小失败次数则测验失败*/
            if (newWordProxy.getLoseCount() < DrillConfig.LOSE_MIN_COUNT) {
                /*一旦成功就保存*/
                successWord.add(newWordProxy);
                newWordService.successMemory(newWordProxy);
            }
            newWordProxy.setLoseCount(0);
            next();
        }else {
            /*如果测验失败记录失败次数并且递归重新测验*/
            output("错误请重新输入");
            newWordProxy.setLoseCount(newWordProxy.getLoseCount()+1);
            /*为了防止作弊一旦失败次数与设定次数相等时就保存*/
            if (newWordProxy.getLoseCount()== DrillConfig.LOSE_MIN_COUNT) {
                loseWord.add(newWordProxy);
                newWordService.loseMemory(newWordProxy);
            }
            /*判断是否需要提示*/
            hint(newWordProxy);
            /*继续测试*/
            exam(newWordProxy);
        }
    }

    /**
     * 提示
     * @param newWordProxy
     */
    private void hint(NewWordProxy newWordProxy){
        if (newWordProxy.getLoseCount()== DrillConfig.LOSE_MIN_COUNT){
            String word= StringUtil.regReplace(newWordProxy.getWord(),".", "*");
            output("提示‘"+word+"’");
        }else if(newWordProxy.getLoseCount()>DrillConfig.LOSE_MIN_COUNT){
            output("提示‘"+newWordProxy.getWord()+"’");
        }
    }


    /**
     * 打印测试报告
     */
    private void testReport(){
        if(loseWord.size()+successWord.size()!=0){
            float accuracy = (successWord.size())/(loseWord.size()+successWord.size()+0f);
            int i =0;
            output("#######################测验报告##########################");
            output("本次测验正确率为"+StringUtil.format2(accuracy*100)+"%");
            output("成功数"+successWord.size()+",失败数"+loseWord.size()+".");
            output("错误单词TOP10");
            StringBuffer sb = new StringBuffer();
            sb.append("测验失败单词[");
            loseWord.forEach(word->{
                sb.append("'"+word.getWord()+"'");
                sb.append(",");
            });
            String s = sb.toString();
            if(",".equals(s.indexOf(s.length()-1,s.length()))){
                s=s.substring(0,s.length()-1)+"]";
            }else{
                s=s+"]";
            }
            output(s);

            StringBuffer sb2 = new StringBuffer();
            sb2.append("测验通过单词[");
            successWord.forEach(word->{
                sb2.append("'"+word.getWord()+"'");
                sb2.append(",");
            });
            s = sb2.toString();
            s=s.substring(0,s.length()-1)+"]";
            output(s);
            output("#######################################################");
            loseWord.clear();
            successWord.clear();
            this.examCount=0;
        }
    }

    /**
     * 随机洗牌
     */
    private void shuffle(){
        if(wordList!=null) {
            Collections.shuffle(wordList);
            wordIterator=wordList.iterator();
        }
    }
}
