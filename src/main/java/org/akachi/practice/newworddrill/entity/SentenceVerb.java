package org.akachi.practice.newworddrill.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2022/7/16 23:31
 */
@Data
public class SentenceVerb {
    private Integer id;
    private String name;
    private String verb;
    //过去式
    private String pastTense;
    //过去分词
    private String passParticiple;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
