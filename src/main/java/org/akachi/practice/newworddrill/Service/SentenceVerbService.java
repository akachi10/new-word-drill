package org.akachi.practice.newworddrill.Service;

import org.akachi.practice.newworddrill.entity.SentenceVerb;
import org.akachi.practice.newworddrill.mapper.SentenceVerbMapper;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2022/7/16 23:38
 */
@Service
public class SentenceVerbService {
    private static List<SentenceVerb> sentenceVerbs = new ArrayList<>();
    @Autowired
    SentenceVerbMapper sentenceVerbMapper;

    public List<SentenceVerb> getAllSentenceVerb() {
        return sentenceVerbMapper.findAll();
    }

    public static List<SentenceVerb> getSentenceVerbs() {
        SentenceVerbService sentenceVerbService = SpringApplicationContextHolder.getBean(SentenceVerbService.class);
        if (sentenceVerbs == null||sentenceVerbs.size()==0) {
            sentenceVerbs = sentenceVerbService.getAllSentenceVerb();
        }
        return sentenceVerbs;
    }
}
