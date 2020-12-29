package org.akachi.practice.dictionary.service.impl;

import com.google.gson.*;
import org.akachi.practice.dictionary.controller.YoudaoConstant;
import org.akachi.practice.dictionary.service.DictionaryService;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.constant.DrillConstant;
import org.akachi.practice.newworddrill.util.FileUtil;
import org.akachi.practice.newworddrill.util.HttpUtil;
import org.akachi.practice.newworddrill.util.StringUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/12/23 14:30
 */
@Service("YoudaoDictionaryService")
public class YoudaoDictionaryService implements DictionaryService {

    @Override
    public String explain(String phrase) {
        JsonObject jsonObject = getJsonObject(phrase);
        if (jsonObject == null ||
                jsonObject.getAsJsonPrimitive(YoudaoConstant.ERRORCODE).getAsInt() != YoudaoConstant.ERRORCODE_SUCCESS) {
            return null;
        }
        JsonArray explainsArray = this.getExplains(jsonObject);
        String explain = "";
        if (explainsArray != null) {
            explain = explainsArray.toString();
        } else if (jsonObject.getAsJsonArray(YoudaoConstant.TRANSLATION) != null) {
            explain = jsonObject.getAsJsonArray(YoudaoConstant.TRANSLATION).toString();
        }
        return explain;
    }

    @Override
    public List<String> explainWeb(String phrase) {
        JsonObject jsonObject = getJsonObject(phrase);
        JsonArray web = jsonObject.getAsJsonArray("web");
        List<String> list = new ArrayList<>();
        for (JsonElement elment : web) {
            String key = elment.getAsJsonObject().getAsJsonPrimitive("key").getAsString();
            String value = elment.getAsJsonObject().getAsJsonArray("value").toString();
            list.add(key + ";翻译:" + value);
        }
        return list;
    }

    /**
     * 获得jsonobject
     *
     * @param phrase 请求
     * @return 返回值
     */
    private JsonObject getJsonObject(String phrase) {
        return downloadJson(phrase);
    }


    /**
     * 获得翻译
     *
     * @param jsonObject 整个对象
     * @return 翻译内容
     */
    private JsonArray getExplains(JsonObject jsonObject) {
        if (jsonObject.getAsJsonObject(YoudaoConstant.BASIC) != null) {
            return jsonObject.getAsJsonObject(YoudaoConstant.BASIC).getAsJsonArray(YoudaoConstant.BASIC_EXPLAINS);
        }
        return null;
    }

    /**
     * 存储文件
     *
     * @param word 存储单词
     * @return 返回json
     */
    private JsonObject downloadJson(String word) {
        String urlWord = StringUtil.replaceUrl(word);
        String saveWord = StringUtil.replaceSaveFileName(word);
        String wordFileName = saveWord + DrillConstant.JSON_SUFFIX;
        String url = DrillConfig.DRILL_WORD_EXPLAIN_DICTIONARY_URL + urlWord;
        File file = null;
        try {
            file = HttpUtil.downloadNet(url, DrillConfig.JSON_PATH, wordFileName);
            String json = FileUtil.getFileString(file);
            return new JsonParser().parse(json).getAsJsonObject();
        } catch (JsonSyntaxException e) {
            System.out.println("[YoudaoDictionaryException]:单词" + word + "无法正确转换为json，系统会自动删除无需处理");
            if (file != null && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
