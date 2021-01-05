package org.akachi.practice.newworddrill.controller;

import org.akachi.practice.dictionary.service.impl.YoudaoDictionaryService;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.constant.DrillConstant;
import org.akachi.practice.newworddrill.util.HttpUtil;
import org.akachi.practice.newworddrill.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URLEncoder;

/**
 * 单词控制器
 */
@Controller
@RestController("/word")
public class WordController {

    @Autowired
    private YoudaoDictionaryService youdaoDictionaryService;

    /**
     * 获取单词
     *
     * @param word 单词
     * @return 单词音频
     */
    @RequestMapping("/getSound")
    public void getSound(HttpServletResponse response, String word) throws MalformedURLException {
        String url_word = StringUtil.replaceUrl(word);
        int type = new Double(Math.random() * DrillConstant.AUDIO_TYPE_COUNT).intValue() + 1;
        String saveWord = StringUtil.replaceSaveFileName(word);
        String wordFileName = type + DrillConstant.UNDERLINE + saveWord + DrillConstant.AUDIO_SUFFIX;
        String url = DrillConfig.SOUND_PREFIX + type + DrillConfig.SOUND_SUFFIX + url_word;
        File file = HttpUtil.downloadNet(url, DrillConfig.AUDIO_PATH, wordFileName);
        downFile(file, response);
    }

    /**
     * 下载单词json
     *
     * @param word 单词
     * @return json文件
     */
    @RequestMapping("/getTranslator")
    public String getTranslator(String word) {
        if (youdaoDictionaryService.getJsonObject(word) != null) {
            return youdaoDictionaryService.getJsonObject(word).toString();
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param file
     * @param response
     */
    private void downFile(File file, HttpServletResponse response) {
        if (file.exists()) {
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            try {
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                System.out.println("Download the song failed!");
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
