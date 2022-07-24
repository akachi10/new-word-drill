package org.akachi.practice.newworddrill.command.operate;

import org.akachi.practice.dictionary.service.DictionaryService;
import org.akachi.practice.dictionary.service.impl.YoudaoDictionaryService;
import org.akachi.practice.newworddrill.Service.SentenceVerbService;
import org.akachi.practice.newworddrill.command.AbstractCommand;
import org.akachi.practice.newworddrill.constant.DrillConstant;
import org.akachi.practice.newworddrill.entity.SentenceVerb;
import org.akachi.practice.newworddrill.entity.Tense;
import org.akachi.practice.newworddrill.util.PlayUtil;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2022/7/16 22:25
 */
public class SentenceCommand extends AbstractCommand {
    private static final List<String> PERSONS = Arrays.asList(new String[]{"you","I","she","he","they","it","we"});
    @Override
    public String introduce() {
        return "造句训练";
    }
    public void test(){
        output("可以通过\"testEnd\"结束造句训练");
        output("开始造句训练:");
        while (true){
            Integer key = new Double(Math.random() * 16).intValue();
            Collections.shuffle(PERSONS);
            Collections.shuffle(SentenceVerbService.getSentenceVerbs());
            SentenceVerb sentenceVerb = SentenceVerbService.getSentenceVerbs().get(0);
            output("人称:"+ PERSONS.get(0));
            output("动词:"+sentenceVerb.toString());
            String sentence = input("请造一个\""+ Objects.requireNonNull(Tense.getTenseByKey(key)).getName() +"\"的句子:");
            if(DrillConstant.TEST_END.equals(sentence)){
                output("结束造句训练");
                this.help();
                return;
            }else if(sentence==null){
                continue;
            }
            PlayUtil.sound(sentence,true);
            output("你造的句子是:\""+sentence+"\"");
            String translation= dictionaryService.explain(sentence);
            output("译文是:\""+translation+"\"");
        }
    }

    protected DictionaryService dictionaryService = SpringApplicationContextHolder.getBean(YoudaoDictionaryService.class);
}
