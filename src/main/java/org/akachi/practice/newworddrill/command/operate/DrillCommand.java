package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.newworddrill.Service.NewWordService;
import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.command.ICommand;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.entity.NewWord;
import org.akachi.practice.newworddrill.entity.NewWordProxy;
import org.akachi.practice.newworddrill.util.DosUtil;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;
import org.akachi.practice.newworddrill.util.StringUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/1 19:54
 */

public class DrillCommand extends AbstractCommand implements ICommand {

    private NewWordService newWordService = (NewWordService) SpringApplicationContextHolder.getBean(NewWordService.class);

    private int successDrillCount;
    private int loseDrillCount;

    private int examCount;

    @Override
    public String introduce() {
        return "执行训练=" + DrillConfig.FLAG;
    }

    /**
     * 当前正在测试的内容
     */
    private List<NewWordProxy> wordList = new ArrayList<>();

    /**
     * 单词迭代器
     */
    private Iterator<NewWordProxy> wordIterator;

    /**
     * 失败计数器
     */
    private Map<NewWordProxy, Integer> loseWord = new HashMap<>();

    /**
     * 吧今天的训练单词加载好
     * -----功能没写完未来加入一个可以输入日期的模式已训练昨日或指定日期的单词
     */
    private void init() {
        wordList.clear();
        newWordService.findAll().forEach(word -> {
            NewWordProxy newWordProxy = NewWordProxy.getInstance(word);
            if (newWordProxy.isDrillDay()) {
                wordList.add(newWordProxy);
            }
        });
        shuffle();
    }

    /**
     * 吧今天的训练单词加载好
     * -----功能没写完未来加入一个可以输入日期的模式已训练昨日或指定日期的单词
     */
    private void init(int day) {
        wordList.clear();
        newWordService.findWordByTime(day).forEach(word -> {
            NewWordProxy newWordProxy = NewWordProxy.getInstance(word);
            wordList.add(newWordProxy);
        });
        shuffle();
    }

    /**
     * 训练过去错误的单词
     *
     * @param day 过去天数
     */
    private void wrongInit(int day) {
        wordList.clear();
        newWordService.findWrongWordByTime(day).forEach(word -> {
            NewWordProxy newWordProxy = NewWordProxy.getInstance(word);
            wordList.add(newWordProxy);
        });
        shuffle();
    }

    /**
     * 训练过去错误的单词
     *
     * @param beginDay 过去天数
     * @param days     天数
     */
    private void wrongInit(int beginDay, int days) {
        wordList.clear();
        newWordService.findWrongWordByTime(beginDay, days).forEach(word -> {
            NewWordProxy newWordProxy = NewWordProxy.getInstance(word);
            wordList.add(newWordProxy);
        });
        shuffle();
    }

    /**
     * 获取本flag下的所有
     */
    private void allInit() {
        wordList.clear();
        newWordService.findAll().forEach(word -> {
            NewWordProxy newWordProxy = NewWordProxy.getInstance(word);
            wordList.add(newWordProxy);
        });
        shuffle();
    }


    /**
     * 练习
     */
    public void drill() {
        init();
        next();
    }

