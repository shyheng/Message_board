package com.shy.mapper;

import com.shy.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UsersMapper {
    int insert(Users users);
    Users selectByPrimaryKey(String username);
    int deleteByPrimaryKey(String username);
    int updateByPrimaryKey(Users users);
}