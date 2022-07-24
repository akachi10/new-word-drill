package org.akachi.practice.newworddrill.mapper;

import org.akachi.practice.newworddrill.entity.SentenceVerb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SentenceVerbMapper {

    @Select("select * from T_SENTENCE_VERB")
    List<SentenceVerb> findAll();
}