package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.newworddrill.Service.NewWordService;
import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.command.ICommand;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.entity.NewWord;
import org.akachi.practice.newworddrill.entity.NewWordProxy;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;
import org.akachi.practice.newworddrill.util.StringUtil;

import java.util.*;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/1 19:54
 */

public class DrillCommand extends AbstractCommand implements ICommand {

    private NewWordService newWordService=(NewWordService) SpringApplicationContextHolder.getBean(NewWordService.class);

    private int successDrillCount;
    private int loseDrilCount;

    private int examCount;
    @Override
    public String introduce() {
        return "执行训练";
    }

    /**
     * 当前正在测试的内容
     */
    private List<NewWordProxy> wordList= new ArrayList<>();

    /**
     * 单词迭代器
     */
    private Iterator<NewWordProxy> wordIterator ;

    /**
     * 失败计数器
     */
    private Map<NewWordProxy,Integer> loseWord= new HashMap<>();

    /**
     *吧今天的训练单词加载好
     * -----功能没写完未来加入一个可以输入日期的模式已训练昨日或指定日期的单词
     */
    public void init(){
        wordList.clear();
        newWordService.findAll().forEach(word->{
            NewWordProxy newWordProxy= NewWordProxy.getInstance(word);
            if(newWordProxy.isDrillDay()){
                wordList.add(newWordProxy);
            }
        });
        shuffle();
    }


    /**
     *吧今天的训练单词加载好
     * -----功能没写完未来加入一个可以输入日期的模式已训练昨日或指定日期的单词
     */
    private void init(int day){
        wordList.clear();
        newWordService.findWordByTime(day).forEach(word->{
            NewWordProxy newWordProxy= NewWordProxy.getInstance(word);
            wordList.add(newWordProxy);
        });
        shuffle();
    }

    /**
     * 开始测试
     */
    private void next(){
        if(wordIterator.hasNext()) {
            NewWordProxy newWordProxy = wordIterator.next();
            test(newWordProxy);
        }else {
            output("全部训练完成现在重置列表");
            shuffle();
            if(wordList==null||wordList.size()==0){
                output("目前没有需要训练的单词");
                return;
            }
            wordIterator=wordList.iterator();
            NewWordProxy newWordProxy = wordIterator.next();
            test(newWordProxy);
        }
    }

    public void begin(){
        init();
        next();
    }

    public void beginByDay(String day){
        Integer dayInt = Integer.parseInt(day);
        init(dayInt);
        next();
    }

    /**
     * 直接查询单词中文来进行测试
     * @param chinese
     */
    public void test(String chinese){
        NewWord newWord= newWordService.findWordByChinese(chinese);
        if(newWord!=null){
            test(NewWordProxy.getInstance(newWord));
        }else{
            output("没有中文含义为'"+chinese+"'的单词");
        }
    }

    /**
     * 测试主方法
     * @param newWordProxy
     */
    private void test(NewWordProxy newWordProxy){
        List<Integer> seed = new ArrayList<>();
        test(newWordProxy,seed);
    }

    /**
     * 测试单词
     * @param newWordProxy
     */
    private void test(NewWordProxy newWordProxy,List<Integer> seed){
        /*测试输入与输出*/
        if(examCount%DrillConstant.HINT_RATING==0){
            output("如果要结束测试输入'"+DrillConstant.TEST_END+"'!");
        }
        output("请输入'"+newWordProxy.getChinese()+"'的单词");
        String wordTest=input();
        if(DrillConstant.TEST_END.equals(wordTest)||DrillConstant.END_TEST.equals(wordTest)){
            testReport();
            return;
        }
        this.examCount++;
        if (newWordProxy.getWord().equals(wordTest)){
            /*测试成功则单词测试次数+1并且清零失败次数*/
            output("正确!");
            newWordProxy.setDrillCount(+1);
            /*如果这输入正确时计数器中的失败次数超过或等于最小失败次数则测试失败*/
            if(newWordProxy.getLoseCount()>=DrillConfig.LOSE_MIN_COUNT){
                this.loseDrilCount++;
                if(loseWord.get(newWordProxy)!=null){
                    loseWord.put(newWordProxy,loseWord.get(newWordProxy)+1);
                }else{
                    loseWord.put(newWordProxy,1);
                }
            }else{
                this.successDrillCount++;
            }
            newWordProxy.setLoseCount(0);
            next();
        }else {
            /*如果测试失败记录失败次数并且递归重新测试*/
            output("错误请重新输入");
            newWordProxy.setLoseCount(newWordProxy.getLoseCount()+1);
            /*判断是否需要提示*/
            hint(newWordProxy,seed);
            /*测试*/
            test(newWordProxy,seed);
        }
    }

    /**
     * 提示系统
     * @param newWordProxy
     * @param seed
     */
    private void hint(NewWordProxy newWordProxy,List<Integer> seed){
        if (newWordProxy.getLoseCount()== DrillConfig.LOSE_MIN_COUNT){
            String word= StringUtil.regReplace(newWordProxy.getWord(),".", "*");
            output("提示‘"+word+"’");
        }else if(newWordProxy.getLoseCount()>DrillConfig.LOSE_MIN_COUNT){
            float scale = (newWordProxy.getLoseCount()-1f)/(DrillConfig.LOSE_MAX_COUNT-DrillConfig.LOSE_MIN_COUNT);
            String word = StringUtil.randomShow(newWordProxy.getWord(),scale,seed);
            output("提示‘"+word+"’");
        }
    }

    /**
     * 报告
     */
    private void testReport(){
        if(loseDrilCount+this.successDrillCount!=0){
            float accuracy = (this.successDrillCount+0)/(this.loseDrilCount+this.successDrillCount+0f);
            int i =0;
            output("#######################训练报告##########################");
            output("本次测试正确率为"+StringUtil.format2(accuracy*100)+"%");
            output("错误单词TOP10");
            for(Map.Entry<NewWordProxy, Integer> nwp: loseWord.entrySet()){
                i++;
                if (i>10){
                    break;
                }
                output("'"+nwp.getKey().getWord()+"'错误"+nwp.getValue()+"次。");
            }
            output("#######################################################");
            loseWord.clear();
            this.loseDrilCount=0;
            this.successDrillCount=0;
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
