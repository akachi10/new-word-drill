package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.command.ICommand;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.constant.DrillConstant;
import org.akachi.practice.newworddrill.entity.NewWordProxy;
import org.akachi.practice.newworddrill.util.PlayUtil;
import org.akachi.practice.newworddrill.util.StringUtil;

import java.util.*;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/10/1 19:54
 */
public class DrillCommand extends AbstractCommand implements ICommand {

    private int successDrillCount;
    private int loseDrillCount;

    private int examCount;

    private boolean isWait = false;

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
     * 训练某一天
     *
     * @param day
     */
    public void crawl(String day) {
        Integer dayInt = 0;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
        }
        init(dayInt);
        nextCrawl();
    }

    /**
     * 开始测试下一个
     */
    private void nextCrawl() {
        List<Integer> listInteger = DrillConfig.DRILL_CRAWL_ARRAY;
        //取消超过
        for (int i = 0; i < DrillConfig.DRILL_CRAWL_ARRAY.size(); i++) {
            Integer integer = listInteger.get(i);
            if (integer.intValue() >= wordList.size()) {
                listInteger.remove(i);
                i--;
            }
        }

        for (int i = 0; i < DrillConfig.DRILL_CRAWL_ARRAY.size(); i++) {

        }


//            if (newWordProxy == null) {
//            return;
//        }
//        nextCrawl(newWordProxy);
    }


    public static void main(String[] args) {
        DrillConfig drillConfig = new DrillConfig();
        drillConfig.setDRILL_CRAWL_ARRAY("0,1,2,3,4,6,9");
        List<Integer> listInteger = DrillConfig.DRILL_CRAWL_ARRAY;
        //取消超过
        for (int i = 0; i < DrillConfig.DRILL_CRAWL_ARRAY.size(); i++) {
            Integer integer = listInteger.get(i);
            if (integer.intValue() >= 20) {
                listInteger.remove(i);
                i--;
            }
        }
        int j = 0;
        for (int i = 0; i < listInteger.size(); i++) {
            if (listInteger.get(i) - listInteger.get(i) == 0) {
                j += (listInteger.get(i) - listInteger.get(i - 1));
            }
            System.out.println(j);
        }
    }

    /**
     * 测试主方法
     *
     * @param newWordProxy
     */
    private void nextCrawl(NewWordProxy newWordProxy) {
        List<Integer> seed = new ArrayList<>();
        nextCrawl(newWordProxy, seed);
    }

    /**
     * 测试单词
     *
     * @param newWordProxy
     */
    private void nextCrawl(NewWordProxy newWordProxy, List<Integer> seed) {
        progress();
        if (newWordProxy.getLoseCount() >= DrillConfig.AUDIO_PLAY_COUNT) {
            this.dictionary(newWordProxy.getWord(), newWordProxy.getChinese());
        } else {
            output("请输入'" + newWordProxy.getChinese() + "'的单词");
            output("请听写单词");
            PlayUtil.sound(newWordProxy.getWord(), this.isWait);
            this.isWait = false;
        }
        String wordTest = input();
        if (DrillConstant.TEST_END.equals(wordTest)) {
            testReport();
            return;
        }
        this.examCount++;
        if (newWordProxy.getWord().equals(wordTest)) {
            /*打印例句*/
            example(newWordProxy.getWord());
            /*测试成功则单词测试次数+1并且清零失败次数*/
            newWordProxy.setDrillCount(newWordProxy.getDrillCount() + 1);
            if (newWordProxy.getLoseCount() >= DrillConfig.AUDIO_PLAY_COUNT) {
                PlayUtil.sound(newWordProxy.getWord(), false);
                this.isWait = true;
                output("正确!");
            } else {
                output("正确听写'" + newWordProxy.getChinese() + "'");
            }
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
            nextCrawl();
        } else {
            /*如果测试失败记录失败次数并且递归重新测试*/
            output("错误请重新输入");
            newWordProxy.setLoseCount(newWordProxy.getLoseCount() + 1);
            /*判断是否需要提示*/
            hint(newWordProxy, seed);
            /*测试*/
            nextCrawl(newWordProxy, seed);
        }
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
        wrongInit(dayInt, daysInt);
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
     *
     * @param day
     */
    public void audio(String day) {
        while (true) {
            getNext();
            progress();
        }
    }

    /**
     * 获得下一个单词
     *
     * @return
     */
    private NewWordProxy getNext() {
        if (wordIterator.hasNext()) {
            NewWordProxy newWordProxy = wordIterator.next();
            return newWordProxy;
        } else {
            output("全部训练完成现在重置列表");
            testReport();
            if (wordList == null || wordList.size() == 0) {
                output("目前没有需要训练的单词");
                return null;
            }
            shuffle();
            wordIterator = wordList.iterator();
            return wordIterator.next();
        }
    }

    /**
     * 开始测试
     */
    private void next() {
        NewWordProxy newWordProxy = getNext();
        if (newWordProxy == null) {
            return;
        }
        test(newWordProxy);
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
        if (newWordProxy.getLoseCount() >= DrillConfig.AUDIO_PLAY_COUNT) {
            this.dictionary(newWordProxy.getWord(), newWordProxy.getChinese());
            output("请输入'" + newWordProxy.getChinese() + "'的单词");
        } else {
            output("请听写单词");
            PlayUtil.sound(newWordProxy.getWord(), this.isWait);
            this.isWait = false;
        }
        String wordTest = input();
        if (DrillConstant.TEST_END.equals(wordTest)) {
            testReport();
            return;
        }
        this.examCount++;
        if (newWordProxy.getWord().equals(wordTest)) {
            /*打印例句*/
            example(newWordProxy.getWord());
            /*测试成功则单词测试次数+1并且清零失败次数*/
            newWordProxy.setDrillCount(newWordProxy.getDrillCount() + 1);
            if (newWordProxy.getLoseCount() >= DrillConfig.AUDIO_PLAY_COUNT) {
                PlayUtil.sound(newWordProxy.getWord(), false);
                this.isWait = true;
                output("正确!");
            } else {
                output("正确听写'" + newWordProxy.getChinese() + "'");
            }
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
        NewWordProxy newWordProxy = getNext();
        if (newWordProxy == null) {
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
        this.dictionary(newWordProxy.getWord(), newWordProxy.getChinese());
        /*打印例句*/
        example(newWordProxy.getWord());
        output("正确翻译是'" + newWordProxy.getChinese() + "'，您们的翻译是" + wordTest + "");
        String flag = null;
        if (!newWordProxy.getChinese().equals(wordTest)) {
            PlayUtil.sound(newWordProxy.getWord(), false);
            //flag = input("如果输入正确请直接回车");
        }
        this.examCount++;
        if (null == flag || "".equals(flag)) {
            /*测试成功则单词测试次数+1并且清零失败次数*/
            newWordProxy.setDrillCount(newWordProxy.getDrillCount() + 1);
            /*如果这输入正确时计数器中的失败次数超过或等于最小失败次数则测试失败*/
            this.successDrillCount++;
            output("正确!");
            renext();
        } else {
            output("错误!");
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
