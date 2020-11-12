package org.akachi.practice.newworddrill.controller;

import org.akachi.practice.newworddrill.Service.NewWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词控制器
 */
@Service
public class WordController {
    @Autowired
    NewWordService newWordService;

    private static Map<String, String> commandMap = new HashMap<>();

    static {
        commandMap.put("hellp", "hellp");
    }

}
