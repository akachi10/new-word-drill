package org.akachi.practice.newworddrill.entity;

/**
 * @Author akachi
 * @Email zsts@hotmail.com
 * @Date 2022/7/16 22:37
 */
public enum Tense {
    /**
     * 现在时一般态、现在时完成态、现在时进行态、现在时完成进行态。
     * 过去时一般态、过去时完成态、过去时进行态、过去时完成进行态。
     * 将来时一般态、将来时完成态、将来时进行态、将来时完成进行态。
     * 过去将来时一般态、过去将来时完成态、过去将来时进行态、过去将来时完成进行态。
     */
    PRESENT_SIMPLE_TENSE(0,"现在时一般态"),
    PRESENT_PERFECT_TENSE(1,"现在时完成态"),
    PRESENT_PROGRESSIVE_TENSE(2,"现在时进行态"),
    PRESENT_PERFECT_PROGRESSIVE_TENSE(3,"现在时完成进行态"),
    PAST_SIMPLE_TENSE(4,"过去时一般态"),
    PAST_PERFECT_TENSE(5,"过去时完成态"),
    PAST_PROGRESSIVE_TENSE(6,"过去时进行态"),
    PAST_PERFECT_PROGRESSIVE_TENSE(7,"过去时完成进行态"),
    FUTURE_SIMPLE_TENSE(8,"将来时一般态"),
    FUTURE_PERFECT_TENSE(9,"将来时完成态"),
    FUTURE_PROGRESSIVE_TENSE(10,"将来时进行态"),
    FUTURE_PERFECT_PROGRESSIVE_TENSE(11,"将来时完成进行态"),
    PAST_FUTURE_SIMPLE_TENSE(12,"过去将来时一般态"),
    PAST_FUTURE_PERFECT_TENSE(13,"过去将来时完成态"),
    PAST_FUTURE_PROGRESSIVE_TENSE(14,"过去将来时进行态"),
    PAST_FUTURE_PERFECT_PROGRESSIVE_TENSE(15,"过去将来时完成进行态");

    private Integer key;
    private String name;
    Tense(Integer key,String name){
        this.key=key;
        this.name=name;
    }
    public Integer getKey(){
        return key;
    }
    public String getName(){
        return this.name;
    }
    public static Tense getTenseByKey(Integer key){
        for (Tense tense:Tense.values()) {
            if(tense.getKey() == key){
                return tense;
            }
        }
        return null;
    }
}
