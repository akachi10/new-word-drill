package org.akachi.practice.dictionary.service;

import java.util.List;

/**
 * 词典服务
 *
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/12/23 13:44
 */

public interface DictionaryService {

    /**
     * 翻译词典
     *
     * @param phrase 单词或句子
     * @return 单词或句子
     */
    String explain(String phrase);

    /**
     * 获得英文例句
     *
     * @param phrase 单词或句子
     * @return 单词或句子以及联想内容
     */
    List<String> explainWeb(String phrase);


}