    /**
     * 训练某一天
     *
     * @param day
     */
    public void drill(String day) {
        Integer dayInt = 0;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
        }
        init(dayInt);
        next();
    }

    /**
     * 训练所有
     */
    public void drillall() {
        allInit();
        next();
    }

    /**
     * 逆练训练所有
     */
    public void redrillall() {
        allInit();
        renext();
    }

    /**
     * 训练错误单词
     *
     * @param day 录入日期
     */
    public void wrong(String day) {
        Integer dayInt = 0;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
        }
        wrongInit(dayInt);
        next();
    }

    /**
     * 训练错误单词
     *
     * @param day  录入日期
     * @param days 天数
     */
    public void wrong(String day, String days) {
        Integer dayInt = 0;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
        }
        Integer daysInt = 0;
        try {
            daysInt = Integer.parseInt(days);
        } catch (Exception e) {
        }
        wrongInit(dayInt,daysInt);
        next();
    }

    /**
     * 逆向训练
     *
     * @param day 录入日期
     */
    public void rewrong(String day) {
        Integer dayInt = 0;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
        }
        wrongInit(dayInt);
        renext();
    }

    /**
     * 逆练
     */
    public void redrill() {
        init();
        renext();
    }

    /**
     * 逆练某一天
     *
     * @param day
     */
    public void redrill(String day) {
        Integer dayInt = 0;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
        }
        init(dayInt);
        renext();
    }

    /**
     * 带声训练、接口录入翻译、
     * @param day
     */
    public void audio(String day){
        while (true){
            getNext();
            progress();
        }
    }

    /**
     * 获得下一个单词
     * @return
     */
    private NewWordProxy getNext(){
        if (wordIterator.hasNext()) {
            NewWordProxy newWordProxy = wordIterator.next();
            return newWordProxy;
        } else {
            output("全部训练完成现在重置列表");
            testReport();
            if (wordList == null || wordList.size() == 0) {
                output("目前没有需要训练的单词");
            }
            shuffle();
            wordIterator = wordList.iterator();
            return wordIterator.next();
        }
    }


    /**
     * 爬行训练所有单词
     */
    public void crawl() {
        init();
        crawltest(-1);
    }

    /**
     * 爬行训练某一天
     */
    public void crawl(String day) {
        Integer dayInt = 0;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
        }
        init(dayInt);
        crawltest(dayInt);
    }

    /**
     * 开始测试
     */
    private void next() {
        NewWordProxy newWordProxy=getNext();
        if(newWordProxy==null){
            return ;
        }
        test(newWordProxy);
    }

    /**
     * 爬行训练方法
     */
    private void crawltest(int day) {
        //获取最初训练的n个单词
        List<NewWordProxy> newWordProxyList = getNewWordProxys(DrillConfig.DRILL_CRAWL_LENGTH);
        if (newWordProxyList == null || newWordProxyList.size() == 0) {
            output("当前没有训练单词!");
            return;
        }
        //先获得一个单词
        NewWordProxy newWordProxy = null;
        if (newWordProxyList.size() > 0) {
            Collections.shuffle(newWordProxyList);
            newWordProxy = newWordProxyList.get(0);
        }
        while (true) {
            if (newWordProxy != null) {
                //测试单词
                LocalDateTime ldb = LocalDateTime.now();
                int testFruit = crawlWord(newWordProxy);
                LocalDateTime lde = LocalDateTime.now();
                Duration duration = Duration.between(ldb, lde);
                int cost = new Long(duration.getSeconds()).intValue();
                if (testFruit == 0) {
                    //小于最大重复训练次数
                    if (cost < DrillConfig.DRILL_CRAWL_TIME && newWordProxy.getDrillCount() == DrillConfig.DRILL_CRAWL_REPEAT) {
                        //如果对了就继续
                        //否则remove这个单词
                        output("'" + newWordProxy.getWord() + "'训练成功训练了" + (newWordProxy.getLoseCount() + DrillConfig.DRILL_CRAWL_REPEAT) + "次.");
                        output("失败了" + newWordProxy.getLoseCount() + "次.训练通过.");
                        newWordProxyList.remove(newWordProxy);
                        List<NewWordProxy> addList = getNewWordProxys(1);
                        newWordProxyList.addAll(addList);
                    } else if (cost >= DrillConfig.DRILL_CRAWL_TIME) {
                        output("耗时" + cost + "秒 ，训练超时。");
                    }

                    if (newWordProxyList.size() > 0) {
                        Collections.shuffle(newWordProxyList);
                        newWordProxy = newWordProxyList.get(0);
                    }
                } else if (testFruit == -1) {
                    //错误重复测试
                } else if (testFruit == -2) {
                    crawlReport();
                    output("爬虫训练结束");
                    break;
                } else if (testFruit == -3) {
                    output("跳过这个单词");
                    newWordProxyList.remove(newWordProxy);
                    List<NewWordProxy> addList = getNewWordProxys(1);
                    newWordProxyList.addAll(addList);
                }
            } else {
                output("全部训练完成现在重置列表");
                crawlReport();
                if (day == -1) {
                    init();
                } else {
                    init(day);
                }
                newWordProxyList = getNewWordProxys(DrillConfig.DRILL_CRAWL_LENGTH);
            }
        }
    }

    /**
     * 测试一个单词
     *
     * @param newWordProxy 新单词
     * @return -2 爬虫训练结束 -3 跳过单词 0正常训练
     */
    private int crawlWord(NewWordProxy newWordProxy) {
        output("请输入'" + newWordProxy.getChinese() + "'的单词");
        String wordTest = input();
        if (wordTest == null) {
            wordTest = "";
        }
        if (DrillConstant.TEST_END.equals(wordTest)) {
            output("训练结束!");
            return -2;
        } else if (DrillConstant.TEST_CONTINUE.equals(wordTest)) {
            return -3;
        }
        this.examCount++;
        if (newWordProxy.getWord().equals(wordTest)) {
            /*测试成功则单词测试次数+1并且清零失败次数*/
            successDrillCount++;
            output("正确!");
            DosUtil.sound(newWordProxy.getWord());
            newWordProxy.setDrillCount(newWordProxy.getDrillCount() + 1);
        } else {
            loseDrillCount++;
            output("错误!正确的单词是'" + newWordProxy.getWord() + "'。");
            if (newWordProxy.getDrillCount() > 0) {
                newWordProxy.setDrillCount(newWordProxy.getDrillCount() - 2);
            }
            newWordProxy.setLoseCount(newWordProxy.getLoseCount() + 1);
            return -1;
        }
        return 0;
    }

    /**
     * 获取单词
     *
     * @param count
     */
    private List<NewWordProxy> getNewWordProxys(int count) {
        List<NewWordProxy> newWordProxyList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (wordIterator.hasNext()) {
                NewWordProxy newWordProxy = wordIterator.next();
                newWordProxyList.add(newWordProxy);
            } else {
                break;
            }
        }
        return newWordProxyList;
    }

    /**
     * 测试主方法
     *
     * @param newWordProxy
     */
    private void test(NewWordProxy newWordProxy) {
        List<Integer> seed = new ArrayList<>();
        test(newWordProxy, seed);
    }

    private void progress() {
        /*测试输入与输出*/
        if (examCount % DrillConstant.HINT_RATING == 0) {
            output("本次测试一共有" + wordList.size() + "个单词,已经完成" + (successDrillCount + loseDrillCount) + "个测试。如果要结束测试输入'" + DrillConstant.TEST_END + "'!");
        }
    }

    /**
     * 测试单词
     *
     * @param newWordProxy
     */
    private void test(NewWordProxy newWordProxy, List<Integer> seed) {
        progress();
        output("请输入'" + newWordProxy.getChinese() + "'的单词");
        String wordTest = input();
        if (DrillConstant.TEST_END.equals(wordTest)) {
            testReport();
            return;
        }
        this.examCount++;
        if (newWordProxy.getWord().equals(wordTest)) {
            /*测试成功则单词测试次数+1并且清零失败次数*/
            output("正确!");
            newWordProxy.setDrillCount(newWordProxy.getDrillCount() + 1);
            DosUtil.sound(newWordProxy.getWord());
            /*如果这输入正确时计数器中的失败次数超过或等于最小失败次数则测试失败*/
            if (newWordProxy.getLoseCount() >= DrillConfig.LOSE_MIN_COUNT) {
                this.loseDrillCount++;
                if (loseWord.get(newWordProxy) != null) {
                    loseWord.put(newWordProxy, loseWord.get(newWordProxy) + 1);
                } else {
                    loseWord.put(newWordProxy, 1);
                }
            } else {
                this.successDrillCount++;
            }
            newWordProxy.setLoseCount(0);
            next();
        } else {
            /*如果测试失败记录失败次数并且递归重新测试*/
            output("错误请重新输入");
            newWordProxy.setLoseCount(newWordProxy.getLoseCount() + 1);
            /*判断是否需要提示*/
            hint(newWordProxy, seed);
            /*测试*/
            test(newWordProxy, seed);
        }
    }

    /**
     * 开始测试逆练
     */
    private void renext() {
        NewWordProxy newWordProxy=getNext();
        if(newWordProxy==null){
            return;
        }
        retest(newWordProxy);
    }

    /**
     * 逆测试单词
     *
     * @param newWordProxy 新的单词代理 要测试的单词
     */
    private void retest(NewWordProxy newWordProxy) {
        /*测试输入与输出*/
        progress();
        output("请输入'" + newWordProxy.getWord() + "'的翻译");
        String wordTest = input();
        if (DrillConstant.TEST_END.equals(wordTest)) {
            testReport();
            return;
        }
        //在这里打印正确答案
        output("正确翻译是'" + newWordProxy.getChinese() + "'，您们的翻译是" + wordTest + "");
        String flag = null;
        if (!newWordProxy.getChinese().equals(wordTest)) {
            DosUtil.sound(newWordProxy.getWord());
            flag = input("如果输入正确请直接回车");
        }
        this.examCount++;
        if (null == flag || "".equals(flag)) {
            /*测试成功则单词测试次数+1并且清零失败次数*/
            newWordProxy.setDrillCount(newWordProxy.getDrillCount() + 1);
            /*如果这输入正确时计数器中的失败次数超过或等于最小失败次数则测试失败*/
            this.successDrillCount++;
            output("正确翻译!");
            renext();
        } else {
            output("错误翻译!");
            /*如果测试失败记录失败次数并且递归重新测试*/
            this.loseDrillCount++;
            if (loseWord.get(newWordProxy) != null) {
                loseWord.put(newWordProxy, loseWord.get(newWordProxy) + 1);
            } else {
                loseWord.put(newWordProxy, 1);
            }
            renext();
            /*判断是否需要提示*/
            /*测试*/
        }
    }

    /**
     * 提示系统
     *
     * @param newWordProxy
     * @param seed
     */
    private void hint(NewWordProxy newWordProxy, List<Integer> seed) {
        if (newWordProxy.getLoseCount() == DrillConfig.LOSE_MIN_COUNT) {
            String word = StringUtil.regReplace(newWordProxy.getWord(), ".", "*");
            output("提示‘" + word + "’");
        } else if (newWordProxy.getLoseCount() > DrillConfig.LOSE_MIN_COUNT) {
            float scale = (newWordProxy.getLoseCount() - 1f) / (DrillConfig.LOSE_MAX_COUNT - DrillConfig.LOSE_MIN_COUNT);
            String word = StringUtil.randomShow(newWordProxy.getWord(), scale, seed);
            output("提示‘" + word + "’");
        }
    }

    /**
     * 报告
     */
    private void testReport() {
        if (loseDrillCount + this.successDrillCount != 0) {
            float accuracy = (this.successDrillCount + 0) / (this.loseDrillCount + this.successDrillCount + 0f);
            int i = 0;
            output("#######################训练报告##########################");
            output("本次测试正确率为" + StringUtil.format2(accuracy * 100) + "%");
            output("成功数" + this.successDrillCount + ",失败数" + this.loseDrillCount + ".");
            output("错误单词TOP10");
            for (Map.Entry<NewWordProxy, Integer> nwp : loseWord.entrySet()) {
                i++;
                if (i > 10) {
                    break;
                }
                output("'" + nwp.getKey().getWord() + "'错误" + nwp.getValue() + "次。");
            }
            output("#######################################################");
            this.loseDrillCount = 0;
            this.successDrillCount = 0;
        }
        loseWord.clear();
        this.examCount = 0;
    }


    /**
     * 爬虫报告
     */
    private void crawlReport() {
        if (loseDrillCount + this.successDrillCount != 0) {
            float accuracy = (this.successDrillCount + 0) / (this.loseDrillCount + this.successDrillCount + 0f);
            int i = 0;
            output("#######################爬虫训练报告##########################");
            output("本次测试正确率为" + StringUtil.format2(accuracy * 100) + "%");
            output("成功数" + this.successDrillCount + ",失败数" + this.loseDrillCount + ".");
            output("###########################################################");
            this.loseDrillCount = 0;
            this.successDrillCount = 0;
        }
        this.examCount = 0;
        //爬虫训练并不关心错误单词
//        loseWord.clear();
    }

    /**
     * 随机洗牌
     */
    private void shuffle() {
        output("现在重新洗牌。");
        if (wordList != null) {
            Collections.shuffle(wordList);
            wordIterator = wordList.iterator();
        }
    }
}
