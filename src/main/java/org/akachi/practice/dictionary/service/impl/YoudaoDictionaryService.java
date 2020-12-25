package org.akachi.practice.dictionary.service.impl;

import com.google.gson.*;
import org.akachi.practice.dictionary.controller.YoudaoConstant;
import org.akachi.practice.dictionary.service.DictionaryService;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.util.HttpUtil;
import org.akachi.practice.newworddrill.util.StringUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
                jsonObject.getAsJsonObject(YoudaoConstant.ERRORCODE).getAsInt() != YoudaoConstant.ERRORCODE_SUCCESS) {
            return null;
        }
        JsonArray explainsArray = this.getExplains(jsonObject);
        String explain = "";
        if (explainsArray != null) {
            explain = explainsArray.toString();
        } else {
            jsonObject.getAsJsonArray(YoudaoConstant.TRANSLATION);
        }

        return explain;
    }

    @Override
    public List<String> explainWeb(String phrase) {
        JsonObject jsonObject = getJsonObject(phrase);
        JsonArray web = jsonObject.getAsJsonArray("web");
        for (JsonElement elment : web) {
            String key = elment.getAsJsonObject().getAsJsonObject("key").getAsString();
            String value = elment.getAsJsonObject().getAsJsonArray("value").getAsString();
        }
        return null;
    }

    /**
     * 获得jsonobject
     *
     * @param phrase 请求
     * @return 返回值
     */
    private JsonObject getJsonObject(String phrase) {
        downloadJson(phrase);
        return null;
    }


    /**
     * 获得翻译
     *
     * @param jsonObject 整个对象
     * @return 翻译内容
     */
    private JsonArray getExplains(JsonObject jsonObject) {
        return jsonObject.getAsJsonObject(YoudaoConstant.BASIC).getAsJsonArray(YoudaoConstant.BASIC_EXPLAINS);

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
        try {
            File file = HttpUtil.downloadNet(url, DrillConfig.JSON_PATH, wordFileName);
            String json = getFileString(file);
            return new JsonParser().parse(json).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getFileString(File file) {
        String str = "";
        try {
            FileInputStream in = new FileInputStream(file);
            // size 为字串的长度 ，这里一次性读完
            int size = in.available();
            byte[] buffer = new byte[size];
            int read = in.read(buffer);
            in.close();
            str = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
