package com.shy.mapper;

import com.shy.model.Personal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalMapper {
    int deleteByPrimaryKey(String phone);

    int insert(Personal record);

    int insertSelective(Personal record);

    Personal selectByPrimaryKey(String Phone);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);
}