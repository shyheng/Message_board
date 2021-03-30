package com.shy.mapper;

import com.shy.model.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {
    int deleteByPrimaryKey(String dateDay);

    int insert(Diary record);

    int insertSelective(Diary record);

    Diary selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKey(Diary record);
    List<Diary> selectAll(List<String> name);
}