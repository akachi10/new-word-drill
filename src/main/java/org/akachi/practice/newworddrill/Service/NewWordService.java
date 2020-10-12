package org.akachi.practice.newworddrill.Service;

import org.akachi.practice.newworddrill.entity.NewWord;
import org.akachi.practice.newworddrill.entity.NewWordProxy;
import org.akachi.practice.newworddrill.mapper.NewWordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("NewWordService")
public class NewWordService {

    @Autowired
    private NewWordMapper newWordMapper;

    /**
     * 更新Word
     * @param newWord 单词
     * @return 更新调数
     */
    public int update(NewWord newWord){
        return newWordMapper.update(newWord);
    }

    /**
     * 更新Word 包括主键
     * @param newWord 单词
     * @param oldWord 旧组件
     * @return 更新调数
     */
    public int update(NewWord newWord,String oldWord){
        return newWordMapper.updateByWord(newWord,oldWord);
    }
    /**
     * 插入一个新单词
     * @param word 单词
     */
    public void memoryWord(NewWord word) {
        newWordMapper.insert(word);
    }

    /**
     * 查询单词
     * @param word 单词
     * @return 单词对象
     */
    public NewWord findWord(String word) {
        return newWordMapper.findWord(word);
    }

    /**
     * 查询所有单词
     * @return 所有单词
     */
    public List<NewWord> findAll(){
        return newWordMapper.findAll();
    }

    /**
     * 查询单词按照中文 获得第一个
     * @param chinese 中文
     * @return 第一个符合的中文单词
     */
    public NewWord findWordByChinese(String chinese){
        List<NewWord> newWordList = newWordMapper.findWordByChinese(chinese);
        if(newWordList!=null&&newWordList.size()>0){
            return newWordList.get(0);
        }
        return null;
    }
    /**
     * 删除单词
     * @param word 单词
     * @return 删除几条 如果单词存在返回1
     */
    public int deleteWord(String word){
        return newWordMapper.deleteWord(word);
    }

    /**
     * 测试单词
     * @param newWord 单词
     * @param isSuccess 是否测试成功
     */
    public void reMemory(NewWord newWord,boolean isSuccess){
        if(NewWordProxy.getInstance(newWord).isRecordTestDay()) {
            if (isSuccess) {
                successMemory(newWord);
            } else {
                defeatedMemory(newWord);
            }
        }
    }
    /**
     * 成功
     * @param newWord 单词
     */
    private void successMemory(NewWord newWord){
        newWord.setLastMemoryTime(new Date());
        newWord.setSuccessCount(newWord.getSuccessCount()+1);
        newWord.setLastMemoryTime(new Date(System.currentTimeMillis()));
        newWordMapper.update(newWord);
    }
    /**
     * 失败
     * @param newWord 单词
     */
    private void defeatedMemory(NewWord newWord){
        newWord.setLastMemoryTime(new Date());
        newWord.setLetheCount(newWord.getLetheCount()+1);
        newWord.setLastLetheTime(new Date(System.currentTimeMillis()));
        newWordMapper.update(newWord);
    }
}
