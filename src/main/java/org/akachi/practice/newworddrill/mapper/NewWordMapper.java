package org.akachi.practice.newworddrill.mapper;

import org.akachi.practice.newworddrill.entity.NewWord;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface NewWordMapper {
    @Insert("insert into new_word ( " +
            "word, " +
            "phonetic_symbol, " +
            "chinese, " +
            "memory_time, " +
            "lethe_count," +
            "last_memory_time," +
            "create_time," +
            "success_count," +
            "flag" +
            ")  VALUES(#{word},#{phoneticSymbol},#{chinese},NOW(),0,NOW(),NOW(),0,#{flag})")
    public int insert(NewWord newWord);

    @Update("update new_word set " +
            "word=#{word}," +
            "phonetic_symbol=#{phoneticSymbol}," +
            "chinese=#{chinese}," +
            "memory_time=#{memoryTime}," +
            "last_lethe_time=#{lastLetheTime}," +
            "lethe_count=#{letheCount}," +
            "last_memory_time=#{lastMemoryTime}," +
            "create_time=#{createTime}," +
            "success_count=#{successCount} " +
            "where word=#{word} and flag=#{flag}")
    public int update(NewWord newWord);


    @Update("update new_word set " +
            "word=#{newWord.word}," +
            "phonetic_symbol=#{newWord.phoneticSymbol}," +
            "chinese=#{newWord.chinese}," +
            "memory_time=#{newWord.memoryTime}," +
            "last_lethe_time=#{newWord.lastLetheTime}," +
            "lethe_count=#{newWord.letheCount}," +
            "last_memory_time=#{newWord.lastMemoryTime}," +
            "create_time=#{newWord.createTime}," +
            "success_count=#{newWord.successCount} " +
            "where word=#{oldWord} and flag=#{oldFlag} ")
    public int updateByWord(NewWord newWord,String oldWord,String oldFlag);

    @Select("select * from new_word where word=#{word} and flag=#{flag}")
    public NewWord findWord(String word,String flag);


    @Select("select * from new_word where chinese=#{chinese} and flag=#{flag}")
    public List<NewWord> findWordByChinese(String chinese,String flag);

    @Select("select * from new_word where flag=#{flag}")
    public List<NewWord> findAll(String flag);

    @Select("select * from new_word where memory_time>#{beginDate} and memory_time<#{endDate} and flag=#{flag}")
    public List<NewWord> findAllByDay(LocalDate beginDate, LocalDate endDate,String flag);

    @Select("select * from new_word where last_lethe_time>#{beginDate} and last_lethe_time<#{endDate} and flag=#{flag}")
    public List<NewWord> findWrongByDay(LocalDate beginDate, LocalDate endDate,String flag);

    @Delete("delete from new_word where word=#{word} and flag=#{flag}")
    public int deleteWord(String word,String flag);
}
