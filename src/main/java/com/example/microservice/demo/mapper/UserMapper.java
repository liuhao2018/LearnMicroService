package com.example.microservice.demo.mapper;

import com.example.microservice.demo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Delete("delete from user where id = #{id}")
    void deleteOneById(long id);
}
