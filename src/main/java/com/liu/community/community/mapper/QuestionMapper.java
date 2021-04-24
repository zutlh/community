package com.liu.community.community.mapper;

import com.liu.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void create(Question question);
    @Select("select * from question limit #{offSet},#{size}")
    List<Question> list(Integer offSet, Integer size);
    @Select("select count(1) from question")
    Integer count();
}
