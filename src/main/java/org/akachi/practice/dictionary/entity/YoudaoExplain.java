package org.akachi.practice.dictionary.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2020/12/23 13:50
 */
@Data
public class YoudaoExplain {
    private String query;
    private Integer errorCode;
    private List<String> translation = new ArrayList<>();
    private Map<String, String> basic = new HashMap<>();
    private Map<String, List<String>> web = new HashMap<>();

}
