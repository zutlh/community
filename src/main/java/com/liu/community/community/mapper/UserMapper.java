package com.liu.community.community.mapper;

import com.liu.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;





@Mapper
public interface UserMapper {
    @Insert("insert into user(name,token,account_id,gmtCreate,gmtModified) values(#{name},#{token},#{account_id},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
