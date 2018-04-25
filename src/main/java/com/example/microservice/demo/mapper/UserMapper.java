package com.example.microservice.demo.mapper;

import com.example.microservice.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user (name,sex,mobile) values (#{name},#{sex},#{mobile})")
    void saveOne(User user);

    @Update("update user set name=#{name},sex=#{sex},mobile=#{mobile} where id = #{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void deleteOneById(long id);
}
