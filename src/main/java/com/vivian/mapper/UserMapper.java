package com.vivian.mapper;

import org.apache.ibatis.annotations.Delete;


public interface UserMapper {


    @Delete("DELETE FROM  apiUser WHERE username = #{username}")
    int deleteUser(String username);
}
