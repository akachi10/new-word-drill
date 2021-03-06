package org.akachi.practice.newworddrill.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author akachi
 */
@Data
public class NewWord {

    protected String word;
    protected String phoneticSymbol;
    protected String chinese;
    protected String flag;
    /**录入时间 一直用录入时间测试*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date memoryTime;
    /**最后失败时间 如果是今天那么今天的测试成功不会计入次数*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date lastLetheTime;
    /**最后成功(最后测试)*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date lastMemoryTime;
    /**创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date createTime;
    /**失败次数*/
    protected int letheCount;
    /**成功次数 成功次数-失败次数(小于0则为0)会决定下一次测试时间*/
    protected int successCount;

}
