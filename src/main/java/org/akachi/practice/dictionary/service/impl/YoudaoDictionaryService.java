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
    public String phonetic(String word) {
        JsonObject jsonObject = getJsonObject(word);
        if (jsonObject == null
                || jsonObject.getAsJsonObject(YoudaoConstant.BASIC) == null
                || jsonObject.getAsJsonObject(YoudaoConstant.BASIC).getAsJsonPrimitive(YoudaoConstant.PHONETIC) == null
        ) {
            return null;
        }
        String phonetic = jsonObject.getAsJsonObject(YoudaoConstant.BASIC).getAsJsonPrimitive(YoudaoConstant.PHONETIC).getAsString();
        return phonetic;
    }

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
        return explain.toLowerCase().replace(phrase.toLowerCase(), "");
    }

    @Override
    public List<String> explainWeb(String phrase) {
        try {
            JsonObject jsonObject = getJsonObject(phrase);
            if (jsonObject == null) {
                return null;
            }
            JsonArray web = jsonObject.getAsJsonArray("web");
            if (web != null && web.size() > 0) {
                List<String> list = new ArrayList<>();
                for (JsonElement elment : web) {
                    String key = elment.getAsJsonObject().getAsJsonPrimitive("key").getAsString();
                    String value = elment.getAsJsonObject().getAsJsonArray("value").toString();
                    list.add(key + ";翻译:" + value);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得jsonobject
     *
     * @param phrase 请求
     * @return 返回值
     */
    public JsonObject getJsonObject(String phrase) {
        File file = downloadJson(phrase);
        String json = FileUtil.getFileString(file);
        JsonObject jsonObject = null;
        try {
            jsonObject = new JsonParser().parse(json).getAsJsonObject();
        } catch (Exception e) {

            file.delete();
        }
        return jsonObject;
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
    private File downloadJson(String word) {
        String urlWord = StringUtil.replaceUrl(word);
        String saveWord = StringUtil.replaceSaveFileName(word);
        String wordFileName = saveWord + DrillConstant.JSON_SUFFIX;
        String url = getDictionaryUrl() + urlWord;
        File file = null;
        try {
            file = HttpUtil.downloadNet(url, DrillConfig.JSON_PATH, wordFileName);
            return file;
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

    /**
     * 获得词典地址
     *
     * @return
     */
    private String getDictionaryUrl() {
        String url = DrillConfig.DICTIONARY_URL;
        String[] keyFroms = DrillConfig.DICTIONARY_KEYFROM.split(",");
        String[] keys = DrillConfig.DICTIONARY_KEY.split(",");
        Integer rand = new Double(Math.random() * keyFroms.length).intValue();
        url = url.replace("$keyfrom", keyFroms[rand]);
        url = url.replace("$key", keys[rand]);
        return url;
    }
}
