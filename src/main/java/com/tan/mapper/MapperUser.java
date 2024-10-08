package com.tan.mapper;

import com.tan.dto.UpdateUserDTO;
import com.tan.entity.EntityUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MapperUser {

    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("insert into user (username, email, password, avatar_url, update_time) value (#{username},#{email},#{password},#{avatarUrl},#{updateTime})")
    void save(EntityUser user1);

    @Select("select * from user where email = #{email}")
    EntityUser getUserByEmail(String email);
    @Select("select * from user where username = #{username}")
    EntityUser getUserByUsername(String username);

    @Select("select * from user")
    List<EntityUser> list();

    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("insert into user (username,email,update_time) value (#{username},#{email},now())")
    void add(EntityUser user);


    void update(EntityUser user);

    @Select("select * from user where user_id=#{userId}")
    EntityUser getUserById(Integer userId);
    @Delete("delete from user where user_id=#{id}")
    void delete(Integer id);
}
