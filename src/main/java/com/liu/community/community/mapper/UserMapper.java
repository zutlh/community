package com.liu.community.community.mapper;

import com.liu.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.Cookie;


@Mapper
public interface UserMapper {
    @Insert("insert into user(name,token,account_id,gmtCreate,gmtModified) values(#{name},#{token},#{account_id},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
