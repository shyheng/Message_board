package com.shy.mapper;

import com.shy.model.Permissions;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Set<String> selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}