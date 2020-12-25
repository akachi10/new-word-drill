package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.newworddrill.Service.NewWordService;
import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.command.ICommand;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.entity.NewWord;
import org.akachi.practice.newworddrill.util.JSONChangeUtil;
import org.akachi.practice.newworddrill.util.PlayUtil;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;

import java.util.List;

/**
 * @author akachi
 */
public class WordCommand extends AbstractCommand implements ICommand {

    private static NewWordService newWordService = (NewWordService) SpringApplicationContextHolder.getBean(NewWordService.class);

    /**
     * 开始创建单词
     *
     * @param word 单词
     */
    private void insert(String word) {
        NewWord newWord = new NewWord();
        newWord.setFlag(DrillConfig.FLAG);
        if (word != null && word.length() > 0) {
            word = word.replace("_", " ");
        }
        newWord.setWord(word);
        /*newWord.setPhoneticSymbol(input("请输入音标"));*/
        PlayUtil.sound(word, false);
        newWord.setChinese(input("请输入" + word + "中文翻译"));
        show(newWord);
        String s = input("是否存储(回车同yes)?y/n");
        if (DrillConstant.YES.equals(s) || "".equals(s) || s == null) {
            save(newWord);
        }
    }

    /**
     * 插入单词
     *
     * @param word 单词
     */
    public void i(String word) {
        insert(word);
    }

    /**
     * 显示单词
     */
    private void show(NewWord newWord) {
        String s = JSONChangeUtil.objToJson(newWord);
        if (newWord == null) {
            output("单词不存在");
        } else {
            output("单词:" + s);
        }
    }

    /**
     * 保存这个单词
     */
    private void save(NewWord newWord) {
        try {
            NewWord findWord = newWordService.findWord(newWord.getWord());
            if (findWord != null) {
                output("单词'" + findWord.getWord() + "'已存在");
                return;
            }
            newWordService.memoryWord(newWord);
            newWord = newWordService.findWord(newWord.getWord());
        } catch (Exception e) {
            e.printStackTrace();
            if (newWord == null) {
                output("尚未开始创建单词");
            } else {
                output("关键参数错误 " + JSONChangeUtil.objToJson(newWord));
            }
        }
        show(newWord);
    }

    /**
     * 打印单词列表
     *
     * @param day
     */
    public void list(String day) {
        Integer dayInt = null;
        try {
            dayInt = Integer.parseInt(day);
        } catch (Exception e) {
            output("请输入数字!");
        }
        List<NewWord> list = newWordService.findWordByTime(dayInt);
        if (list != null && list.size() > 0) {
            output("这一天有" + list.size() + "个单词被录入。");
            list.forEach(word -> {
                output(word.getWord() + "\t\t" + word.getChinese() + ";");
            });
        } else {
            output("这一天有没有单词被录入。");
        }
    }


    /**
     * 查看特定单词
     *
     * @param word
     */
    public void f(String word) {
        output("查询特定单词 " + JSONChangeUtil.objToJson(word));
        NewWord newWord = newWordService.findWord(word);
        if (newWord == null) {
            output("单词不存在");
        } else {
            PlayUtil.sound(newWord.getWord(),false);
            output("单词:" + newWord.getWord());
            output("中文:" + newWord.getChinese());
            if (newWord.getPhoneticSymbol() != null && !"".equals(newWord.getPhoneticSymbol())) {
                output("音标:" + newWord.getPhoneticSymbol());
            }
        }
    }


    public void delete(String word) {
        if (newWordService.deleteWord(word) == 0) {
            output("单词'" + word + "'不存在");
        } else {
            output("已经删除单词'" + word + "'");
        }
    }

    /**
     * 修改所有参数
     *
     * @param word 单词
     */
    public void alter(String word) {
        NewWord newWord = newWordService.findWord(word);
        if (newWord == null) {
            output("单词'" + word + "'不存在");
        } else {
            newWord.setWord(input("请输入单词", newWord.getWord()));
            newWord.setPhoneticSymbol(input("请输入音标", newWord.getPhoneticSymbol()));
            newWord.setChinese(input("请输入中文翻译", newWord.getChinese()));
            newWordService.alter(newWord, word);
            show(newWord);
        }
    }

    @Override
    public String introduce() {
        return "操作生词=" + DrillConfig.FLAG;
    }
}
