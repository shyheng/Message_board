package com.shy.mapper;

import com.shy.model.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
public interface RolesMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Roles record);

    int insertSelective(Roles record);

    Set<String> selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}