package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.newworddrill.Service.NewWordService;
import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.command.ICommand;
import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.entity.NewWord;
import org.akachi.practice.newworddrill.entity.NewWordProxy;
import org.akachi.practice.newworddrill.util.JSONChangeUtil;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akachi
 */
public class WordCommand extends AbstractCommand implements ICommand {

    private static NewWordService newWordService = (NewWordService) SpringApplicationContextHolder.getBean(NewWordService.class);

//    /**
//     * 开始创建单词
//     */
//    public void create(){
//        NewWord newWord = new NewWord();
//        newWord.setWord(input("清输入单词"));
//        /*newWord.setPhoneticSymbol(input("清输入音标"));*/
//        newWord.setChinese(input("清输入中文翻译"));
//        save(newWord);
//    }

    /**
     * 开始创建单词
     * @param word 单词
     */
    private void insert(String word){
        NewWord newWord = new NewWord();
        if(word!=null&&word.length()>0){
            word = word.replace("_"," ");
        }
        newWord.setWord(word);
       /*newWord.setPhoneticSymbol(input("请输入音标"));*/
        newWord.setChinese(input("请输入"+word+"中文翻译"));
        show(newWord);
        String s = input("是否存储?y/n");
        if(DrillConstant.YES.equals(s)) {
            save(newWord);
        }
    }

    /**
     * 插入单词
     * @param word 单词
     */
    public void i(String word){
        insert(word);
    }

    /**
     * 显示单词
     */
    private void show(NewWord newWord){
        String s = JSONChangeUtil.objToJson(newWord);
        if(newWord==null){
            output("单词不存在");
        }else {
            output("单词:" + s);
        }
    }

    /**
     * 保存这个单词
     */
    private void save(NewWord newWord){
        try {
            NewWord findWord = newWordService.findWord(newWord.getWord());
            if(findWord!=null){
                output("单词'"+findWord.getWord()+"'已存在");
                return;
            }
            newWordService.memoryWord(newWord);
            newWord = newWordService.findWord(newWord.getWord());
        }catch(Exception e){
            if (newWord == null) {
                output("尚未开始创建单词");
            } else {
                output("关键参数错误 "+JSONChangeUtil.objToJson(newWord));
            }
        }
        show(newWord);
    }

    /**
     * 打印单词列表
     * @param day
     */
    public void list(String day){
        Integer dayInt = null;
        try {
            dayInt = Integer.parseInt(day);
        }catch (Exception e){
            output("请输入数字!");
        }
        newWordService.findWordByTime(dayInt).forEach(word->{
            output(word.getWord()+"\t\t"+word.getChinese()+";");
        });
    }


    /**
     * 查看特定单词
     * @param word
     */
    public void find(String word){
        output("查询特定单词 "+JSONChangeUtil.objToJson(word));
        NewWord newWord = newWordService.findWord(word);
        show(newWord);
    }


    public void delete(String word){
        if(newWordService.deleteWord(word)==0){
            output("单词'"+word+"'不存在");
        }else{
            output("已经删除单词'"+word+"'");
        }
    }
    /**
     * 修改所有参数
     */
    public void alter(String word){
        NewWord newWord =  newWordService.findWord(word);
        if(newWord==null){
            output("单词'"+word+"'不存在");
        }else {
            newWord.setWord(input("清输入单词", newWord.getWord()));
            newWord.setPhoneticSymbol(input("清输入音标", newWord.getPhoneticSymbol()));
            newWord.setChinese(input("清输入中文翻译", newWord.getChinese()));
            newWordService.update(newWord,word);
            show(newWord);
        }
    }

//    /**
//     * 修改单词
//     */
//    public void alterWord(){
//        newWord.setWord(input("清输入单词"));
//    }
//
//    /**
//     * 修改音标
//     */
//    public void alterPhoneticSymbol(){
//        newWord.setPhoneticSymbol(input("清输入音标"));
//    }
//
//    /**
//     * 修改中文
//     */
//    public void alterChinese(){
//        newWord.setChinese(input("清输入中文翻译"));
//    }

    @Override
    public String introduce() {
        return "操作生词";
    }
}
