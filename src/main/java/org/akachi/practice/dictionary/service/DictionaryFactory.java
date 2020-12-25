package org.akachi.practice.dictionary.service;

import org.akachi.practice.dictionary.controller.DictionaryController;
import org.akachi.practice.dictionary.service.impl.YoudaoDictionaryService;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;

/**
 * 词典工厂方法
 *
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/12/23 13:45
 */
public class DictionaryFactory {
    public static DictionaryService getDictionaryService(DictionaryController dc) {
        switch (dc) {
            case YOUDAO:
                return SpringApplicationContextHolder.getBean(YoudaoDictionaryService.class);
            default:
                return null;
        }
    }
}
