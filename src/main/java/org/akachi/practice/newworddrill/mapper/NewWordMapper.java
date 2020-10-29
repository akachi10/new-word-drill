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
            "last_lethe_time, " +
            "lethe_count," +
            "last_memory_time," +
            "success_count" +
            ")  VALUES(#{word},#{phoneticSymbol},#{chinese}, NOW(),NOW(),0,NOW(),0)")
    public int insert(NewWord newWord);

    @Update("update new_word set " +
            "word=#{word}," +
            "phonetic_symbol=#{phoneticSymbol}," +
            "chinese=#{chinese}," +
            "memory_time=#{memoryTime}," +
            "last_lethe_time=#{lastLetheTime}," +
            "lethe_count=#{letheCount}," +
            "last_memory_time=#{lastMemoryTime}," +
            "success_count=#{successCount} " +
            "where word=#{word}")
    public int update(NewWord newWord);


    @Update("update new_word set " +
            "word=#{newWord.word}," +
            "phonetic_symbol=#{newWord.phoneticSymbol}," +
            "chinese=#{newWord.chinese}," +
            "memory_time=#{newWord.memoryTime}," +
            "last_lethe_time=#{newWord.lastLetheTime}," +
            "lethe_count=#{newWord.letheCount}," +
            "last_memory_time=#{newWord.lastMemoryTime}," +
            "success_count=#{newWord.successCount} " +
            "where word=#{oldWord}")
    public int updateByWord(NewWord newWord,String oldWord);

    @Select("select * from new_word where word=#{word}")
    public NewWord findWord(String word);


    @Select("select * from new_word where chinese=#{chinese}")
    public List<NewWord> findWordByChinese(String chinese);

    @Select("select * from new_word")
    public List<NewWord> findAll();


    @Select("select * from new_word where memory_time>#{beginDate} and memory_time<#{endDate}")
    public List<NewWord> findAllByDay(LocalDate beginDate, LocalDate endDate);

    @Delete("delete from new_word where word=#{word}")
    public int deleteWord(String word);
}
